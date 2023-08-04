package jpa.libreria;

import java.util.InputMismatchException;
import java.util.Scanner;
import jpa.libreria.Logica.ControladoraLogica;
import jpa.libreria.Logica.Libro;
import jpa.libreria.Logica.Prestamo;
import jpa.libreria.Logica.Services.AutorService;
import jpa.libreria.Logica.Services.ClienteService;
import jpa.libreria.Logica.Services.EditorialService;
import jpa.libreria.Logica.Services.LibroService;
import jpa.libreria.Logica.Services.PrestamoService;
import jpa.libreria.Logica.Services.Service;

public class Libreria {

    public static void main(String[] args) throws Exception {

        ControladoraLogica controlLogica = new ControladoraLogica();

        try {
            menu(controlLogica);
        } catch (Exception e) {
            throw e;
        }

    }

    public static void menu(ControladoraLogica controlLogica) throws Exception {

        Scanner sc = new Scanner(System.in);

        AutorService autorS = new AutorService();
        EditorialService editorialS = new EditorialService();
        LibroService libroS = new LibroService();
        PrestamoService prestamoS = new PrestamoService();
        ClienteService clienteS = new ClienteService();
        Service service = new Service();

        boolean exit = false;

        while (!exit) {

            System.out.println("-----------------------");
            System.out.println("|    MENU LIBRERIA    |");
            System.out.println("-----------------------");

            System.out.println("1. Ingresar nuevo libro");
            System.out.println("2. Ingresar nuevo autor");
            System.out.println("3. Ingresar nueva editorial");
            System.out.println("4. Buscar libro por nombre");
            System.out.println("5. Buscar libro por isbn");
            System.out.println("6. Buscar autor por nombre");
            System.out.println("7. Buscar libro por autor");
            System.out.println("8. Buscar libro por editorial");
            System.out.println("9. Dar de alta/baja");
            System.out.println("10. Nuevo cliente");
            System.out.println("11. Nuevo Prestamo");
            System.out.println("12. Devolucion libro");
            System.out.println("22. Salir");

            Integer option = null;
            try {
                option = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println("Caracter erroneo");
                menu(controlLogica);
            }

            switch (option) {
                case 1:
                    try {
                    controlLogica.crearLibro(libroS.crearLibro());
                } catch (Exception e) {
                    throw e;
                }
                break;

                case 2:                
                try {
                    controlLogica.crearAutor(autorS.crearAutor());
                } catch (Exception e) {
                    throw e;
                }
                break;

                case 3:
                try {
                    controlLogica.crearEditorial(editorialS.crearEditorial());
                } catch (Exception e) {
                    throw e;
                }

                break;

                case 4:
                    try {
                    service.recorrerArray(controlLogica.findLibroByName(libroS.pedirNombreLibro()));
                } catch (Exception e) {
                    System.out.println("Error en el sistema");
                    menu(controlLogica);
                }
                break;

                case 5:
                    try {
                    System.out.println(controlLogica.traerLibro(libroS.pedirIdLibro()).toString());
                    //                        controlLogica.traerLibro(libroS.pedirIdLibro()).toString();
                    ;
                } catch (InputMismatchException e) {
                    System.out.println("error en el sistema");
                    menu(controlLogica);
                }
                break;

                case 6:
                    service.recorrerArray(controlLogica.findAutorByName(autorS.pedirNombreAutor()));
                    break;

                case 7:
                    try {
                    service.recorrerArray(controlLogica.findLibroByAutorName(autorS.pedirNombreAutor()));
                } catch (Exception e) {
                    System.out.println("Error en el sistema");
                    menu(controlLogica);
                }
                break;

                case 8:
                    try {
                    service.recorrerArray(controlLogica.findLibroByEditorial(editorialS.pedirNombreEditorial()));
                } catch (Exception e) {
                    System.out.println("Error en el sistema");
                    menu(controlLogica);
                }
                break;
                case 9:
                   try {
                    libroS.modificarAlta();
                } catch (InputMismatchException e) {
                    System.out.println("Caracter Erroneo");
//                    menu(controlLogica);
                } catch (Exception e) {

                    System.out.println("Error del sistema");
                    menu(controlLogica);
                }
                break;

                case 10:
                    try {
                    controlLogica.crearCliente(clienteS.crearCliente());
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error en el sistema");
                }
                break;

                case 11:
                    try {
                    Prestamo prestamo = null;
                    prestamo = prestamoS.crearPrestamo();
                    //Libro libro = prestamo.getLibro();
                    
                    controlLogica.crearPrestamo(prestamo);
                    Libro libroPrestado = prestamo.getLibro();
                    libroPrestado.setEjemplaresPrestados(libroPrestado.getEjemplaresPrestados()+ 1);
                    libroPrestado.setEjemplaresRestantes(libroPrestado.getEjemplaresRestantes() - 1);
                    controlLogica.editarLibro(libroPrestado);
                } catch (Exception e) {
                    System.out.println("Error");
                }
                break;
                
                case 12:
                    prestamoS.devolucionLibro();
                    break;
                case 22:
                    exit = true;

                    break;

            }
        }
    }
}
