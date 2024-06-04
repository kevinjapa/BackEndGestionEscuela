package ups.edu.ec.daoDatos;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ups.edu.ec.model.Representante;

import java.io.Serializable;
import java.util.List;

@Stateless
public class RepresentanteDAO implements Serializable {

    @PersistenceContext
    private EntityManager em;

    public void create(Representante representante) {
        em.persist(representante);
    }

    public Representante read(int id) {
        return em.find(Representante.class, id);
    }

    public void update(Representante representante) {
        em.merge(representante);
    }

    public void delete(Representante representante) {
        em.remove(em.merge(representante));
    }

    public List<Representante> findAll() {
        return em.createQuery("SELECT r FROM Representante r", Representante.class).getResultList();
    }
}