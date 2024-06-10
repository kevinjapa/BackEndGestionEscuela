package ups.edu.ec.negocio;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.daoDatos.CursoDAO;
import ups.edu.ec.model.Anio_Lectivo;
import ups.edu.ec.model.Curso;

import java.util.List;

@Stateless
public class GestionCurso {
    @Inject
    private CursoDAO cursoDAO;

    public void save(Curso curso) throws Exception{
        if (curso == null) {
            throw new Exception("Curso vacio !");
        } else {
            System.out.println("Se crea un nuevo Curso.");
            try {
                this.cursoDAO.create(curso);
            } catch (Exception e) {
                throw new Exception("Error al crear nuevo Curso: "+e.getMessage());
            }
        }
    }
    public List<Curso> getAll()  throws Exception{
        try {
            return cursoDAO.findAll();
        } catch (Exception e) {
            throw new Exception("Error al recuperar Curso de la base de datos: "+e.getMessage());
        }
    }
    public void update(Curso curso) throws Exception{
        System.out.println("Se actualiza Curso.");
        try {
            this.cursoDAO.update(curso);
        } catch (Exception e) {
            throw new Exception("Error al actualizar Curso: "+e.getMessage());
        }
    }
    public Curso findById(int id) throws Exception{
        System.out.println("Se busca Curso: "+id);
        try {
            return this.cursoDAO.read(id);
        } catch (Exception e) {
            throw new Exception("Error al encontrar Curso: "+id+", "+e.getMessage());
        }
    }
    public void delete(int id) throws Exception{
        System.out.println("Se elimina Curso: "+id);
        try {
            this.cursoDAO.delete(id);
        } catch (Exception e) {
            throw new Exception("Error al eliminar Curso: "+id+", "+e.getMessage());
        }
    }
}
