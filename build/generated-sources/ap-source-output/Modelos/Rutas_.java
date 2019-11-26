package Modelos;

import Modelos.DetallesRutas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-11-24T16:24:41")
@StaticMetamodel(Rutas.class)
public class Rutas_ { 

    public static volatile SingularAttribute<Rutas, Date> createdAt;
    public static volatile CollectionAttribute<Rutas, DetallesRutas> detallesRutasCollection;
    public static volatile SingularAttribute<Rutas, String> name;
    public static volatile SingularAttribute<Rutas, Long> idRuta;
    public static volatile SingularAttribute<Rutas, String> detalle;
    public static volatile SingularAttribute<Rutas, Date> updatedAt;

}