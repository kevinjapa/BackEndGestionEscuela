package ups.edu.ec.model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Representante.class)
public abstract class Representante_ {

	public static volatile SingularAttribute<Representante, String> cedula;
	public static volatile SingularAttribute<Representante, String> apellido;
	public static volatile SingularAttribute<Representante, String> direccion;
	public static volatile SingularAttribute<Representante, Integer> id;
	public static volatile SingularAttribute<Representante, String> profesion;
	public static volatile SingularAttribute<Representante, String> telefono;
	public static volatile SingularAttribute<Representante, String> nombre;

	public static final String CEDULA = "cedula";
	public static final String APELLIDO = "apellido";
	public static final String DIRECCION = "direccion";
	public static final String ID = "id";
	public static final String PROFESION = "profesion";
	public static final String TELEFONO = "telefono";
	public static final String NOMBRE = "nombre";

}

