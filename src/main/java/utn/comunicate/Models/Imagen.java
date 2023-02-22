package utn.comunicate.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Imagen")
public class Imagen {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //Este id representa el id de nuestra Base de datos.

    private String nombre;

    private String imagen_url;

    private String Imagen_id;//Este id representa el id de Cloudinary.

    public Imagen(String nombre, String imagen_url, String Imagen_id) {
        this.nombre = nombre;
        this.imagen_url = imagen_url;
        this.Imagen_id = Imagen_id;
    }

}
