package ups.edu.ec.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AlumnoTest {
    @Test
    public void testAlumnoAttributes() {
        Alumno alumno = new Alumno();
        alumno.setId(1);
        alumno.setNombre("Juan");
        alumno.setApellido("Perez");
        alumno.setCedula("1234567890");
        alumno.setTelefono("0987654321");
        alumno.setEmail("juan.perez@example.com");
        alumno.setSexo("M");
        alumno.setFecha_N(LocalDate.of(2000, 1, 1));
        alumno.setDireccion("123 Calle Falsa");

        assertEquals(1, alumno.getId());
        assertEquals("Juan", alumno.getNombre());
        assertEquals("Perez", alumno.getApellido());
        assertEquals("1234567890", alumno.getCedula());
        assertEquals("0987654321", alumno.getTelefono());
        assertEquals("juan.perez@example.com", alumno.getEmail());
        assertEquals("M", alumno.getSexo());
        assertEquals(LocalDate.of(2000, 1, 1), alumno.getFecha_N());
        assertEquals("123 Calle Falsa", alumno.getDireccion());
        assertNull(alumno.getRepresentante());
    }
}
