
package jpa.libreria.Logica.Services;

import java.util.Scanner;
import jpa.libreria.Logica.Autor;


public class AutorService {
    
    Scanner sc = new Scanner(System.in);
    
    public Autor crearAutor() {
        
        String nombre;
        do{
        System.out.println("Ingrese nombre del autor");
        nombre = sc.nextLine();
        }while(nombre.equalsIgnoreCase("") || nombre.equalsIgnoreCase(" "));
        
        
        System.out.println("Desea dar de alta el autor?");
        String rta = sc.nextLine();
        Boolean alta = false;
        if (rta.equalsIgnoreCase("s")) {
            alta = true;
        }
        
        return new Autor(nombre, alta);
    }
    
    public String pedirNombreAutor() {
        System.out.println("Ingrese nombre del autor");
        String nombre = sc.nextLine();
        return nombre;
    }
}
