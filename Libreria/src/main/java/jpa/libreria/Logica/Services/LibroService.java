package jpa.libreria.Logica.Services;

import java.util.InputMismatchException;
import java.util.Scanner;
import jpa.libreria.Logica.Autor;
import jpa.libreria.Logica.ControladoraLogica;
import jpa.libreria.Logica.Editorial;
import jpa.libreria.Logica.Libro;

public class LibroService {

    Scanner sc = new Scanner(System.in);

    ControladoraLogica controlLog = new ControladoraLogica();
    AutorService autorS = new AutorService();
    EditorialService editorialS = new EditorialService();

    public Libro crearLibro() throws Exception {

        System.out.println("Ingrese isbn del libro");
        Long isbn = sc.nextLong();
        sc.nextLine();

        String titulo = null;
        do {
            System.out.println("Ingrese nombre del libro");
            titulo = sc.nextLine();
        } while (titulo.equalsIgnoreCase("") || titulo.equalsIgnoreCase(" "));

        System.out.println("Ingrese anio");
        Integer anio = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese cantidad de ejemplares");
        Integer cant = sc.nextInt();
        sc.nextLine();

        Integer prestados = 0;

        Integer restantes = cant;

        String rta;
        boolean alta;
        do {
            System.out.println("Desea dar de alta el libro? S/N");
            rta = sc.nextLine();
            alta = rta.equalsIgnoreCase("s");
        } while (!rta.equalsIgnoreCase("s") && !rta.equalsIgnoreCase("n"));

        Integer idAutor = null;
        Integer rtaAutor = null;
        while (idAutor == null || rtaAutor == null) {
            System.out.println("Como desea ingresar el autor del libro");
            System.out.println("1. Buscar autor");
            System.out.println("2. Ingresar nuevo autor");

            try {
                rtaAutor = sc.nextInt();
                sc.nextLine();

                switch (rtaAutor) {
                    case 1:
                        controlLog.traerListaAutores();
                        for (Autor autor : controlLog.traerListaAutores()) {
                            System.out.println(autor.toString());
                        }
                        System.out.println("Ingrese el id del autor que desea elegir o 0 si desea agregar uno nuevo");
                        idAutor = sc.nextInt();
                        sc.nextLine();
                        if (idAutor == 0) {
                            idAutor = null;
                        }
                        break;
                    case 2:
                        controlLog.crearAutor(autorS.crearAutor());
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Caracter invalido ingrese opcion valida");
                sc.nextLine();
                rtaAutor = null;
            }
        }

        Autor autor = controlLog.traerAutor(idAutor);

        Integer idEditorial = null;
        Integer rtaEditorial = null;
        while (idEditorial == null || rtaEditorial == null) {
            System.out.println("Editorial del libro");
            System.out.println("1. Buscar editorial");
            System.out.println("2. Ingresar nueva editorial");

            try {
                rtaEditorial = sc.nextInt();
                sc.nextLine();

                switch (rtaEditorial) {
                    case 1:
                        controlLog.traerListaEditoriales();
                        for (Editorial editorial : controlLog.traerListaEditoriales()) {
                            System.out.println(editorial.toString());
                        }
                        System.out.println("Ingrese id de la editorial que desea elegir o 0 si desea agregar una nueva");
                        idEditorial = sc.nextInt();
                        if (idEditorial == 0) {
                            idEditorial = null;
                        }
                        break;
                    case 2:
                        controlLog.crearEditorial(editorialS.crearEditorial());
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Caracter erroneo");
                sc.nextLine();
                rtaEditorial = null;
            }
        }
        Editorial editorial = controlLog.traerEditorial(idEditorial);

        return new Libro(isbn, titulo, anio, cant, prestados, restantes, alta, autor, editorial);
    }

    public String pedirNombreLibro() {
        System.out.println("Ingrese nombre del libro");
        String nombre = sc.nextLine();
        return nombre;
    }

    public Long pedirIdLibro() throws InputMismatchException {

        System.out.println("Ingrese id del libro");
        Long idLibro = sc.nextLong();
        sc.nextLine();
        return idLibro;

    }

    public void modificarAlta() throws InputMismatchException, Exception {
        Long idLibro = pedirIdLibro();

        Libro libro = controlLog.traerLibro(idLibro);
        System.out.print("El estado del libro: " + libro.getTitulo() + " se encuentra en : ");
        boolean estado;
        if (libro.getAlta()) {
            System.out.println("ALTA");
            estado = true;
        } else {
            System.out.println("BAJA");
            estado = false;
        }
        System.out.println("Desea cambiarlo? S/N");
        String rta = sc.nextLine();
        if (rta.equalsIgnoreCase("s")) {
            if (estado == true) {
                libro.setAlta(false);
            } else {
                libro.setAlta(true);
            }
            controlLog.editarLibro(libro);
        }

        
    }

}
