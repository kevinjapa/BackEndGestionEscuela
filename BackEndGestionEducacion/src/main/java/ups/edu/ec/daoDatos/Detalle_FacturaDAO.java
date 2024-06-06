package ups.edu.ec.daoDatos;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ups.edu.ec.model.Cabecera_Factura;
import ups.edu.ec.model.Detalle_Factura;

import java.io.Serializable;
import java.util.List;

@Stateless
public class Detalle_FacturaDAO implements Serializable {

    @PersistenceContext
    private EntityManager em;

    public void create(Detalle_Factura detalleFactura) {
        em.persist(detalleFactura);
    }

    public Detalle_Factura read(int id) {
        return em.find(Detalle_Factura.class, id);
    }

    public void update(Detalle_Factura detalleFactura) {
        em.merge(detalleFactura);
    }

//    public void delete(Detalle_Factura detalleFactura) {
//        em.remove(em.merge(detalleFactura));
//    }
    public void delete(int id) {
        Detalle_Factura detalle_factura = em.find(Detalle_Factura.class, id);
        if (detalle_factura != null) {
            em.remove(detalle_factura);
        }
    }
    public List<Detalle_Factura> findAll() {
        return em.createQuery("SELECT d FROM Detalle_Factura d", Detalle_Factura.class).getResultList();
    }
}
