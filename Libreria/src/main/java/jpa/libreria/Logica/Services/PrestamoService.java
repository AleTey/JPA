package jpa.libreria.Logica.Services;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import static jpa.libreria.Libreria.menu;
import jpa.libreria.Logica.Cliente;
import jpa.libreria.Logica.ControladoraLogica;
import jpa.libreria.Logica.Libro;
import jpa.libreria.Logica.Prestamo;
import jpa.libreria.Logica.Prestamo_;
import jpa.libreria.Persistencia.exceptions.NonexistentEntityException;

public class PrestamoService {

    Scanner sc = new Scanner(System.in);

    ControladoraLogica controlLog = new ControladoraLogica();
    LibroService libroS = new LibroService();
    AutorService autorS = new AutorService();
    EditorialService editorialS = new EditorialService();
    Service service = new Service();

    public Prestamo crearPrestamo() {

        //FECHA PRESTAMO
        System.out.println("Fecha del prestamo");
        System.out.println("1. Elegir fecha de hoy");
        System.out.println("2. Elegir otra fecha");
        int optionFecha = sc.nextInt();
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaPrestamo = null;
        while (fechaPrestamo == null) {
            switch (optionFecha) {
                case 1:
                    fechaPrestamo = fechaActual;
                    break;
                case 2:
                    try {
                    sc.nextLine();
                    System.out.println("Ingrese fecha aaaa/mm/dd");
                    String fecha = sc.nextLine();
                    fechaPrestamo = LocalDate.parse(fecha);
                } catch (Exception e) {
                    System.out.println("Fecha invalida");
                    sc.nextLine();
                }
                break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        }

        //ELEGIR LIBRO
        Long idL = null;
        Libro libro = null;
        boolean exit = false;
        while (libro == null && !exit) {

            System.out.println("Que libro desea prestar?");
            System.out.println("1. Ingresar ID");
            System.out.println("2. Buscar libro por nombre");
            System.out.println("3. Buscar libro por autor");
            System.out.println("4. Buscar libro por editorial");
            System.out.println("5. Salir");
            try {
                Integer option;
                option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1:
                        try {
                        System.out.println("Ingrese id del libro");
                        idL = sc.nextLong();
                        sc.nextLine();
                        libro = controlLog.traerLibro(idL);
                        if (libro == null) {
                            System.out.println("El id ingresado no se encuentra en la lista");
                        } else if (libro.getEjemplaresRestantes() == 0) {
                            System.out.println("No quedan ejemplares de ese libro");
                        }
                    } catch (InputMismatchException ime) {
                        System.out.println("caracter invalido, intente nuevamente");
                    }
                    break;
                    case 2:
                        try {
                        service.recorrerArray(controlLog.findLibroByName(libroS.pedirNombreLibro()));
                        System.out.println("Ingrese id del libro");
                        idL = sc.nextLong();
                        libro = controlLog.traerLibro(idL);
                        sc.nextLine();
                    } catch (InputMismatchException ime) {
                        System.out.println("Caracter invalido, intente nuevamente");
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                    break;
                    case 3:
                        try {
                        service.recorrerArray(controlLog.findLibroByAutorName(autorS.pedirNombreAutor()));
                        System.out.println("Ingrese id del libro");
                        idL = sc.nextLong();
                        sc.nextLine();
                        libro = controlLog.traerLibro(idL);
                    } catch (InputMismatchException ime) {
                        System.out.println("Caracter invalido");
                    }
                    break;
                    case 4:
                        try {
                        service.recorrerArray(controlLog.findLibroByEditorial(editorialS.pedirNombreEditorial()));
                        System.out.println("Ingrese id del libro");
                        idL = sc.nextLong();
                        sc.nextLine();
                        libro = controlLog.traerLibro(idL);
                    } catch (Exception e) {
                    }
                    break;
                    case 5: 
                        try {
                        menu(controlLog);
                    } catch (Exception ex) {
                        Logger.getLogger(PrestamoService.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            } catch (InputMismatchException ime) {
                System.out.println("Caracter erroneo, intente nuevamente");
                sc.nextLine();
            }
        }

        if (libro.getEjemplaresRestantes() == 0 || libro.getEjemplares() == null || !libro.getAlta()) {
            System.out.println("El libro seleccionado no se encuantra disponible en este momento");
            try {
                menu(controlLog);
            } catch (Exception ex) {
                Logger.getLogger(PrestamoService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //CLIENTE
        Cliente cliente = null;
        Long dni = null;
        while (cliente == null) {
            System.out.println("Ingresar cliente");
            System.out.println("1. Por dni cliente");
            System.out.println("2. Por id cliente");
            //TRY E001, E002
            try {
                int rtaC = sc.nextInt();

                if (rtaC == 1) {
                    try {
                        System.out.println("Ingrese dni del cliente");
                        dni = sc.nextLong();
                        cliente = controlLog.findClienteByDni(dni);
                    } catch (InputMismatchException ime) {
                        System.out.println("Dato invalido, intente nuevamente");
                        sc.nextLine();
                    } catch (NoResultException nre) {
                        System.out.println("No se encontro cliente con el dni: " + dni);
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                }
                if (rtaC == 2) {
                    System.out.println("Ingrese id del cliente");
                    Integer clienteId = sc.nextInt();
                    cliente = controlLog.traerCliente(rtaC);
                }
            } catch (InputMismatchException ime) {
                System.out.println("Dato invalido, intente nuevamente E001");
            } catch (Exception e) {
                System.out.println("Error E002");
            }
        }

        return new Prestamo(fechaPrestamo, libro, cliente);
    }

    public void devolucionLibro() {
        Prestamo prestamo = null;
        Integer idP = null;
        while (prestamo == null) {
            System.out.println("Id del prestamo");
            System.out.println("1. Ingresar id del prestamo");
            System.out.println("2. Buscar prestamo por libro");
            System.out.println("3. Buscar prestamo por cliente");
            System.out.println("4. Salir al menu principal");
            try {
                int rtaD = sc.nextInt();
                sc.nextLine();
                switch (rtaD) {
                    case 1:
                        System.out.println("Ingrese id del prestamo");
                        try {
                            idP = sc.nextInt();
                            prestamo = controlLog.traerPrestamo(idP);
                        } catch (InputMismatchException ime) {
                            System.out.println("Dato invalido, intente nuevamente");
                        } catch (NoResultException nre) {
                            System.out.println("No se encontro prestamo con ese id");
                        }
                        break;

                    case 2:

                        System.out.println("Ingrese id del libro");
                        try {
                            Long idL = sc.nextLong();
                            sc.nextLine();
                            service.recorrerArray(controlLog.findPrestamoByIsbn(idL));
                            System.out.println("Ingrese id del prestamo");
                            idP = sc.nextInt();
                            prestamo = controlLog.traerPrestamo(idP);
                        } catch (InputMismatchException ime) {
                            System.out.println("Dato invalido");
                            sc.nextLine();
                        }
                        break;
                    case 3:

                        break;
                    case 4:
                        try {
                        menu(controlLog);
                    } catch (Exception ex) {
                        Logger.getLogger(PrestamoService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                    default:
                        System.out.println("Ingrese una opcion valida");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Dato invalido, intente nuevamente");
            }
        }
        Libro libro = prestamo.getLibro();
        LocalDate fechaHoy = LocalDate.now();
        prestamo.setFechaDevolucion(fechaHoy);
        controlLog.editarPrestamo(prestamo);
        libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() -1);
        libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() + 1);
        controlLog.editarLibro(libro);
        
    }
}
