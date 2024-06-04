package ups.edu.ec.daoDatos;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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

    public void delete(Curso curso) {
        em.remove(em.merge(curso));
    }

    public List<Curso> findAll() {
        return em.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();
    }
}