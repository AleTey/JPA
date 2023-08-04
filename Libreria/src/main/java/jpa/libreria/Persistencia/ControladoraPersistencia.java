
package jpa.libreria.Persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.libreria.Logica.Autor;
import jpa.libreria.Logica.Cliente;
import jpa.libreria.Logica.Editorial;
import jpa.libreria.Logica.Libro;
import jpa.libreria.Logica.Prestamo;
import jpa.libreria.Persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
  
    LibroJpaController libroJpa = new LibroJpaController();
    AutorJpaController autorJpa = new AutorJpaController();
    EditorialJpaController editorialJpa = new EditorialJpaController();
    PrestamoJpaController prestamoJpa = new PrestamoJpaController();
    ClienteJpaController clienteJpa = new ClienteJpaController();
    
    // LIBRO

    public void crearLibro(Libro libro) {
        libroJpa.create(libro);
    }

    public void editarLibro(Libro libro) {
        try {
            libroJpa.edit(libro);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarLibro(Long id) {
        try {
            libroJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Libro traerLibro(Long id) {
        return libroJpa.findLibro(id);
    }

    public ArrayList<Libro> traerListaLibros() {
        List list = libroJpa.findLibroEntities();
        ArrayList<Libro> listaLibros = new ArrayList(list);
        return listaLibros;
    }
    
    public ArrayList<Libro> findLibroByName(String nombre) {
        List list = libroJpa.findLibroByName(nombre);
        ArrayList<Libro> libros = new ArrayList(list);
        return libros;
    }
    
     public ArrayList<Libro> findLibroByAutorName(String name) {
         List list = libroJpa.findLibroByAutorName(name);
         ArrayList<Libro> libros = new ArrayList(list);
         return libros;
     }
     
      public ArrayList<Libro> findLibroByEditorial(String nombre) {
          List<Libro> list = libroJpa.findLibroByEditorial(nombre);
          ArrayList<Libro> libros = new ArrayList(list);
          return libros;
      }
    
    // AUTOR

    public void crearAutor(Autor autor) {
        autorJpa.create(autor);
    }

    public void editarAutor(Autor autor) {
        try {
            autorJpa.edit(autor);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarAutor(Integer id) {
        try {
            autorJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Autor traerAutor(Integer id) {
        return autorJpa.findAutor(id);
    }

    public ArrayList<Autor> traerListaAutores() {
        List<Autor> lista = autorJpa.findAutorEntities();
        ArrayList<Autor> listaAutores = new ArrayList(lista);
        return listaAutores;
    }
    
    public ArrayList<Autor> findAutorByName(String name) {
        List<Autor> list = autorJpa.findAutorByName(name);
        ArrayList<Autor> listaAutores = new ArrayList(list);
        return listaAutores;
    }
    
   // EDITORIAL

    public void crearEditorial(Editorial editorial) {
        editorialJpa.create(editorial);
    }

    public void editarEditorial(Editorial editorial) {
        try {
            editorialJpa.edit(editorial);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarEditorial(Integer id) {
        try {
            editorialJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Editorial traerEditorial(Integer id) {
        return editorialJpa.findEditorial(id);
    }

    public ArrayList<Editorial> traerListaEditoriales() {
        List<Editorial> lista = editorialJpa.findEditorialEntities();
        ArrayList<Editorial> listaEditoriales = new ArrayList(lista);
        return listaEditoriales;
    }

    // PRESTAMO
    
    public void crearPrestamo(Prestamo prestamo) {
        prestamoJpa.create(prestamo);
    }

    public void editarPrestamo(Prestamo prestamo) {
        try {
            prestamoJpa.edit(prestamo);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarPrestamo(Integer id) {
        try {
            prestamoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Prestamo traerPrestamo(Integer id) {
        return prestamoJpa.findPrestamo(id);
    }

    public ArrayList<Prestamo> traerListaPrestamos() {
        List<Prestamo> list = prestamoJpa.findPrestamoEntities();
        ArrayList<Prestamo> listaPrestamos = new ArrayList(list);
        return listaPrestamos;
    }
    
    public ArrayList<Prestamo> findPrestamoByIsbn(Long isbn) {
        List<Prestamo> list = prestamoJpa.findPrestamoByIsbn(isbn);
        ArrayList<Prestamo> listaPrestamos = new ArrayList(list);
        return listaPrestamos;
    }

    //CLIENTE
        
    public void Cliente(Cliente cliente) {
        clienteJpa.create(cliente);
    }

    public void editarCliente(Cliente cliente) {
        try {
            clienteJpa.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarCliente(Integer id) {
        try {
            clienteJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente traerCliente(Integer id) {
        return clienteJpa.findCliente(id);
    }

    public ArrayList<Cliente> traerListaClientes() {
        List<Cliente> list = clienteJpa.findClienteEntities();
        ArrayList<Cliente> listaClientes = new ArrayList(list);
        return listaClientes;
    }

    public Cliente findClienteByDni(Long dni) {
        return clienteJpa.findClienteByDni(dni);
    }

    

   

   

    
    
    
    
    
    
    
    
}
