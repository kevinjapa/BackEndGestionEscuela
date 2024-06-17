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
import ups.edu.ec.daoDatos.Anio_LectivoDAO;
import ups.edu.ec.model.Anio_Lectivo;

public class GestionAnio_LectivoTest {
    @Mock
    private Anio_LectivoDAO anioLectivoDAO;

    @InjectMocks
    private GestionAnio_lectivo gestionAnioLectivo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        Anio_Lectivo anioLectivo = new Anio_Lectivo();
        gestionAnioLectivo.save(anioLectivo);
        verify(anioLectivoDAO).create(anioLectivo);
    }

    @Test
    public void testGetAll() throws Exception {
        when(anioLectivoDAO.getAll()).thenReturn(Collections.singletonList(new Anio_Lectivo()));

        List<Anio_Lectivo> anioLectivos = gestionAnioLectivo.getAll();
        assertEquals(1, anioLectivos.size());
    }

    @Test
    public void testUpdate() throws Exception {
        Anio_Lectivo anioLectivo = new Anio_Lectivo();
        gestionAnioLectivo.update(anioLectivo);
        verify(anioLectivoDAO).update(anioLectivo);
    }

    @Test
    public void testFindById() throws Exception {
        Anio_Lectivo anioLectivo = new Anio_Lectivo();
        anioLectivo.setId(1);
        when(anioLectivoDAO.getById(1)).thenReturn(anioLectivo);

        Anio_Lectivo result = gestionAnioLectivo.findById(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testDelete() throws Exception {
        gestionAnioLectivo.delete(1);
        verify(anioLectivoDAO).delete(1);
    }

    @Test
    public void testSaveThrowsExceptionOnNull() {
        Exception exception = assertThrows(Exception.class, () -> {
            gestionAnioLectivo.save(null);
        });

        assertEquals("Año Lectivo vacio !", exception.getMessage());
    }
}
