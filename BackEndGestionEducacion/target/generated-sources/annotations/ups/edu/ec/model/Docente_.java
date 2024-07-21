package ups.edu.ec.model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Docente.class)
public abstract class Docente_ {

	public static volatile SingularAttribute<Docente, String> cedula;
	public static volatile SingularAttribute<Docente, String> apellido;
	public static volatile SingularAttribute<Docente, Integer> id;
	public static volatile SingularAttribute<Docente, String> telefono;
	public static volatile SingularAttribute<Docente, String> nombre;
	public static volatile SingularAttribute<Docente, String> especialidad;
	public static volatile SingularAttribute<Docente, String> email;

	public static final String CEDULA = "cedula";
	public static final String APELLIDO = "apellido";
	public static final String ID = "id";
	public static final String TELEFONO = "telefono";
	public static final String NOMBRE = "nombre";
	public static final String ESPECIALIDAD = "especialidad";
	public static final String EMAIL = "email";

}

