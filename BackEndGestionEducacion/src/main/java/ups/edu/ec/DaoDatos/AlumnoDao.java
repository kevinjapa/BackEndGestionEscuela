package ups.edu.ec.DaoDatos;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.model.Alumno;


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
        String jpql = "SELECT a FROM Alumno a";
        Query q = em.createQuery(jpql);
        return q.getResultList();
    }


}
