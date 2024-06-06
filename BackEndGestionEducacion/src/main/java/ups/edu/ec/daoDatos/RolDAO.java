package ups.edu.ec.daoDatos;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ups.edu.ec.model.Cabecera_Factura;
import ups.edu.ec.model.Rol;

import java.io.Serializable;
import java.util.List;

@Stateless
public class RolDAO implements Serializable {

    @PersistenceContext
    private EntityManager em;

    public void create(Rol rol) {
        em.persist(rol);
    }

    public Rol read(int id) {
        return em.find(Rol.class, id);
    }

    public void update(Rol rol) {
        em.merge(rol);
    }

//    public void delete(Rol rol) {
//        em.remove(em.merge(rol));
//    }

    public void delete(int id) {
       Rol rol = em.find(Rol.class, id);
        if (rol != null) {
            em.remove(rol);
        }
    }
    public List<Rol> findAll() {
        return em.createQuery("SELECT r FROM Rol r", Rol.class).getResultList();
    }
}