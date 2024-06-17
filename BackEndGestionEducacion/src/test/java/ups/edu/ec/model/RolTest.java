package ups.edu.ec.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class RolTest {

    @Test
    public void testRolAttributes() {
        Rol rol = new Rol();
        rol.setId(1);
        rol.setDescripcion("Administrador");

        assertEquals(1, rol.getId());
        assertEquals("Administrador", rol.getDescripcion());
        assertNull(rol.getUsuarios());
    }

    @Test
    public void testAddUsuario() {
        Rol rol = new Rol();
        rol.setUsuarios(new ArrayList<>());

        Usuario usuario = new Usuario();
        usuario.setId(1);
        rol.getUsuarios().add(usuario);

        assertEquals(1, rol.getUsuarios().size());
        assertEquals(1, rol.getUsuarios().get(0).getId());
    }
}