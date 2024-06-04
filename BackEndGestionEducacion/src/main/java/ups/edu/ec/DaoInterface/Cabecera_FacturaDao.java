package ups.edu.ec.DaoInterface;



import ups.edu.ec.model.Cabecera_Factura;

import java.util.List;

public interface Cabecera_FacturaDao {
    void create(Cabecera_Factura cabecera_factura);
    Cabecera_Factura search(int id);
    void update(Cabecera_Factura cabecera_factura);
    void delete(int id);
    List<Cabecera_Factura> getAll();
}
