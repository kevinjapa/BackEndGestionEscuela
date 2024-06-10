package ups.edu.ec.model;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> password;
	public static volatile SingularAttribute<Usuario, String> estado;
	public static volatile ListAttribute<Usuario, Cabecera_Factura> facturas;
	public static volatile SingularAttribute<Usuario, String> usuario;
	public static volatile SingularAttribute<Usuario, Integer> id;
	public static volatile SingularAttribute<Usuario, Rol> rol;

	public static final String PASSWORD = "password";
	public static final String ESTADO = "estado";
	public static final String FACTURAS = "facturas";
	public static final String USUARIO = "usuario";
	public static final String ID = "id";
	public static final String ROL = "rol";

}

