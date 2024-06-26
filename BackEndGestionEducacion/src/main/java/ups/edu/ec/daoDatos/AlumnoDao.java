package ups.edu.ec.daoDatos;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.model.Alumno;
import ups.edu.ec.model.Anio_Lectivo;
import ups.edu.ec.model.Usuario;


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

}
