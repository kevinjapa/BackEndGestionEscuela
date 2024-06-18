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
import ups.edu.ec.model.Detalle_Factura;

public class Detalle_FacturaDAOTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<Detalle_Factura> typedQuery;

    @InjectMocks
    private Detalle_FacturaDAO detalleFacturaDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        Detalle_Factura detalleFactura = new Detalle_Factura();
        detalleFacturaDao.create(detalleFactura);
        verify(entityManager).persist(detalleFactura);
    }

    @Test
    public void testRead() {
        Detalle_Factura detalleFactura = new Detalle_Factura();
        detalleFactura.setId(1);
        when(entityManager.find(Detalle_Factura.class, 1)).thenReturn(detalleFactura);

        Detalle_Factura result = detalleFacturaDao.read(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testUpdate() {
        Detalle_Factura detalleFactura = new Detalle_Factura();
        detalleFacturaDao.update(detalleFactura);
        verify(entityManager).merge(detalleFactura);
    }

    @Test
    public void testDelete() {
        Detalle_Factura detalleFactura = new Detalle_Factura();
        detalleFactura.setId(1);
        when(entityManager.find(Detalle_Factura.class, 1)).thenReturn(detalleFactura);

        detalleFacturaDao.delete(1);
        verify(entityManager).remove(detalleFactura);
    }

    @Test
    public void testFindAll() {
        when(entityManager.createQuery("SELECT d FROM Detalle_Factura d", Detalle_Factura.class)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(Collections.singletonList(new Detalle_Factura()));

        List<Detalle_Factura> detalleFacturas = detalleFacturaDao.findAll();
        assertEquals(1, detalleFacturas.size());
    }
}
