package ups.edu.ec.model;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Curso.class)
public abstract class Curso_ {

	public static volatile SingularAttribute<Curso, String> descripcion;
	public static volatile SingularAttribute<Curso, Anio_Lectivo> anioLectivo;
	public static volatile ListAttribute<Curso, Alumno> alumnos;
	public static volatile SingularAttribute<Curso, Docente> docente;
	public static volatile SingularAttribute<Curso, Integer> id;

	public static final String DESCRIPCION = "descripcion";
	public static final String ANIO_LECTIVO = "anioLectivo";
	public static final String ALUMNOS = "alumnos";
	public static final String DOCENTE = "docente";
	public static final String ID = "id";

}

