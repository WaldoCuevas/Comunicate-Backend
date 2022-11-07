package tup.comunicatebackend.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Imagen {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //Este id representa el id de nuestra Base de datos.

    private String nombre;

    private String ImageUrl;

    private String ImageId;//Este id representa el id de Cloudinary.

    public Imagen(String nombre, String imageUrl, String imageId) {
        this.nombre = nombre;
        ImageUrl = imageUrl;
        ImageId = imageId;
    }

}
