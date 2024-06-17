package ups.edu.ec.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ups.edu.ec.daoDatos.Cabecera_FacturaDAO;
import ups.edu.ec.model.Cabecera_Factura;

public class GestionCabecera_FacturaTest {
    @Mock
    private Cabecera_FacturaDAO cabeceraFacturaDAO;

    @InjectMocks
    private GestionCabecera_Factura gestionCabeceraFactura;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        Cabecera_Factura cabeceraFactura = new Cabecera_Factura();
        gestionCabeceraFactura.save(cabeceraFactura);
        verify(cabeceraFacturaDAO).create(cabeceraFactura);
    }

    @Test
    public void testGetAll() throws Exception {
        when(cabeceraFacturaDAO.getAll()).thenReturn(Collections.singletonList(new Cabecera_Factura()));

        List<Cabecera_Factura> cabeceraFacturas = gestionCabeceraFactura.getAll();
        assertEquals(1, cabeceraFacturas.size());
    }

    @Test
    public void testUpdate() throws Exception {
        Cabecera_Factura cabeceraFactura = new Cabecera_Factura();
        gestionCabeceraFactura.update(cabeceraFactura);
        verify(cabeceraFacturaDAO).update(cabeceraFactura);
    }

    @Test
    public void testFindById() throws Exception {
        Cabecera_Factura cabeceraFactura = new Cabecera_Factura();
        cabeceraFactura.setId(1);
        when(cabeceraFacturaDAO.getById(1)).thenReturn(cabeceraFactura);

        Cabecera_Factura result = gestionCabeceraFactura.findById(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testDelete() throws Exception {
        gestionCabeceraFactura.delete(1);
        verify(cabeceraFacturaDAO).delete(1);
    }

    @Test
    public void testSaveThrowsExceptionOnNull() {
        Exception exception = assertThrows(Exception.class, () -> {
            gestionCabeceraFactura.save(null);
        });

        assertEquals("Cabecera Factura vacio !", exception.getMessage());
    }
}
