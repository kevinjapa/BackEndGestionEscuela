package ups.edu.ec.negocio;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import ups.edu.ec.daoDatos.Cabecera_FacturaDAO;
import ups.edu.ec.model.Anio_Lectivo;
import ups.edu.ec.model.Cabecera_Factura;

import java.util.List;


@Stateless
public class GestionCabecera_Factura {
    @Inject
    private Cabecera_FacturaDAO cabecera_facturaDAO;

    public void save(Cabecera_Factura cabecera_factura) throws Exception{
        if (cabecera_factura == null) {
            throw new Exception("Cabecera Factura vacio !");
        } else {
            System.out.println("Se crea un nueva Cabecera Factura.");
            try {
                this.cabecera_facturaDAO.create(cabecera_factura);
            } catch (Exception e) {
                throw new Exception("Error al crear nuevo Cabecera Factura: "+e.getMessage());
            }
        }
    }
    public List<Cabecera_Factura> getAll()  throws Exception{
        try {
            return cabecera_facturaDAO.getAll();
        } catch (Exception e) {
            throw new Exception("Error al recuperar Cabecera Factura de la base de datos: "+e.getMessage());
        }
    }
    public void update(Cabecera_Factura cabecera_factura) throws Exception{
        System.out.println("Se actualiza Cabecera Factura.");
        try {
            this.cabecera_facturaDAO.update(cabecera_factura);
        } catch (Exception e) {
            throw new Exception("Error al actualizar Cabecera Factura: "+e.getMessage());
        }
    }
    public Cabecera_Factura findById(int id) throws Exception{
        System.out.println("Se busca Cabecera Factura: "+id);
        try {
            return this.cabecera_facturaDAO.getById(id);
        } catch (Exception e) {
            throw new Exception("Error al encontrar Cabecera Factura: "+id+", "+e.getMessage());
        }
    }
    public void delete(int id) throws Exception{
        System.out.println("Se elimina Cabecera Factura: "+id);
        try {
            this.cabecera_facturaDAO.delete(id);
        } catch (Exception e) {
            throw new Exception("Error al eliminar Cabecera Factura: "+id+", "+e.getMessage());
        }
    }
}
