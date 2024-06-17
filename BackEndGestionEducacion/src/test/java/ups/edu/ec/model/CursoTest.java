package ups.edu.ec.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CursoTest {
    @Test
    public void testCursoAttributes() {
        Curso curso = new Curso();
        curso.setId(1);
        curso.setDescripcion("Curso de Matemáticas");

        Docente docente = new Docente();
        docente.setId(1);
        curso.setDocente(docente);

        Anio_Lectivo anioLectivo = new Anio_Lectivo();
        anioLectivo.setId(1);
        curso.setAnioLectivo(anioLectivo);

        List<Alumno> alumnos = new ArrayList<>();
        Alumno alumno = new Alumno();
        alumno.setId(1);
        alumnos.add(alumno);
        curso.setAlumnos(alumnos);

        assertEquals(1, curso.getId());
        assertEquals("Curso de Matemáticas", curso.getDescripcion());
        assertEquals(1, curso.getDocente().getId());
        assertEquals(1, curso.getAnioLectivo().getId());
        assertEquals(1, curso.getAlumnos().get(0).getId());
    }
}
