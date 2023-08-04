
package jpa.libreria.Logica;

import java.util.ArrayList;
import java.util.List;
import jpa.libreria.Persistencia.ControladoraPersistencia;

public class ControladoraLogica {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    //LIBRO
    
    public void crearLibro(Libro libro) {
        controlPersis.crearLibro(libro);
    }
    
    public void editarLibro(Libro libro) {
        controlPersis.editarLibro(libro);
    } 
    
    public void eliminarLibr(Long id) {
        controlPersis.eliminarLibro(id);
    }
    
    public Libro traerLibro(Long id) {
        return controlPersis.traerLibro(id);
    }
    
    public ArrayList<Libro> traerListaLibros() {
        return controlPersis.traerListaLibros();
    }
    
    public ArrayList<Libro> findLibroByName(String nombre) {
        return controlPersis.findLibroByName(nombre);
    }
    
    public ArrayList<Libro> findLibroByAutorName(String name) {
        return controlPersis.findLibroByAutorName(name);
    }
    
    public ArrayList<Libro> findLibroByEditorial(String nombre) {
        return controlPersis.findLibroByEditorial(nombre);
    }
    
    // AUTOR
    
    public void crearAutor(Autor autor) {
        controlPersis.crearAutor(autor);
    }
    
    public void editarAutor(Autor autor) {
        controlPersis.editarAutor(autor);
    }
    
    public void eliminarAutor(Integer id) {
        controlPersis.eliminarAutor(id);
    }
    
    public Autor traerAutor(Integer id) {
        return controlPersis.traerAutor(id);
    }
    
    public ArrayList<Autor> traerListaAutores() {
        return controlPersis.traerListaAutores();
    }
    
    public ArrayList<Autor> findAutorByName(String name) {
        return controlPersis.findAutorByName(name);
    }
    
    // EDITORIAL
     
    public void crearEditorial(Editorial editorial) {
        controlPersis.crearEditorial(editorial);
    }
    
    public void editarEditorial(Editorial editorial) {
        controlPersis.editarEditorial(editorial);
    }
    
    public void eliminarEditorial(Integer id) {
        controlPersis.eliminarEditorial(id);
    }
    
    public Editorial traerEditorial(Integer id) {
        return controlPersis.traerEditorial(id);
    }
    
    public ArrayList<Editorial> traerListaEditoriales() {
        return controlPersis.traerListaEditoriales();
    }
    
    // PRESTAMO
    
    public void crearPrestamo(Prestamo prestamo) {
        controlPersis.crearPrestamo(prestamo);
    }
    
    public void editarPrestamo(Prestamo prestamo) {
        controlPersis.editarPrestamo(prestamo);
    }
    
    public void eliminarPrestamo(Integer id) {
        controlPersis.eliminarPrestamo(id);
    }
    
    public Prestamo traerPrestamo(Integer id) {
        return controlPersis.traerPrestamo(id);
    }
    
    public ArrayList<Prestamo> traerListaPrestamos() {
        return controlPersis.traerListaPrestamos();
    }
    
    public ArrayList<Prestamo> findPrestamoByIsbn(Long isbn) {
        return controlPersis.findPrestamoByIsbn(isbn);
    }
    
    // CLIENTE
    
     public void crearCliente(Cliente cliente) {
        controlPersis.Cliente(cliente);
    }
    
    public void editarCliente(Cliente cliente) {
        controlPersis.editarCliente(cliente);
    }
    
    public void eliminarCliente(Integer id) {
        controlPersis.eliminarCliente(id);
    }
    
    public Cliente traerCliente(Integer id) {
        return controlPersis.traerCliente(id);
    }
    
    public ArrayList<Cliente> traerListaClientes() {                
        return controlPersis.traerListaClientes();
    }
    
    public Cliente findClienteByDni(Long dni) {
        return controlPersis.findClienteByDni(dni);
    }
}
