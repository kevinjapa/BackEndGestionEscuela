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
            throw new Exception("Año Lectivo vacio !");
        } else {
            System.out.println("Se crea un nuevo Año Lectivo.");
            try {
                this.usuarioDAO.create(usuario);
            } catch (Exception e) {
                throw new Exception("Error al crear nuevo Año Lectivo: "+e.getMessage());
            }
        }
    }
    public List<Usuario> getAll()  throws Exception{
        try {
            return usuarioDAO.findAll();
        } catch (Exception e) {
            throw new Exception("Error al recuperar Año Lectivo de la base de datos: "+e.getMessage());
        }
    }
    public void update(Usuario usuario) throws Exception{
        System.out.println("Se actualiza Año Lectivo.");
        try {
            this.usuarioDAO.update(usuario);
        } catch (Exception e) {
            throw new Exception("Error al actualizar Año Lectivo: "+e.getMessage());
        }
    }
    public Usuario findById(int id) throws Exception{
        System.out.println("Se busca Año Lectivo: "+id);
        try {
            return this.usuarioDAO.read(id);
        } catch (Exception e) {
            throw new Exception("Error al encontrar Año Lectivo: "+id+", "+e.getMessage());
        }
    }
    public void delete(int id) throws Exception{
        System.out.println("Se elimina Año Lectivo: "+id);
        try {
            this.usuarioDAO.delete(id);
        } catch (Exception e) {
            throw new Exception("Error al eliminar Año Lectivo: "+id+", "+e.getMessage());
        }
    }
}
