package ups.edu.ec.negocio;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.daoDatos.AlumnoDao;
import ups.edu.ec.daoDatos.RepresentanteDAO;
import ups.edu.ec.model.Alumno;
import ups.edu.ec.model.Matricula;
import ups.edu.ec.model.Representante;


@Stateless
public class GestionAlumno {

@Inject
private AlumnoDao alumnoDAO;
    @Inject
    private RepresentanteDAO representanteDAO;

    public void save(Alumno alumno) throws Exception {
        if (alumno == null) {
            throw new Exception("Alumno vacío!");
        } else {
            System.out.println("Se crea un nuevo Alumno.");
            if (alumno.getRepresentanteId() != null) {
                System.out.println("Buscando representante con ID: " + alumno.getRepresentanteId());
                Representante representante = representanteDAO.read(alumno.getRepresentanteId());
                if (representante == null) {
                    throw new Exception("Representante no encontrado!");
                }
                System.out.println("Representante encontrado: " + representante.toString());
                alumno.setRepresentante(representante);
            } else {
                System.out.println("No se proporcionó representante ID.");
            }
            try {
                this.alumnoDAO.create(alumno);
            } catch (Exception e) {
                throw new Exception("Error al crear nuevo Alumno: " + e.getMessage());
            }
        }
    }


    public List<Alumno> getAll()  throws Exception{

        try {
            return alumnoDAO.getAll();
        } catch (Exception e) {
            throw new Exception("Error al recuperar Alumnos de la base de datos: "+e.getMessage());

        }

    }
    public void update(Alumno alumno) throws Exception{

        System.out.println("Se actualiza Alumno.");
        try {
            this.alumnoDAO.update(alumno);
        } catch (Exception e) {
            throw new Exception("Error al actualizar Alumno: "+e.getMessage());
        }
    }
    public Alumno findById(int id) throws Exception{
        System.out.println("Se busca Alumno: "+id);
        try {
            return this.alumnoDAO.getById(id);
        } catch (Exception e) {
            throw new Exception("Error al encontrar Alumno: "+id+", "+e.getMessage());
        }
    }
    public void delete(int id) throws Exception{
        System.out.println("Se elimina Alumno: "+id);
        try {
            this.alumnoDAO.delete(id);
        } catch (Exception e) {
            throw new Exception("Error al eliminar Alumno: "+id+", "+e.getMessage());

        }
    }

    public Alumno findByCedula(String cedula) throws Exception {
        System.out.println("Se busca Alumno por cédula: " + cedula);
        try {
            return this.alumnoDAO.findByCedula(cedula);
        } catch (Exception e) {
            throw new Exception("Error al encontrar Alumno por cédula: " + cedula + ", " + e.getMessage());
        }
    }

    public Matricula getMatriculaByAlumnoId(int alumnoId) throws Exception {
        try {
            return alumnoDAO.findMatriculaByAlumnoId(alumnoId);
        } catch (Exception e) {
            throw new Exception("Error al obtener matrículas por alumno: " + alumnoId + ", " + e.getMessage());
        }
    }
}