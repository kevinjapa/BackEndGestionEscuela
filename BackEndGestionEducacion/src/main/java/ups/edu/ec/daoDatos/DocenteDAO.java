package ups.edu.ec.daoDatos;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ups.edu.ec.model.Cabecera_Factura;
import ups.edu.ec.model.Docente;

import java.io.Serializable;
import java.util.List;

@Stateless
public class DocenteDAO implements Serializable {

    @PersistenceContext
    private EntityManager em;

    public void create(Docente docente) {
        em.persist(docente);
    }

    public Docente read(int id) {
        return em.find(Docente.class, id);
    }

    public void update(Docente docente) {
        em.merge(docente);
    }

//    public void delete(Docente docente) {
//        em.remove(em.merge(docente));
//    }
    public void delete(int id) {
        Docente docente = em.find(Docente.class, id);
        if (docente != null) {
            em.remove(docente);
        }
    }
    public List<Docente> findAll() {
        return em.createQuery("SELECT d FROM Docente d", Docente.class).getResultList();
    }
}