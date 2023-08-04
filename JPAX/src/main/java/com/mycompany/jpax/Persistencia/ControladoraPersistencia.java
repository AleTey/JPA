package com.mycompany.jpax.Persistencia;

import com.mycompany.jpax.Logica.Alumno;
import com.mycompany.jpax.Logica.Carrera;
import com.mycompany.jpax.Logica.Materia;
import com.mycompany.jpax.Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    AlumnoJpaController aluJpa = new AlumnoJpaController();
    CarreraJpaController carreraJpa = new CarreraJpaController();
    MateriaJpaController materiaJpa = new MateriaJpaController();
    
    //Alumno

    public void crearAlumno(Alumno alumno) {
        aluJpa.create(alumno);
    }

    public void eliminarAlumno(int id) {
        try {
            aluJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarAlumno(Alumno alumno) {
        try {
            aluJpa.edit(alumno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Alumno traerAlumno(int id) {
        return aluJpa.findAlumno(id);
    }

    public ArrayList<Alumno> traerListaAlumnos() {

        List<Alumno> lista = aluJpa.findAlumnoEntities();
        ArrayList<Alumno> listaAlumnos = new ArrayList<>(lista);
        return listaAlumnos;                
    }

    // Carrera
    
    public void crearCarrera(Carrera carrera) {
        carreraJpa.create(carrera);
    }

    public void eliminarCarrera(int id) {
        try {
            carreraJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarCarrera(Carrera carrera) {
        try {
            carreraJpa.edit(carrera);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Carrera traerCarrera(int id) {
        return carreraJpa.findCarrera(id);
    }

    public ArrayList<Carrera> traerListaCarrera() {
        List<Carrera> lista = carreraJpa.findCarreraEntities();
        ArrayList<Carrera> listaCarreras = new ArrayList<> (lista);
        return listaCarreras;
    }

    
    // Materia
    
    public void crearCarrera(Materia materia) {
        materiaJpa.create(materia);
    }

    public void eliminarMateria(int id) {
        try {
            materiaJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarMateria(Materia materia) {
        try {
            materiaJpa.edit(materia);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Materia traerMateria(int id) {
       return materiaJpa.findMateria(id);
    }

    public ArrayList<Materia> traerListaMateria() {
        List<Materia> lista = materiaJpa.findMateriaEntities();
        ArrayList<Materia> listaMaterias = new ArrayList(lista);
        return listaMaterias;
    }

}
