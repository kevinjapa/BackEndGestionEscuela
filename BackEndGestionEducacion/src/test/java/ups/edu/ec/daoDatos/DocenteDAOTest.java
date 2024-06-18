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
import ups.edu.ec.model.Docente;

public class DocenteDAOTest {
    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<Docente> typedQuery;

    @InjectMocks
    private DocenteDAO docenteDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        Docente docente = new Docente();
        docenteDao.create(docente);
        verify(entityManager).persist(docente);
    }

    @Test
    public void testRead() {
        Docente docente = new Docente();
        docente.setId(1);
        when(entityManager.find(Docente.class, 1)).thenReturn(docente);

        Docente result = docenteDao.read(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testUpdate() {
        Docente docente = new Docente();
        docenteDao.update(docente);
        verify(entityManager).merge(docente);
    }

    @Test
    public void testDelete() {
        Docente docente = new Docente();
        docente.setId(1);
        when(entityManager.find(Docente.class, 1)).thenReturn(docente);

        docenteDao.delete(1);
        verify(entityManager).remove(docente);
    }

    @Test
    public void testFindAll() {
        when(entityManager.createQuery("SELECT d FROM Docente d", Docente.class)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(Collections.singletonList(new Docente()));

        List<Docente> docentes = docenteDao.findAll();
        assertEquals(1, docentes.size());
    }
}
