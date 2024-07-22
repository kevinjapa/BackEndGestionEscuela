package ups.edu.ec.negocio;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.daoDatos.RepresentanteDAO;
import ups.edu.ec.model.Anio_Lectivo;
import ups.edu.ec.model.Representante;

import java.util.List;

@Stateless
public class GestionRepresentate {
    @Inject
    private RepresentanteDAO representanteDAO;

    public void save(Representante representante) throws Exception{
        if (representante == null) {
            throw new Exception("Representante vacio !");
        } else {
            System.out.println("Se crea un nuevo Representante.");
            try {
                this.representanteDAO.create(representante);
            } catch (Exception e) {
                throw new Exception("Error al crear nuevo Representante: "+e.getMessage());
            }
        }
    }
    public List<Representante> getAll()  throws Exception{
        try {
            return representanteDAO.findAll();
        } catch (Exception e) {
            throw new Exception("Error al recuperar Representante de la base de datos: "+e.getMessage());
        }
    }
    public void update(Representante representante) throws Exception{
        System.out.println("Se actualiza Representante.");
        try {
            this.representanteDAO.update(representante);
        } catch (Exception e) {
            throw new Exception("Error al actualizar Representante: "+e.getMessage());
        }
    }
    public Representante findById(int id) throws Exception{
        System.out.println("Se busca Representante: "+id);
        try {
            return this.representanteDAO.read(id);
        } catch (Exception e) {
            throw new Exception("Error al encontrar Representante: "+id+", "+e.getMessage());
        }
    }
    public void delete(int id) throws Exception{
        System.out.println("Se elimina Representante: "+id);
        try {
            this.representanteDAO.delete(id);
        } catch (Exception e) {
            throw new Exception("Error al eliminar Representante: "+id+", "+e.getMessage());
        }
    }

    public Representante findByCedula(String cedula) throws Exception {
        System.out.println("Se busca Representante por cédula: " + cedula);
        try {
            return this.representanteDAO.findByCedula(cedula);
        } catch (Exception e) {
            throw new Exception("Error al encontrar Representante por cédula: " + cedula + ", " + e.getMessage());
        }
    }



}
