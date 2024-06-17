package ups.edu.ec.daoDatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ups.edu.ec.model.Alumno;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AlumnoDAOTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<Alumno> typedQuery;

    @InjectMocks
    private AlumnoDao alumnoDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        Alumno alumno = new Alumno();
        alumnoDAO.create(alumno);
        verify(entityManager).persist(alumno);
    }

    @Test
    public void testRead() {
        Alumno alumno = new Alumno();
        alumno.setId(1);
        when(entityManager.find(Alumno.class, 1)).thenReturn(alumno);

        Alumno result = alumnoDAO.getById(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testUpdate() {
        Alumno alumno = new Alumno();
        alumnoDAO.update(alumno);
        verify(entityManager).merge(alumno);
    }

    @Test
    public void testDelete() {
        Alumno alumno = new Alumno();
        alumno.setId(1);
        when(entityManager.find(Alumno.class, 1)).thenReturn(alumno);

        alumnoDAO.delete(1);
        verify(entityManager).remove(alumno);
    }

    @Test
    public void testFindAll() {
        when(entityManager.createQuery("SELECT a FROM Alumno a", Alumno.class)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(Collections.singletonList(new Alumno()));

        List<Alumno> alumnos = alumnoDAO.getAll();
        assertEquals(1, alumnos.size());
    }
}
