package ups.edu.ec.model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Alumno.class)
public abstract class Alumno_ {

	public static volatile SingularAttribute<Alumno, LocalDate> fecha_N;
	public static volatile SingularAttribute<Alumno, Representante> representante;
	public static volatile SingularAttribute<Alumno, String> cedula;
	public static volatile SingularAttribute<Alumno, String> apellido;
	public static volatile SingularAttribute<Alumno, String> direccion;
	public static volatile SingularAttribute<Alumno, Integer> id;
	public static volatile SingularAttribute<Alumno, String> telefono;
	public static volatile SingularAttribute<Alumno, String> sexo;
	public static volatile SingularAttribute<Alumno, String> nombre;
	public static volatile SingularAttribute<Alumno, String> email;

	public static final String FECHA__N = "fecha_N";
	public static final String REPRESENTANTE = "representante";
	public static final String CEDULA = "cedula";
	public static final String APELLIDO = "apellido";
	public static final String DIRECCION = "direccion";
	public static final String ID = "id";
	public static final String TELEFONO = "telefono";
	public static final String SEXO = "sexo";
	public static final String NOMBRE = "nombre";
	public static final String EMAIL = "email";

}

