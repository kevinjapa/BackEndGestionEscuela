package ups.edu.ec.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    public void testUsuarioAttributes() {
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setUsuario("testUser");
        usuario.setPassword("testPassword");
        usuario.setEstado("activo");

        assertEquals(1, usuario.getId());
        assertEquals("testUser", usuario.getUsuario());
        assertEquals("testPassword", usuario.getPassword());
        assertEquals("activo", usuario.getEstado());
        assertNull(usuario.getRol());
    }
}