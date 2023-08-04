package com.mycompany.jpax;

import com.mycompany.jpax.Logica.Alumno;
import com.mycompany.jpax.Logica.Carrera;
import com.mycompany.jpax.Logica.ControladoraLogica;
import com.mycompany.jpax.Logica.Materia;
import java.util.Date;
import java.util.LinkedList;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.eclipse.persistence.exceptions.PersistenceUnitLoadingException;

public class JPAX {

    public static void main(String[] args) {

        ControladoraLogica controlLog = new ControladoraLogica();

        //crear lista materia 
        
//        LinkedList<Materia> listaMaterias = new LinkedList();

        //crear carrera con lista de materias
        
//        Carrera programacion = new Carrera(1, "Programacion", listaMaterias);

        //Guardar carrera en DB
        
//        controlLog.crearCarrera(programacion);

        // crear materias
        
//        Materia mate1 = new Materia(58, "ProgramacionI", "Cuatrimestral", programacion);
//        Materia mate2 = new Materia(59, "ProgramacionII", "Cuatrimestral", programacion);
//        Materia mate3 = new Materia(60, "ProgramacionAvanzada", "Anual", programacion);

        //guardar mate en BD
        
//        controlLog.crearMateria(mate1);
//        controlLog.crearMateria(mate2);
//        controlLog.crearMateria(mate3);

        //agregar materias a lista
        
//        listaMaterias.add(mate1);
//        listaMaterias.add(mate2);
//        listaMaterias.add(mate3);
//        
//        programacion.setMateria(listaMaterias);
//        controlLog.modificarCarrera(programacion);

        // creacion alumno
        
//        Alumno alumno = new Alumno(5, "Ale", "Cas", new Date(), programacion);
//        controlLog.crearAlumno(alumno);

        //mostrar resultado 
        
        System.out.println("---------------");
        System.out.println("DATOS ALUMNO");
        Alumno alu = controlLog.traerAlumno(5);
        System.out.println("Alumno: " + alu.getNombre() + alu.getApellido());
        System.out.println("Cursa la carrera: " + alu.getCarrera().getNombre());

//        System.out.println("Materias: ");

//EntityManager em = Persistence.createEntityManagerFactory("pruebaJPAPUU").createEntityManager();



    }
}
