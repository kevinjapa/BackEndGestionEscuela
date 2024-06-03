package ups.edu.ec.DaoInterface;

import ups.edu.ec.model.Detalle_Factura;

import java.util.List;

public interface Detalle_FacturaDao {
    void create(Detalle_Factura detalle_factura);
    Detalle_Factura search(int id);
    void update(Detalle_Factura detalle_factura);
    void delete(int id);
    List<Detalle_Factura> getAll();
}
