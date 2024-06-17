package ups.edu.ec.negocio;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.daoDatos.UsuarioDAO;
import ups.edu.ec.model.Anio_Lectivo;
import ups.edu.ec.model.Usuario;

import java.util.List;

@Stateless
public class GestioUsusario {
    @Inject
    private UsuarioDAO usuarioDAO;

    public void save(Usuario usuario) throws Exception{
        if (usuario == null) {
            throw new Exception("Usuario vacio !");
        } else {
            System.out.println("Se crea un Usuario.");
            try {
                this.usuarioDAO.create(usuario);
            } catch (Exception e) {
                throw new Exception("Error al crear Usuario: "+e.getMessage());
            }
        }
    }
    public List<Usuario> getAll()  throws Exception{
        try {
            return usuarioDAO.findAll();
        } catch (Exception e) {
            throw new Exception("Error al recuperar Uusuario de la base de datos: "+e.getMessage());
        }
    }
    public void update(Usuario usuario) throws Exception{
        System.out.println("Se actualiza Usuario.");
        try {
            this.usuarioDAO.update(usuario);
        } catch (Exception e) {
            throw new Exception("Error al actualizar Usuario: "+e.getMessage());
        }
    }
    public Usuario findById(int id) throws Exception{
        System.out.println("Se busca Uusuario: "+id);
        try {
            return this.usuarioDAO.read(id);
        } catch (Exception e) {
            throw new Exception("Error al encontrar Usuario: "+id+", "+e.getMessage());
        }
    }
    public void delete(int id) throws Exception{
        System.out.println("Se elimina Usuario: "+id);
        try {
            this.usuarioDAO.delete(id);
        } catch (Exception e) {
            throw new Exception("Error al eliminar Usuario: "+id+", "+e.getMessage());
        }
    }
}
