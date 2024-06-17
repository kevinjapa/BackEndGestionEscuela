package ups.edu.ec.model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Detalle_Factura.class)
public abstract class Detalle_Factura_ {

	public static volatile SingularAttribute<Detalle_Factura, Double> total;
	public static volatile SingularAttribute<Detalle_Factura, Double> iva;
	public static volatile SingularAttribute<Detalle_Factura, Double> subtotal;
	public static volatile SingularAttribute<Detalle_Factura, Matricula> matricula;
	public static volatile SingularAttribute<Detalle_Factura, Integer> id;
	public static volatile SingularAttribute<Detalle_Factura, Integer> cantidad;
	public static volatile SingularAttribute<Detalle_Factura, String> detalle;

	public static final String TOTAL = "total";
	public static final String IVA = "iva";
	public static final String SUBTOTAL = "subtotal";
	public static final String MATRICULA = "matricula";
	public static final String ID = "id";
	public static final String CANTIDAD = "cantidad";
	public static final String DETALLE = "detalle";

}

