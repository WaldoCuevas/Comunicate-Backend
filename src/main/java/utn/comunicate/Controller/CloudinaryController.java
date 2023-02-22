package utn.comunicate.Controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import utn.comunicate.Models.Imagen;
import utn.comunicate.Service.CloudinaryService;
import utn.comunicate.Service.ImagenService;

@RestController
@RequestMapping("/cloudinary")
@CrossOrigin
public class CloudinaryController {

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ImagenService imagenService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Imagen> getImagenById(@PathVariable int id) {
        return ResponseEntity.ok().body(imagenService.getImagenById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Imagen>> list() {
        List<Imagen> list = imagenService.list();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile) throws IOException {

        // En caso de que la imagen no sea valida
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if (bi == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Map result = cloudinaryService.upload(multipartFile);
        Imagen imagen = new Imagen((String) result.get("original_filename"),
                (String) result.get("url"),
                (String) result.get("public_id"));
        imagenService.save(imagen);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) throws IOException {

        if (!imagenService.exists(id)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Imagen imagen = imagenService.getOne(id).get();
        Map result = cloudinaryService.delete(imagen.getImagen_id());
        imagenService.delete(id);
        return ResponseEntity.ok().body(result);
    }

}
