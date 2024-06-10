package ups.edu.ec.model;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rol.class)
public abstract class Rol_ {

	public static volatile SingularAttribute<Rol, String> descripcion;
	public static volatile SingularAttribute<Rol, Integer> id;
	public static volatile ListAttribute<Rol, Usuario> usuarios;

	public static final String DESCRIPCION = "descripcion";
	public static final String ID = "id";
	public static final String USUARIOS = "usuarios";

}

