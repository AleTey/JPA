
package com.mycompany.jpax.Logica;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Carrera implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id_carrera;
    @Basic
    private String nombre;
    @OneToMany (mappedBy = "carrera")
    private LinkedList<Materia> listaMaterias;

    public Carrera() {
    }

    public Carrera(int id_carrera, String nombre, LinkedList<Materia> listaMaterias) {
        this.id_carrera = id_carrera;
        this.nombre = nombre;
        this.listaMaterias = listaMaterias;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setMateria(LinkedList<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    @Override
    public String toString() {
        return "Carrera{" + "id_carrera=" + id_carrera + ", nombre=" + nombre + ", materia=" + listaMaterias + '}';
    }

    

        
    

    
    
    
}
