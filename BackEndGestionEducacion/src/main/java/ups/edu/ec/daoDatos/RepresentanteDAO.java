package ups.edu.ec.daoDatos;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import ups.edu.ec.model.Cabecera_Factura;
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

    public void delete(int id) {
        Representante representante = em.find(Representante.class, id);
        if (representante != null) {
            em.remove(representante);
        }
    }
    public List<Representante> findAll() {
        return em.createQuery("SELECT r FROM Representante r", Representante.class).getResultList();
    }

    public Representante findByCedula(String cedula) {
        TypedQuery<Representante> query = em.createQuery("SELECT r FROM Representante r WHERE r.cedula = :cedula", Representante.class);
        query.setParameter("cedula", cedula);
        List<Representante> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

}