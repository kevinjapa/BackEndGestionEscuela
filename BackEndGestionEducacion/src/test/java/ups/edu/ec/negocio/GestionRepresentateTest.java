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

import ups.edu.ec.daoDatos.RepresentanteDAO;
import ups.edu.ec.model.Representante;

public class GestionRepresentateTest {

    @Mock
    private RepresentanteDAO representanteDAO;

    @InjectMocks
    private GestionRepresentate gestionRepresentate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        Representante representante = new Representante();
        gestionRepresentate.save(representante);
        verify(representanteDAO).create(representante);
    }

    @Test
    public void testGetAll() throws Exception {
        when(representanteDAO.findAll()).thenReturn(Collections.singletonList(new Representante()));

        List<Representante> representantes = gestionRepresentate.getAll();
        assertEquals(1, representantes.size());
    }

    @Test
    public void testUpdate() throws Exception {
        Representante representante = new Representante();
        gestionRepresentate.update(representante);
        verify(representanteDAO).update(representante);
    }

    @Test
    public void testFindById() throws Exception {
        Representante representante = new Representante();
        representante.setId(1);
        when(representanteDAO.read(1)).thenReturn(representante);

        Representante result = gestionRepresentate.findById(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testDelete() throws Exception {
        gestionRepresentate.delete(1);
        verify(representanteDAO).delete(1);
    }

    @Test
    public void testSaveThrowsExceptionOnNull() {
        Exception exception = assertThrows(Exception.class, () -> {
            gestionRepresentate.save(null);
        });

        assertEquals("Representante vacio !", exception.getMessage());
    }
}