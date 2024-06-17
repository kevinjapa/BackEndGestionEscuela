package ups.edu.ec.daoDatos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import ups.edu.ec.model.Rol;

public class RolDAOTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<Rol> typedQuery;

    @InjectMocks
    private RolDAO rolDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        Rol rol = new Rol();
        rolDAO.create(rol);
        verify(entityManager).persist(rol);
    }

    @Test
    public void testRead() {
        Rol rol = new Rol();
        rol.setId(1);
        when(entityManager.find(Rol.class, 1)).thenReturn(rol);

        Rol result = rolDAO.read(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testUpdate() {
        Rol rol = new Rol();
        rolDAO.update(rol);
        verify(entityManager).merge(rol);
    }

    @Test
    public void testDelete() {
        Rol rol = new Rol();
        rol.setId(1);
        when(entityManager.find(Rol.class, 1)).thenReturn(rol);

        rolDAO.delete(1);
        verify(entityManager).remove(rol);
    }

    @Test
    public void testFindAll() {
        when(entityManager.createQuery("SELECT r FROM Rol r", Rol.class)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(Collections.singletonList(new Rol()));

        List<Rol> roles = rolDAO.findAll();
        assertEquals(1, roles.size());
    }
}