package ups.edu.ec.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class Cabecera_FacturaTest {
    @Test
    public void testCabeceraFacturaAttributes() {
        Cabecera_Factura cabeceraFactura = new Cabecera_Factura();
        cabeceraFactura.setId(1);
        cabeceraFactura.setCodigoFactura(12345);
        cabeceraFactura.setCedula("1234567890");
        cabeceraFactura.setDireccion("123 Calle Falsa");
        cabeceraFactura.setTelefono("0987654321");
        cabeceraFactura.setFechaEmision(LocalDate.of(2024, 1, 1));

        Usuario usuario = new Usuario();
        usuario.setId(1);
        cabeceraFactura.setUsuario(usuario);

        Detalle_Factura detalleFactura = new Detalle_Factura();
        detalleFactura.setId(1);
        cabeceraFactura.setDetalleFactura(detalleFactura);

        assertEquals(1, cabeceraFactura.getId());
        assertEquals(12345, cabeceraFactura.getCodigoFactura());
        assertEquals("1234567890", cabeceraFactura.getCedula());
        assertEquals("123 Calle Falsa", cabeceraFactura.getDireccion());
        assertEquals("0987654321", cabeceraFactura.getTelefono());
        assertEquals(LocalDate.of(2024, 1, 1), cabeceraFactura.getFechaEmision());
        assertEquals(1, cabeceraFactura.getUsuario().getId());
        assertEquals(1, cabeceraFactura.getDetalleFactura().getId());
    }
}
