package jpa.libreria.Logica;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.libreria.Logica.Cliente;
import jpa.libreria.Logica.Libro;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-08-03T21:15:14", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Prestamo.class)
public class Prestamo_ { 

    public static volatile SingularAttribute<Prestamo, Libro> libro;
    public static volatile SingularAttribute<Prestamo, Cliente> cliente;
    public static volatile SingularAttribute<Prestamo, LocalDate> fechaDevolucion;
    public static volatile SingularAttribute<Prestamo, LocalDate> fechaPrestamo;
    public static volatile SingularAttribute<Prestamo, Integer> id;

}