package ups.edu.ec.daoDatos;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ups.edu.ec.model.Cabecera_Factura;
import ups.edu.ec.model.Usuario;

import java.io.Serializable;
import java.util.List;

@Stateless
public class UsuarioDAO implements Serializable {

    @PersistenceContext
    private EntityManager em;

    public void create(Usuario usuario) {
        em.persist(usuario);
    }

    public Usuario read(int id) {
        return em.find(Usuario.class, id);
    }

    public void update(Usuario usuario) {
        em.merge(usuario);
    }

//    public void delete(Usuario usuario) {
//        em.remove(em.merge(usuario));
//    }

    public void delete(int id) {
       Usuario usuario = em.find(Usuario.class, id);
        if (usuario != null) {
            em.remove(usuario);
        }
    }
    public List<Usuario> findAll() {
        return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }
}