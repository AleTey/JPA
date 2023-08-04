
package jpa.libreria.Logica.Services;

import java.util.Scanner;
import jpa.libreria.Logica.Editorial;


public class EditorialService {
    
    Scanner sc = new Scanner(System.in);
    
    public Editorial crearEditorial() {
        
        //NOMBRE
        String nombre;
        do{
        System.out.println("Ingrese nombre de la editorial");
        nombre = sc.nextLine();
        }while(nombre.equalsIgnoreCase("") || nombre.equalsIgnoreCase(" "));
        
        //ALTA
        System.out.println("Desea dar de alta la editorial? S/N");
        String rta = sc.nextLine();
        Boolean alta = false;
        if (rta.equalsIgnoreCase("s")) {
            alta = true;
        }
        
        return new Editorial(nombre, alta);
    }
    
    public String pedirNombreEditorial() {
        System.out.println("Ingrese nombre de la editorial");
        String nombre = sc.nextLine();
        return nombre;
    }
    
}
