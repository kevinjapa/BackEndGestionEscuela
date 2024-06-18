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

import ups.edu.ec.daoDatos.DocenteDAO;
import ups.edu.ec.model.Docente;

public class GestionDocenteTest {

    @Mock
    private DocenteDAO docenteDao;

    @InjectMocks
    private GestionDocente gestionDocente;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        Docente docente = new Docente();
        gestionDocente.save(docente);
        verify(docenteDao).create(docente);
    }

    @Test
    public void testGetAll() throws Exception {
        when(docenteDao.findAll()).thenReturn(Collections.singletonList(new Docente()));

        List<Docente> docentes = gestionDocente.getAll();
        assertEquals(1, docentes.size());
    }

    @Test
    public void testUpdate() throws Exception {
        Docente docente = new Docente();
        gestionDocente.update(docente);
        verify(docenteDao).update(docente);
    }

    @Test
    public void testFindById() throws Exception {
        Docente docente = new Docente();
        docente.setId(1);
        when(docenteDao.read(1)).thenReturn(docente);

        Docente result = gestionDocente.findById(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testDelete() throws Exception {
        gestionDocente.delete(1);
        verify(docenteDao).delete(1);
    }

    @Test
    public void testSaveThrowsExceptionOnNull() {
        Exception exception = assertThrows(Exception.class, () -> {
            gestionDocente.save(null);
        });

        assertEquals("Docente vacio !", exception.getMessage());
    }
}
