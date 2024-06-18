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

import ups.edu.ec.daoDatos.Detalle_FacturaDAO;
import ups.edu.ec.model.Detalle_Factura;

public class GestionDetalle_FacturaTest {

    @Mock
    private Detalle_FacturaDAO detalleFacturaDao;

    @InjectMocks
    private GestionDetalle_Factura gestionDetalleFactura;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        Detalle_Factura detalleFactura = new Detalle_Factura();
        gestionDetalleFactura.save(detalleFactura);
        verify(detalleFacturaDao).create(detalleFactura);
    }

    @Test
    public void testGetAll() throws Exception {
        when(detalleFacturaDao.findAll()).thenReturn(Collections.singletonList(new Detalle_Factura()));

        List<Detalle_Factura> detalleFacturas = gestionDetalleFactura.getAll();
        assertEquals(1, detalleFacturas.size());
    }

    @Test
    public void testUpdate() throws Exception {
        Detalle_Factura detalleFactura = new Detalle_Factura();
        gestionDetalleFactura.update(detalleFactura);
        verify(detalleFacturaDao).update(detalleFactura);
    }

    @Test
    public void testFindById() throws Exception {
        Detalle_Factura detalleFactura = new Detalle_Factura();
        detalleFactura.setId(1);
        when(detalleFacturaDao.read(1)).thenReturn(detalleFactura);

        Detalle_Factura result = gestionDetalleFactura.findById(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testDelete() throws Exception {
        gestionDetalleFactura.delete(1);
        verify(detalleFacturaDao).delete(1);
    }

    @Test
    public void testSaveThrowsExceptionOnNull() {
        Exception exception = assertThrows(Exception.class, () -> {
            gestionDetalleFactura.save(null);
        });

        assertEquals("Detalle Factura vacio !", exception.getMessage());
    }
}
