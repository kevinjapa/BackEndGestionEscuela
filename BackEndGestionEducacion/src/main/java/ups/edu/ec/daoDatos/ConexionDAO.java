package ups.edu.ec.daoDatos;

import ups.edu.ec.model.Conexion;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ConexionDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;

    public void create(Conexion conexion) {
        em.persist(conexion);
    }

    public void update(Conexion conexion) {
        em.merge(conexion);
    }

    public Conexion getById(int id) {
        return em.find(Conexion.class, id);
    }

    public void delete(int id) {
        Conexion conexion = em.find(Conexion.class, id);
        if (conexion != null) {
            em.remove(conexion);
        }
    }

    public List<Conexion> getAll() {
        String jpql = "SELECT c FROM Conexion c";
        Query q = em.createQuery(jpql);
        return q.getResultList();
    }
}
