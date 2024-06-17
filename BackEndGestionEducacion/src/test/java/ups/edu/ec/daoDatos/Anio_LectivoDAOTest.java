package ups.edu.ec.daoDatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ups.edu.ec.model.Anio_Lectivo;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Anio_LectivoDAOTest {
    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<Anio_Lectivo> typedQuery;

    @InjectMocks
    private Anio_LectivoDAO anioLectivoDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        Anio_Lectivo anioLectivo = new Anio_Lectivo();
        anioLectivoDAO.create(anioLectivo);
        verify(entityManager).persist(anioLectivo);
    }

    @Test
    public void testRead() {
        Anio_Lectivo anioLectivo = new Anio_Lectivo();
        anioLectivo.setId(1);
        when(entityManager.find(Anio_Lectivo.class, 1)).thenReturn(anioLectivo);

        Anio_Lectivo result = anioLectivoDAO.getById(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testUpdate() {
        Anio_Lectivo anioLectivo = new Anio_Lectivo();
        anioLectivoDAO.update(anioLectivo);
        verify(entityManager).merge(anioLectivo);
    }

    @Test
    public void testDelete() {
        Anio_Lectivo anioLectivo = new Anio_Lectivo();
        anioLectivo.setId(1);
        when(entityManager.find(Anio_Lectivo.class, 1)).thenReturn(anioLectivo);

        anioLectivoDAO.delete(1);
        verify(entityManager).remove(anioLectivo);
    }

    @Test
    public void testFindAll() {
        when(entityManager.createQuery("SELECT a FROM Anio_Lectivo a", Anio_Lectivo.class)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(Collections.singletonList(new Anio_Lectivo()));

        List<Anio_Lectivo> anioLectivos = anioLectivoDAO.getAll();
        assertEquals(1, anioLectivos.size());
    }
}
