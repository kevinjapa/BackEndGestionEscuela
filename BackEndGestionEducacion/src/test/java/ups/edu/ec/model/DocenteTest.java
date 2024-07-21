package ups.edu.ec.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class DocenteTest {
    @Test
    public void testDocenteAttributes() {
        Docente docente = new Docente();
        docente.setId(1);
        docente.setCedula("1234567890");
        docente.setNombre("Juan");
        docente.setApellido("Perez");
        docente.setEmail("juan.perez@example.com");
        docente.setTelefono("0987654321");
        docente.setEspecialidad("Matemáticas");

        Curso curso = new Curso();
        curso.setId(1);
//        docente.setCurso(curso);

        assertEquals(1, docente.getId());
        assertEquals("1234567890", docente.getCedula());
        assertEquals("Juan", docente.getNombre());
        assertEquals("Perez", docente.getApellido());
        assertEquals("juan.perez@example.com", docente.getEmail());
        assertEquals("0987654321", docente.getTelefono());
        assertEquals("Matemáticas", docente.getEspecialidad());
//        assertEquals(1, docente.getCurso().getId());
    }
}
