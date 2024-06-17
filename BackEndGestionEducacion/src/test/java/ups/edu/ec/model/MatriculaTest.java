package ups.edu.ec.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class MatriculaTest {

    @Test
    public void testMatriculaAttributes() {
        Matricula matricula = new Matricula();
        matricula.setId(1);
        matricula.setNombre("Matricula 1");
        matricula.setMatricula(150.0);

        assertEquals(1, matricula.getId());
        assertEquals("Matricula 1", matricula.getNombre());
        assertEquals(150.0, matricula.getMatricula());
        assertNull(matricula.getCurso());
        assertNull(matricula.getAnioLectivo());
        assertNull(matricula.getAlumno());
    }
}