package ups.edu.ec.model;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Anio_Lectivo.class)
public abstract class Anio_Lectivo_ {

	public static volatile SingularAttribute<Anio_Lectivo, String> descripcion;
	public static volatile ListAttribute<Anio_Lectivo, Curso> cursos;
	public static volatile SingularAttribute<Anio_Lectivo, Integer> id;

	public static final String DESCRIPCION = "descripcion";
	public static final String CURSOS = "cursos";
	public static final String ID = "id";

}

