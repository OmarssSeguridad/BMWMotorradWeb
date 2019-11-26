package Modelos;

import Modelos.DetallesRutas;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-11-24T16:24:41")
@StaticMetamodel(Imagenes.class)
public class Imagenes_ { 

    public static volatile SingularAttribute<Imagenes, Integer> idImagenes;
    public static volatile SingularAttribute<Imagenes, String> ruta;
    public static volatile CollectionAttribute<Imagenes, DetallesRutas> detallesRutasCollection;
    public static volatile SingularAttribute<Imagenes, String> name;

}