package com.mycompany.jpax.Logica;

import com.mycompany.jpax.Logica.Carrera;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-29T23:12:07", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Materia.class)
public class Materia_ { 

    public static volatile SingularAttribute<Materia, String> tipo;
    public static volatile SingularAttribute<Materia, Integer> id;
    public static volatile SingularAttribute<Materia, Carrera> carrera;
    public static volatile SingularAttribute<Materia, String> nombre;

}