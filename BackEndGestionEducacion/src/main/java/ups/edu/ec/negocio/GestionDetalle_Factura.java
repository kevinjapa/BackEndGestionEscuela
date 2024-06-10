package ups.edu.ec.negocio;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.daoDatos.Detalle_FacturaDAO;
import ups.edu.ec.model.Detalle_Factura;

import java.util.List;

@Stateless
public class GestionDetalle_Factura {
    @Inject
    private Detalle_FacturaDAO detalle_facturaDAO;

    public void save(Detalle_Factura detalle_factura) throws Exception{
        if (detalle_factura == null) {
            throw new Exception("Detalle Factura vacio !");
        } else {
            System.out.println("Se crea un nuevo Detalle Factura.");
            try {
                this.detalle_facturaDAO.create(detalle_factura);
            } catch (Exception e) {
                throw new Exception("Error al crear nuevo Detalle Factura: "+e.getMessage());
            }
        }
    }
    public List<Detalle_Factura> getAll()  throws Exception{
        try {
            return detalle_facturaDAO.findAll();
        } catch (Exception e) {
            throw new Exception("Error al recuperar Detalle Factura de la base de datos: "+e.getMessage());
        }
    }
    public void update(Detalle_Factura detalle_factura) throws Exception{
        System.out.println("Se actualiza Detalle Factura.");
        try {
            this.detalle_facturaDAO.update(detalle_factura);
        } catch (Exception e) {
            throw new Exception("Error al actualizar Detalle Factura: "+e.getMessage());
        }
    }
    public Detalle_Factura findById(int id) throws Exception{
        System.out.println("Se busca Detalle Factura: "+id);
        try {
            return this.detalle_facturaDAO.read(id);
        } catch (Exception e) {
            throw new Exception("Error al encontrar Detalle Factura: "+id+", "+e.getMessage());
        }
    }
    public void delete(int id) throws Exception{
        System.out.println("Se elimina Detalle Factura: "+id);
        try {
            this.detalle_facturaDAO.delete(id);
        } catch (Exception e) {
            throw new Exception("Error al eliminar Detalle Factura: "+id+", "+e.getMessage());
        }
    }
}
