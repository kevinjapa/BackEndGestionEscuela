package ups.edu.ec.daoDatos;

import ups.edu.ec.model.Alumno;
import ups.edu.ec.model.Anio_Lectivo;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class Anio_LectivoDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;

    public void create(Anio_Lectivo anio_lectivo) {
        em.persist(anio_lectivo);
    }

    public void update(Anio_Lectivo anio_lectivo) {
        em.merge(anio_lectivo);
    }

    public Anio_Lectivo getById(int id) {
        return em.find(Anio_Lectivo.class, id);
    }

    public void delete(int id) {
        Anio_Lectivo anio_lectivo = em.find(Anio_Lectivo.class, id);
        if (anio_lectivo != null) {
            em.remove(anio_lectivo);
        }
    }

    public List<Anio_Lectivo> getAll() {
        return em.createQuery("SELECT a FROM Anio_Lectivo a", Anio_Lectivo.class).getResultList();
    }
}
