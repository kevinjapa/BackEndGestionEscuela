package ups.edu.ec.daoDatos;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ups.edu.ec.model.Cabecera_Factura;
import ups.edu.ec.model.Matricula;

import java.io.Serializable;
import java.util.List;


@Stateless
public class MatriculaDAO implements Serializable {

    @PersistenceContext
    private EntityManager em;

    public void create(Matricula matricula) {
        em.persist(matricula);
    }

    public Matricula read(int id) {
        return em.find(Matricula.class, id);
    }

    public void update(Matricula matricula) {
        em.merge(matricula);
    }

//    public void delete(Matricula matricula) {
//        em.remove(em.merge(matricula));
//    }

    public void delete(int id) {
        Matricula matricula = em.find(Matricula.class, id);
        if (matricula != null) {
            em.remove(matricula);
        }
    }
    public List<Matricula> findAll() {
        return em.createQuery("SELECT m FROM Matricula m", Matricula.class).getResultList();
    }
}