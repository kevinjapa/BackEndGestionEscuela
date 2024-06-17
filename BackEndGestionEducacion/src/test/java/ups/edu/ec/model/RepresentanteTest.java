package ups.edu.ec.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RepresentanteTest {

    @Test
    public void testRepresentanteAttributes() {
        Representante representante = new Representante();
        representante.setId(1);
        representante.setNombre("Juan");
        representante.setApellido("Perez");
        representante.setCedula("1234567890");
        representante.setProfesion("Ingeniero");
        representante.setTelefono("0987654321");
        representante.setDireccion("Calle Falsa 123");

        assertEquals(1, representante.getId());
        assertEquals("Juan", representante.getNombre());
        assertEquals("Perez", representante.getApellido());
        assertEquals("1234567890", representante.getCedula());
        assertEquals("Ingeniero", representante.getProfesion());
        assertEquals("0987654321", representante.getTelefono());
        assertEquals("Calle Falsa 123", representante.getDireccion());
    }
}