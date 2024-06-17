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
import ups.edu.ec.model.Curso;

public class CursoDAOTest {
    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<Curso> typedQuery;

    @InjectMocks
    private CursoDAO cursoDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        Curso curso = new Curso();
        cursoDao.create(curso);
        verify(entityManager).persist(curso);
    }

    @Test
    public void testRead() {
        Curso curso = new Curso();
        curso.setId(1);
        when(entityManager.find(Curso.class, 1)).thenReturn(curso);

        Curso result = cursoDao.read(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testUpdate() {
        Curso curso = new Curso();
        cursoDao.update(curso);
        verify(entityManager).merge(curso);
    }

    @Test
    public void testDelete() {
        Curso curso = new Curso();
        curso.setId(1);
        when(entityManager.find(Curso.class, 1)).thenReturn(curso);

        cursoDao.delete(1);
        verify(entityManager).remove(curso);
    }

    @Test
    public void testFindAll() {
        when(entityManager.createQuery("SELECT c FROM Curso c", Curso.class)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(Collections.singletonList(new Curso()));

        List<Curso> cursos = cursoDao.findAll();
        assertEquals(1, cursos.size());
    }
}
