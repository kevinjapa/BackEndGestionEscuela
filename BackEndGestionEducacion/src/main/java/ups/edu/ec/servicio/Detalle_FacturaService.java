package ups.edu.ec.servicio;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.daoDatos.Detalle_FacturaDAO;
import ups.edu.ec.model.Alumno;
import ups.edu.ec.model.Detalle_Factura;
import ups.edu.ec.negocio.GestionDetalle_Factura;
import ups.edu.ec.utlils.Codigos;
import ups.edu.ec.utlils.Mensajes;

import java.util.List;

@Path("/DetalleFactura")
public class Detalle_FacturaService {

    @Inject
    private GestionDetalle_Factura gestionDetalle_factura;
    @GET
    @Path("/List")
    @Produces("application/json")
    public List<Detalle_Factura> getAll() throws Exception {
        try {
            return this.gestionDetalle_factura.getAll();
        } catch (Exception e) {
            System.out.println("Error en servicio GET: " + e.getMessage());
            var error = new Error();
            error.setCodigo(Codigos.ERROR_GET_CODE);
            error.setMensaje(Mensajes.ERROR_GET_MESSAGE + " : " + e.getMessage());
            throw new Exception(error + " : " + e.getMessage());
        }
    }
    @GET
    @Path("/buscar/{id}")
    @Produces("application/json")
    public Detalle_Factura getById(@PathParam("id") int id) throws Exception {
        try {
            return this.gestionDetalle_factura.findById(id);
        } catch (Exception e) {
            System.out.println("Error en servicio GET: objeto no encontrado " + e.getMessage());
            var error = new Error();
            error.setCodigo(Codigos.ERROR_NOT_FOUND_CODE);
            error.setMensaje(Mensajes.ERROR_NOT_FOUND_MESSAGE + " : " + e.getMessage());
            throw new Exception(error + " : " + e.getMessage());
        }
    }
    @POST
    @Path("/guardar")
    @Produces("application/json")
    @Consumes("application/json")
    public Response save(Detalle_Factura detalle_factura) {
        System.out.println("Servicio POST: " + detalle_factura.toString());
        try {
            this.gestionDetalle_factura.save(detalle_factura);
            return Response.status(Response.Status.OK).entity(detalle_factura).build();
        } catch (Exception e) {
            System.out.println("Error en servicio POST: " + e.getMessage());
            var error = new Error();
            error.setCodigo(Codigos.ERROR_POST_CODE);
            error.setMensaje(Mensajes.ERROR_POST_MESSAGE + " : " + e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }
    }
    @PUT
    @Path("/actualizar")
    @Produces("application/json")
    @Consumes("application/json")
    public Response update(Detalle_Factura detalle_factura) {
        System.out.println("Servicio PUT: " + detalle_factura.toString());
        try {
            Detalle_Factura detalleFacturaToEdit = this.gestionDetalle_factura.findById(detalle_factura.getId());
            if (detalleFacturaToEdit == null) {
                var error = new Error();
                error.setCodigo(Codigos.ERROR_NOT_FOUND_CODE);
                error.setMensaje(Mensajes.ERROR_NOT_FOUND_MESSAGE);
                return Response.status(Response.Status.NOT_FOUND).entity(error).build();
            }
            this.gestionDetalle_factura.update(detalle_factura);
            return Response.status(Response.Status.OK).entity(detalle_factura).build();
        } catch (Exception e) {
            System.out.println("Error en servicio PUT: " + e.getMessage());
            var error = new Error();
            error.setCodigo(Codigos.ERROR_PUT_CODE);
            error.setMensaje(Mensajes.ERROR_PUT_MESSAGE + " : " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
        }
    }
    @DELETE
    @Path("/eliminar/{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            this.gestionDetalle_factura.delete(id);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            System.out.println("Error en servicio DELETE: " + e.getMessage());
            var error = new Error();
            error.setCodigo(Codigos.ERROR_DELETE_CODE);
            error.setMensaje(Mensajes.ERROR_DELETE_MESSAGE + " : " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
        }
    }
}
