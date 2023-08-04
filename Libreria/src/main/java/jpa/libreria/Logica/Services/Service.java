
package jpa.libreria.Logica.Services;

import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    
    Scanner sc = new Scanner(System.in);
    
    public  <T> void recorrerArray(ArrayList<T> array) {
        for (T t : array) {
            System.out.println(t.toString());
        }
    }
    
    public String pedirString() {
        System.out.println("Ingrese nombre");
        String nombre = sc.nextLine();
        return nombre;
    }
    
    
}
