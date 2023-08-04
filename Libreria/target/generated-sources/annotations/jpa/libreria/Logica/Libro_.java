package jpa.libreria.Logica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.libreria.Logica.Autor;
import jpa.libreria.Logica.Editorial;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-08-03T21:15:14", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Libro.class)
public class Libro_ { 

    public static volatile SingularAttribute<Libro, Editorial> editorial;
    public static volatile SingularAttribute<Libro, Integer> ejemplares;
    public static volatile SingularAttribute<Libro, Boolean> alta;
    public static volatile SingularAttribute<Libro, Long> isbn;
    public static volatile SingularAttribute<Libro, Integer> ejemplaresPrestados;
    public static volatile SingularAttribute<Libro, String> titulo;
    public static volatile SingularAttribute<Libro, Integer> ejemplaresRestantes;
    public static volatile SingularAttribute<Libro, Integer> anio;
    public static volatile SingularAttribute<Libro, Autor> autor;

}