package utn.comunicate.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import utn.comunicate.Models.Imagen;
import utn.comunicate.Repository.ImagenRepository;

@Service
@Transactional
public class ImagenService {
    
    @Autowired
    ImagenRepository imagenRepository;

    public Imagen getImagenById(int id) {
        return imagenRepository.findById(id).get();
    }

    public List<Imagen> list () {
        return imagenRepository.findAll(); 
    }

    public Optional<Imagen> getOne (int id) {
        return imagenRepository.findById(id); 
    }

    public void save (Imagen imagen){
        imagenRepository.save(imagen);
    }

    public void delete (int id){
        imagenRepository.deleteById(id);;
    }

    public boolean exists (int id) {
        return imagenRepository.existsById(id); 
    }

}
