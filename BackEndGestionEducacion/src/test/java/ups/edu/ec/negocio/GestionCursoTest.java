package ups.edu.ec.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ups.edu.ec.daoDatos.CursoDAO;
import ups.edu.ec.model.Curso;

public class GestionCursoTest {

    @Mock
    private CursoDAO cursoDao;

    @InjectMocks
    private GestionCurso gestionCurso;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        Curso curso = new Curso();
        gestionCurso.save(curso);
        verify(cursoDao).create(curso);
    }

    @Test
    public void testGetAll() throws Exception {
        when(cursoDao.findAll()).thenReturn(Collections.singletonList(new Curso()));

        List<Curso> cursos = gestionCurso.getAll();
        assertEquals(1, cursos.size());
    }

    @Test
    public void testUpdate() throws Exception {
        Curso curso = new Curso();
        gestionCurso.update(curso);
        verify(cursoDao).update(curso);
    }

    @Test
    public void testFindById() throws Exception {
        Curso curso = new Curso();
        curso.setId(1);
        when(cursoDao.read(1)).thenReturn(curso);

        Curso result = gestionCurso.findById(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testDelete() throws Exception {
        gestionCurso.delete(1);
        verify(cursoDao).delete(1);
    }

    @Test
    public void testSaveThrowsExceptionOnNull() {
        Exception exception = assertThrows(Exception.class, () -> {
            gestionCurso.save(null);
        });

        assertEquals("Curso vacio !", exception.getMessage());
    }
}
