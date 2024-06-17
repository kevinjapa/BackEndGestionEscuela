package ups.edu.ec.daoDatos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import ups.edu.ec.model.Usuario;

public class UsuarioDAOTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<Usuario> typedQuery;

    @InjectMocks
    private UsuarioDAO usuarioDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        Usuario usuario = new Usuario();
        usuarioDAO.create(usuario);
        verify(entityManager).persist(usuario);
    }

    @Test
    public void testRead() {
        Usuario usuario = new Usuario();
        usuario.setId(1);
        when(entityManager.find(Usuario.class, 1)).thenReturn(usuario);

        Usuario result = usuarioDAO.read(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testUpdate() {
        Usuario usuario = new Usuario();
        usuarioDAO.update(usuario);
        verify(entityManager).merge(usuario);
    }

    @Test
    public void testDelete() {
        Usuario usuario = new Usuario();
        usuario.setId(1);
        when(entityManager.find(Usuario.class, 1)).thenReturn(usuario);

        usuarioDAO.delete(1);
        verify(entityManager).remove(usuario);
    }

    @Test
    public void testFindAll() {
        when(entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(Collections.singletonList(new Usuario()));

        List<Usuario> usuarios = usuarioDAO.findAll();
        assertEquals(1, usuarios.size());
    }
}