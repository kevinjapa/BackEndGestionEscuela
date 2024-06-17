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
import ups.edu.ec.model.Representante;

public class RepresentanteDAOTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<Representante> typedQuery;

    @InjectMocks
    private RepresentanteDAO representanteDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        Representante representante = new Representante();
        representanteDAO.create(representante);
        verify(entityManager).persist(representante);
    }

    @Test
    public void testRead() {
        Representante representante = new Representante();
        representante.setId(1);
        when(entityManager.find(Representante.class, 1)).thenReturn(representante);

        Representante result = representanteDAO.read(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testUpdate() {
        Representante representante = new Representante();
        representanteDAO.update(representante);
        verify(entityManager).merge(representante);
    }

    @Test
    public void testDelete() {
        Representante representante = new Representante();
        representante.setId(1);
        when(entityManager.find(Representante.class, 1)).thenReturn(representante);

        representanteDAO.delete(1);
        verify(entityManager).remove(representante);
    }

    @Test
    public void testFindAll() {
        when(entityManager.createQuery("SELECT r FROM Representante r", Representante.class)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(Collections.singletonList(new Representante()));

        List<Representante> representantes = representanteDAO.findAll();
        assertEquals(1, representantes.size());
    }
}