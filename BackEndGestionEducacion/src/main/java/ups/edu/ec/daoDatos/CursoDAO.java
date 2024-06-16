package ups.edu.ec.daoDatos;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import ups.edu.ec.model.Cabecera_Factura;
import ups.edu.ec.model.Curso;

import java.io.Serializable;
import java.util.List;

@Stateless
public class CursoDAO implements Serializable {

    @PersistenceContext
    private EntityManager em;

    public void create(Curso curso) {
        em.persist(curso);
    }

    public Curso read(int id) {
        return em.find(Curso.class, id);
    }

    public void update(Curso curso) {
        em.merge(curso);
    }

    public void delete(int id) {
            Curso curso = em.find(Curso.class, id);
        if (curso != null) {
            em.remove(curso);
        }
    }
    public List<Curso> findAll() {
        return em.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();
    }

}