//package ups.edu.ec.negocio;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
//import java.util.Collections;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import ups.edu.ec.daoDatos.UsuarioDAO;
//import ups.edu.ec.model.Usuario;
//
//public class GestioUsuarioTest {
//
//    @Mock
//    private UsuarioDAO usuarioDAO;
//
//    @InjectMocks
//    private GestioUsuario gestioUsuario;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testSave() throws Exception {
//        Usuario usuario = new Usuario();
//        gestioUsuario.save(usuario);
//        verify(usuarioDAO).create(usuario);
//    }
//
//    @Test
//    public void testGetAll() throws Exception {
//        when(usuarioDAO.findAll()).thenReturn(Collections.singletonList(new Usuario()));
//
//        List<Usuario> usuarios = gestioUsuario.getAll();
//        assertEquals(1, usuarios.size());
//    }
//
//    @Test
//    public void testUpdate() throws Exception {
//        Usuario usuario = new Usuario();
//        gestioUsuario.update(usuario);
//        verify(usuarioDAO).update(usuario);
//    }
//
//    @Test
//    public void testFindById() throws Exception {
//        Usuario usuario = new Usuario();
//        usuario.setId(1);
//        when(usuarioDAO.read(1)).thenReturn(usuario);
//
//        Usuario result = gestioUsuario.findById(1);
//        assertEquals(1, result.getId());
//    }
//
//    @Test
//    public void testDelete() throws Exception {
//        gestioUsuario.delete(1);
//        verify(usuarioDAO).delete(1);
//    }
//
//    @Test
//    public void testSaveThrowsExceptionOnNull() {
//        Exception exception = assertThrows(Exception.class, () -> {
//            gestioUsuario.save(null);
//        });
//
//        assertEquals("Usuario vacio !", exception.getMessage());
//    }
//}