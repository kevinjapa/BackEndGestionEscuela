package ups.edu.ec.negocio;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.daoDatos.MatriculaDAO;
import ups.edu.ec.model.Anio_Lectivo;
import ups.edu.ec.model.Matricula;

import java.util.List;

@Stateless
public class GestionMatricula {
    @Inject
    private MatriculaDAO matriculaDAO;

    public void save(Matricula matricula) throws Exception{
        if (matricula == null) {
            throw new Exception("Matricula vacio !");
        } else {
            System.out.println("Se crea Matricula.");
            try {
                this.matriculaDAO.create(matricula);
            } catch (Exception e) {
                throw new Exception("Error al crear nuevo Matricula "+e.getMessage());
            }
        }
    }
    public List<Matricula> getAll()  throws Exception{
        try {
            return matriculaDAO.findAll();
        } catch (Exception e) {
            throw new Exception("Error al recuperar Matricula de la base de datos: "+e.getMessage());
        }
    }
    public void update(Matricula matricula) throws Exception{
        System.out.println("Se actualiza Matricula.");
        try {
            this.matriculaDAO.update(matricula);
        } catch (Exception e) {
            throw new Exception("Error al actualizar Matricula: "+e.getMessage());
        }
    }
    public Matricula findById(int id) throws Exception{
        System.out.println("Se busca Matricula: "+id);
        try {
            return this.matriculaDAO.read(id);
        } catch (Exception e) {
            throw new Exception("Error al encontrar Matricula: "+id+", "+e.getMessage());
        }
    }
    public void delete(int id) throws Exception{
        System.out.println("Se elimina Matricula: "+id);
        try {
            this.matriculaDAO.delete(id);
        } catch (Exception e) {
            throw new Exception("Error al eliminar Matricula: "+id+", "+e.getMessage());
        }
    }
}
