package ups.edu.ec.daoDatos;

import ups.edu.ec.model.Cabecera_Factura;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class Cabecera_FacturaDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;

    public void create(Cabecera_Factura cabecera_factura) {
        em.persist(cabecera_factura);
    }

    public void update(Cabecera_Factura cabecera_factura) {
        em.merge(cabecera_factura);
    }

    public Cabecera_Factura getById(int id) {
        return em.find(Cabecera_Factura.class, id);
    }

    public void delete(int id) {
        Cabecera_Factura cabecera_factura = em.find(Cabecera_Factura.class, id);
        if (cabecera_factura != null) {
            em.remove(cabecera_factura);
        }
    }

    public List<Cabecera_Factura> getAll() {
        String jpql = "SELECT c FROM Cabecera_Factura c";
        Query q = em.createQuery(jpql);
        return q.getResultList();
    }
}
