package com.mycompany.jpax.Logica;

import com.mycompany.jpax.Logica.Carrera;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-29T23:12:07", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Alumno.class)
public class Alumno_ { 

    public static volatile SingularAttribute<Alumno, Date> fechaNac;
    public static volatile SingularAttribute<Alumno, String> apellido;
    public static volatile SingularAttribute<Alumno, Integer> id;
    public static volatile SingularAttribute<Alumno, Carrera> carrera;
    public static volatile SingularAttribute<Alumno, String> nombre;

}