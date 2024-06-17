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

import ups.edu.ec.daoDatos.MatriculaDAO;
import ups.edu.ec.model.Matricula;

public class GestionMatriculaTest {

    @Mock
    private MatriculaDAO matriculaDAO;

    @InjectMocks
    private GestionMatricula gestionMatricula;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        Matricula matricula = new Matricula();
        gestionMatricula.save(matricula);
        verify(matriculaDAO).create(matricula);
    }

    @Test
    public void testGetAll() throws Exception {
        when(matriculaDAO.findAll()).thenReturn(Collections.singletonList(new Matricula()));

        List<Matricula> matriculas = gestionMatricula.getAll();
        assertEquals(1, matriculas.size());
    }

    @Test
    public void testUpdate() throws Exception {
        Matricula matricula = new Matricula();
        gestionMatricula.update(matricula);
        verify(matriculaDAO).update(matricula);
    }

    @Test
    public void testFindById() throws Exception {
        Matricula matricula = new Matricula();
        matricula.setId(1);
        when(matriculaDAO.read(1)).thenReturn(matricula);

        Matricula result = gestionMatricula.findById(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testDelete() throws Exception {
        gestionMatricula.delete(1);
        verify(matriculaDAO).delete(1);
    }

    @Test
    public void testSaveThrowsExceptionOnNull() {
        Exception exception = assertThrows(Exception.class, () -> {
            gestionMatricula.save(null);
        });

        assertEquals("Matricula vacio !", exception.getMessage());
    }
}