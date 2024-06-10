package ups.edu.ec.negocio;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.daoDatos.AlumnoDao;
import ups.edu.ec.daoDatos.Anio_LectivoDAO;
import ups.edu.ec.model.Alumno;
import ups.edu.ec.model.Anio_Lectivo;

import java.util.List;

@Stateless
public class GestionAnio_lectivo {
    @Inject
    private Anio_LectivoDAO anioLectivoDAO;

    public void save(Anio_Lectivo anio_lectivo) throws Exception{
        if (anio_lectivo == null) {
            throw new Exception("Año Lectivo vacio !");
        } else {
            System.out.println("Se crea un nuevo Año Lectivo.");
            try {
                this.anioLectivoDAO.create(anio_lectivo);
            } catch (Exception e) {
                throw new Exception("Error al crear nuevo Año Lectivo: "+e.getMessage());
            }
        }
    }
    public List<Anio_Lectivo> getAll()  throws Exception{
        try {
            return anioLectivoDAO.getAll();
        } catch (Exception e) {
            throw new Exception("Error al recuperar Año Lectivo de la base de datos: "+e.getMessage());
        }
    }
    public void update(Anio_Lectivo anio_lectivo) throws Exception{
        System.out.println("Se actualiza Año Lectivo.");
        try {
            this.anioLectivoDAO.update(anio_lectivo);
        } catch (Exception e) {
            throw new Exception("Error al actualizar Año Lectivo: "+e.getMessage());
        }
    }
    public Anio_Lectivo findById(int id) throws Exception{
        System.out.println("Se busca Año Lectivo: "+id);
        try {
            return this.anioLectivoDAO.getById(id);
        } catch (Exception e) {
            throw new Exception("Error al encontrar Año Lectivo: "+id+", "+e.getMessage());
        }
    }
    public void delete(int id) throws Exception{
        System.out.println("Se elimina Año Lectivo: "+id);
        try {
            this.anioLectivoDAO.delete(id);
        } catch (Exception e) {
            throw new Exception("Error al eliminar Año Lectivo: "+id+", "+e.getMessage());
        }
    }
}
