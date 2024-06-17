package ups.edu.ec.daoDatos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import ups.edu.ec.model.Cabecera_Factura;

public class Cabecera_FacturaDAOTest {
    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<Cabecera_Factura> typedQuery;

    @InjectMocks
    private Cabecera_FacturaDAO cabeceraFacturaDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        Cabecera_Factura cabeceraFactura = new Cabecera_Factura();
        cabeceraFacturaDAO.create(cabeceraFactura);
        verify(entityManager).persist(cabeceraFactura);
    }

    @Test
    public void testRead() {
        Cabecera_Factura cabeceraFactura = new Cabecera_Factura();
        cabeceraFactura.setId(1);
        when(entityManager.find(Cabecera_Factura.class, 1)).thenReturn(cabeceraFactura);

        Cabecera_Factura result = cabeceraFacturaDAO.getById(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testUpdate() {
        Cabecera_Factura cabeceraFactura = new Cabecera_Factura();
        cabeceraFacturaDAO.update(cabeceraFactura);
        verify(entityManager).merge(cabeceraFactura);
    }

    @Test
    public void testDelete() {
        Cabecera_Factura cabeceraFactura = new Cabecera_Factura();
        cabeceraFactura.setId(1);
        when(entityManager.find(Cabecera_Factura.class, 1)).thenReturn(cabeceraFactura);

        cabeceraFacturaDAO.delete(1);
        verify(entityManager).remove(cabeceraFactura);
    }

    @Test
    public void testFindAll() {
        when(entityManager.createQuery("SELECT c FROM Cabecera_Factura c", Cabecera_Factura.class)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(Collections.singletonList(new Cabecera_Factura()));

        List<Cabecera_Factura> cabeceraFacturas = cabeceraFacturaDAO.getAll();
        assertEquals(1, cabeceraFacturas.size());
    }
}
