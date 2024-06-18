package ups.edu.ec.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class Detalle_FacturaTest {
    @Test
    public void testDetalleFacturaAttributes() {
        Detalle_Factura detalleFactura = new Detalle_Factura();
        detalleFactura.setId(1);
        detalleFactura.setCantidad(2);
        detalleFactura.setSubtotal(100.0);
        detalleFactura.setTotal(120.0);
        detalleFactura.setDetalle("Matrícula");
        detalleFactura.setIva(20.0);

        Matricula matricula = new Matricula();
        matricula.setId(1);
        detalleFactura.setMatricula(matricula);

        assertEquals(1, detalleFactura.getId());
        assertEquals(2, detalleFactura.getCantidad());
        assertEquals(100.0, detalleFactura.getSubtotal());
        assertEquals(120.0, detalleFactura.getTotal());
        assertEquals("Matrícula", detalleFactura.getDetalle());
        assertEquals(20.0, detalleFactura.getIva());
        assertEquals(1, detalleFactura.getMatricula().getId());
    }
}
