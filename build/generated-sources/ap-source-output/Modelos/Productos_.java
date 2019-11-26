package Modelos;

import Modelos.Categorias;
import Modelos.DetallesPagos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-11-24T16:24:41")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, Double> precio;
    public static volatile CollectionAttribute<Productos, DetallesPagos> detallesPagosCollection;
    public static volatile SingularAttribute<Productos, String> name;
    public static volatile SingularAttribute<Productos, Long> idProducto;
    public static volatile SingularAttribute<Productos, Integer> stock;
    public static volatile SingularAttribute<Productos, Categorias> idCategoria;

}