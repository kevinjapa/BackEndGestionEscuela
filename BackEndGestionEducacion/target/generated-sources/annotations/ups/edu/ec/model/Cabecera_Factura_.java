package ups.edu.ec.model;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cabecera_Factura.class)
public abstract class Cabecera_Factura_ {

	public static volatile SingularAttribute<Cabecera_Factura, Integer> codigo_Factura;
	public static volatile SingularAttribute<Cabecera_Factura, Double> totalMatricula;
	public static volatile SingularAttribute<Cabecera_Factura, String> cedula;
	public static volatile SingularAttribute<Cabecera_Factura, String> direccion;
	public static volatile SingularAttribute<Cabecera_Factura, Integer> id_anioLectivo;
	public static volatile SingularAttribute<Cabecera_Factura, Date> fechaEmision;
	public static volatile SingularAttribute<Cabecera_Factura, Alumno> alumno;
	public static volatile ListAttribute<Cabecera_Factura, Detalle_Factura> detalles;
	public static volatile SingularAttribute<Cabecera_Factura, Integer> id;
	public static volatile SingularAttribute<Cabecera_Factura, String> telefono;

	public static final String CODIGO__FACTURA = "codigo_Factura";
	public static final String TOTAL_MATRICULA = "totalMatricula";
	public static final String CEDULA = "cedula";
	public static final String DIRECCION = "direccion";
	public static final String ID_ANIO_LECTIVO = "id_anioLectivo";
	public static final String FECHA_EMISION = "fechaEmision";
	public static final String ALUMNO = "alumno";
	public static final String DETALLES = "detalles";
	public static final String ID = "id";
	public static final String TELEFONO = "telefono";

}

