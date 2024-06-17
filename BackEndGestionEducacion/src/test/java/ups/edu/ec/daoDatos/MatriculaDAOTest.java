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
import ups.edu.ec.model.Matricula;

public class MatriculaDAOTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<Matricula> typedQuery;

    @InjectMocks
    private MatriculaDAO matriculaDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        Matricula matricula = new Matricula();
        matriculaDAO.create(matricula);
        verify(entityManager).persist(matricula);
    }

    @Test
    public void testRead() {
        Matricula matricula = new Matricula();
        matricula.setId(1);
        when(entityManager.find(Matricula.class, 1)).thenReturn(matricula);

        Matricula result = matriculaDAO.read(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testUpdate() {
        Matricula matricula = new Matricula();
        matriculaDAO.update(matricula);
        verify(entityManager).merge(matricula);
    }

    @Test
    public void testDelete() {
        Matricula matricula = new Matricula();
        matricula.setId(1);
        when(entityManager.find(Matricula.class, 1)).thenReturn(matricula);

        matriculaDAO.delete(1);
        verify(entityManager).remove(matricula);
    }

    @Test
    public void testFindAll() {
        when(entityManager.createQuery("SELECT m FROM Matricula m", Matricula.class)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(Collections.singletonList(new Matricula()));

        List<Matricula> matriculas = matriculaDAO.findAll();
        assertEquals(1, matriculas.size());
    }
}