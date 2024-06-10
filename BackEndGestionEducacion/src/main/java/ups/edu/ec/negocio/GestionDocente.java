package ups.edu.ec.negocio;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import ups.edu.ec.daoDatos.DocenteDAO;
import ups.edu.ec.model.Anio_Lectivo;
import ups.edu.ec.model.Docente;

import java.util.List;

@Stateless
public class GestionDocente {

    @Inject
    private DocenteDAO docenteDAO;

    public void save(Docente docente) throws Exception{
        if (docente == null) {
            throw new Exception("Docente vacio !");
        } else {
            System.out.println("Se crea un nuevo Docente.");
            try {
                this.docenteDAO.create(docente);
            } catch (Exception e) {
                throw new Exception("Error al crear nuevo Docente: "+e.getMessage());
            }
        }
    }
    public List<Docente> getAll()  throws Exception{
        try {
            return docenteDAO.findAll();
        } catch (Exception e) {
            throw new Exception("Error al recuperar Docente de la base de datos: "+e.getMessage());
        }
    }
    public void update(Docente docente) throws Exception{
        System.out.println("Se actualiza Docente.");
        try {
            this.docenteDAO.update(docente);
        } catch (Exception e) {
            throw new Exception("Error al actualizar Docente: "+e.getMessage());
        }
    }
    public Docente findById(int id) throws Exception{
        System.out.println("Se busca Docente: "+id);
        try {
            return this.docenteDAO.read(id);
        } catch (Exception e) {
            throw new Exception("Error al encontrar Docente: "+id+", "+e.getMessage());
        }
    }
    public void delete(int id) throws Exception{
        System.out.println("Se elimina Docente: "+id);
        try {
            this.docenteDAO.delete(id);
        } catch (Exception e) {
            throw new Exception("Error al eliminar Docente: "+id+", "+e.getMessage());
        }
    }
}
