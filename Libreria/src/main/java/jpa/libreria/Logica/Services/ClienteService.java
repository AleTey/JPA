
package jpa.libreria.Logica.Services;

import java.util.Scanner;
import javax.persistence.NoResultException;
import jpa.libreria.Logica.Cliente;
import jpa.libreria.Logica.ControladoraLogica;


public class ClienteService {
    
    Scanner sc = new Scanner(System.in);
    ControladoraLogica controlLog = new ControladoraLogica();
    
    public Cliente crearCliente() throws Exception{
        
        System.out.println("Ingrese nombre del cliente");
        String nombre = sc.nextLine();
        System.out.println("Ingrese apellidos");
        String apellido = sc.nextLine();
        
        boolean dniExistente = true;
        Long dni;
        do{
        System.out.println("Ingrese dni");
        dni = sc.nextLong();
        sc.nextLine();
        Cliente cliente = null;
        try{
        cliente = controlLog.findClienteByDni(dni);
        }catch(NoResultException e) {
            
        }
        
        if(cliente != null) {
            System.out.println("El cliente ya se encuentra registrado");
            System.out.println("1. Intentar con otro numero");
            System.out.println("2. Salir");
            int rta = sc.nextInt();
            sc.nextLine();
            switch (rta) {
                case 2:
                    return null;              
            }            
        }else {
            dniExistente = false;
        }
        
        }while(dniExistente);
        
        System.out.println("Ingrese telefono");
        String telefono = sc.nextLine();
        
        return new Cliente(dni, nombre, apellido, telefono);
    }
}
