package jpa.libreria.Logica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.libreria.Logica.Libro;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-08-03T21:15:14", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Autor.class)
public class Autor_ { 

    public static volatile SingularAttribute<Autor, Libro> libro;
    public static volatile SingularAttribute<Autor, Boolean> alta;
    public static volatile SingularAttribute<Autor, Integer> id;
    public static volatile SingularAttribute<Autor, String> nombre;

}