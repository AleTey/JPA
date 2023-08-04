
package jpa.libreria.Logica;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Editorial implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nombre;
    private Boolean alta;
    @OneToOne(mappedBy = "editorial")
    private Libro libro;

    public Editorial() {
    }

    public Editorial(String nombre, Boolean alta) {
        this.nombre = nombre;
        this.alta = alta;
    }

    
//    public Editorial(Integer id, String nombre, Boolean alta, Libro libro) {
//        this.id = id;
//        this.nombre = nombre;
//        this.alta = alta;
//        this.libro = libro;
//    }

    public Editorial(Integer id, String nombre, Boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }
    
    

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

//    public Libro getLibro() {
//        return libro;
//    }
//
//    public void setLibro(Libro libro) {
//        this.libro = libro;
//    }

    @Override
    public String toString() {
        return "Editorial{" + "id=" + id + ", nombre=" + nombre + ", alta=" + alta + '}';
    }
    
    
}
