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

import ups.edu.ec.daoDatos.AlumnoDao;
import ups.edu.ec.model.Alumno;

public class GestionAlumnoTest {

    @Mock
    private AlumnoDao alumnoDAO;

    @InjectMocks
    private GestionAlumno gestionAlumno;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        Alumno alumno = new Alumno();
        gestionAlumno.save(alumno);
        verify(alumnoDAO).create(alumno);
    }

    @Test
    public void testGetAll() throws Exception {
        when(alumnoDAO.getAll()).thenReturn(Collections.singletonList(new Alumno()));

        List<Alumno> alumnos = gestionAlumno.getAll();
        assertEquals(1, alumnos.size());
    }

    @Test
    public void testUpdate() throws Exception {
        Alumno alumno = new Alumno();
        gestionAlumno.update(alumno);
        verify(alumnoDAO).update(alumno);
    }

    @Test
    public void testFindById() throws Exception {
        Alumno alumno = new Alumno();
        alumno.setId(1);
        when(alumnoDAO.getById(1)).thenReturn(alumno);

        Alumno result = gestionAlumno.findById(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testDelete() throws Exception {
        gestionAlumno.delete(1);
        verify(alumnoDAO).delete(1);
    }

    @Test
    public void testSaveThrowsExceptionOnNull() {
        Exception exception = assertThrows(Exception.class, () -> {
            gestionAlumno.save(null);
        });

        assertEquals("Alumno vacío!", exception.getMessage());
    }
}
