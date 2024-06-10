package ups.edu.ec.negocio;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.daoDatos.RolDAO;
import ups.edu.ec.model.Anio_Lectivo;
import ups.edu.ec.model.Rol;

import java.util.List;

@Stateless
public class GestionRol {
    @Inject
    private RolDAO rolDAO;

    public void save(Rol rol) throws Exception{
        if (rol == null) {
            throw new Exception("Rol vacio !");
        } else {
            System.out.println("Se crea un nuevo Rol.");
            try {
                this.rolDAO.create(rol);
            } catch (Exception e) {
                throw new Exception("Error al crear nuevo Rol: "+e.getMessage());
            }
        }
    }
    public List<Rol> getAll()  throws Exception{
        try {
            return rolDAO.findAll();
        } catch (Exception e) {
            throw new Exception("Error al recuperar Rol de la base de datos: "+e.getMessage());
        }
    }
    public void update(Rol rol) throws Exception{
        System.out.println("Se actualiza Rol.");
        try {
            this.rolDAO.update(rol);
        } catch (Exception e) {
            throw new Exception("Error al actualizar Rol: "+e.getMessage());
        }
    }
    public Rol findById(int id) throws Exception{
        System.out.println("Se busca Año Lectivo: "+id);
        try {
            return this.rolDAO.read(id);
        } catch (Exception e) {
            throw new Exception("Error al encontrar Rol: "+id+", "+e.getMessage());
        }
    }
    public void delete(int id) throws Exception{
        System.out.println("Se elimina Rol: "+id);
        try {
            this.rolDAO.delete(id);
        } catch (Exception e) {
            throw new Exception("Error al eliminar Rol: "+id+", "+e.getMessage());
        }
    }
}
