package ups.edu.ec.model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Matricula.class)
public abstract class Matricula_ {

	public static volatile SingularAttribute<Matricula, Integer> id_anio_lectivo;
	public static volatile SingularAttribute<Matricula, Integer> id_curso;
	public static volatile SingularAttribute<Matricula, Double> matricula;
	public static volatile SingularAttribute<Matricula, Alumno> alumno;
	public static volatile SingularAttribute<Matricula, Integer> id;
	public static volatile SingularAttribute<Matricula, Integer> id_alumno;
	public static volatile SingularAttribute<Matricula, String> nombre;

	public static final String ID_ANIO_LECTIVO = "id_anio_lectivo";
	public static final String ID_CURSO = "id_curso";
	public static final String MATRICULA = "matricula";
	public static final String ALUMNO = "alumno";
	public static final String ID = "id";
	public static final String ID_ALUMNO = "id_alumno";
	public static final String NOMBRE = "nombre";

}

