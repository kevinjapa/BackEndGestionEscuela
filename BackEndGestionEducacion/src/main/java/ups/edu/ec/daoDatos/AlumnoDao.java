package ups.edu.ec.daoDatos;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import ups.edu.ec.model.*;


import java.io.Serializable;
import java.util.List;

@Stateless
public class AlumnoDao implements Serializable{


    @PersistenceContext
    private EntityManager em;

    public void create(Alumno alumno) {
        em.persist(alumno);
    }

    public void update(Alumno alumno) {
        em.merge(alumno);
    }

    public Alumno getById(int id) {
        return em.find(Alumno.class, id);
    }

    public void delete(int id) {
        Alumno alumno = em.find(Alumno.class, id);
        if (alumno != null) {
            em.remove(alumno);
        }
    }

    public List<Alumno> getAll() {
        return em.createQuery("SELECT a FROM Alumno a", Alumno.class).getResultList();
    }

    public Alumno findByCedula(String cedula) {
        TypedQuery<Alumno> query = em.createQuery("SELECT a FROM Alumno a WHERE a.cedula = :cedula", Alumno.class);
        query.setParameter("cedula", cedula);
        List<Alumno> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    public Matricula findMatriculaByAlumnoId(int alumnoId) {
        TypedQuery<Matricula> query = em.createQuery("SELECT m FROM Matricula m WHERE m.alumno.id = :alumnoId", Matricula.class);
        query.setParameter("alumnoId", alumnoId);
        List<Matricula> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

}
