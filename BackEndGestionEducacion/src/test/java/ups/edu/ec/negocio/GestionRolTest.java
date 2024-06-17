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

import ups.edu.ec.daoDatos.RolDAO;
import ups.edu.ec.model.Rol;

public class GestionRolTest {

    @Mock
    private RolDAO rolDAO;

    @InjectMocks
    private GestionRol gestionRol;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        Rol rol = new Rol();
        gestionRol.save(rol);
        verify(rolDAO).create(rol);
    }

    @Test
    public void testGetAll() throws Exception {
        when(rolDAO.findAll()).thenReturn(Collections.singletonList(new Rol()));

        List<Rol> roles = gestionRol.getAll();
        assertEquals(1, roles.size());
    }

    @Test
    public void testUpdate() throws Exception {
        Rol rol = new Rol();
        gestionRol.update(rol);
        verify(rolDAO).update(rol);
    }

    @Test
    public void testFindById() throws Exception {
        Rol rol = new Rol();
        rol.setId(1);
        when(rolDAO.read(1)).thenReturn(rol);

        Rol result = gestionRol.findById(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testDelete() throws Exception {
        gestionRol.delete(1);
        verify(rolDAO).delete(1);
    }

    @Test
    public void testSaveThrowsExceptionOnNull() {
        Exception exception = assertThrows(Exception.class, () -> {
            gestionRol.save(null);
        });

        assertEquals("Rol vacio !", exception.getMessage());
    }
}