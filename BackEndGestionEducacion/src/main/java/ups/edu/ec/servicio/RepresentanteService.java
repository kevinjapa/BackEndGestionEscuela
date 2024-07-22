package ups.edu.ec.servicio;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.model.Alumno;
import ups.edu.ec.model.Representante;
import ups.edu.ec.negocio.GestionRepresentate;
import ups.edu.ec.utlils.Codigos;
import ups.edu.ec.utlils.Mensajes;

import java.util.List;

@Path("/Representante")
public class RepresentanteService {

    @Inject
    private GestionRepresentate gestionRepresentate;

    @GET
    @Path("/List")
    @Produces("application/json")
    public List<Representante> getAll() throws Exception {
        try {
            return this.gestionRepresentate.getAll();
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
    public Representante getById(@PathParam("id") int id) throws Exception {
        try {
            return this.gestionRepresentate.findById(id);
        } catch (Exception e) {
            System.out.println("Error en servicio GET: objeto no encontrado " + e.getMessage());
            var error = new Error();
            error.setCodigo(Codigos.ERROR_NOT_FOUND_CODE);
            error.setMensaje(Mensajes.ERROR_NOT_FOUND_MESSAGE + " : " + e.getMessage());
            throw new Exception(error + " : " + e.getMessage());
        }
    }

    @GET
    @Path("/buscarCedula/{cedula}")
    @Produces("application/json")
    public Representante getByCedula(@PathParam("cedula") String cedula) throws Exception {
        try {
            return this.gestionRepresentate.findByCedula(cedula);
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
    public Response save(Representante representante) {
        System.out.println("Servicio POST: " + representante.toString());
        try {
            this.gestionRepresentate.save(representante);
            return Response.status(Response.Status.OK).entity(representante).build();
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
    public Response update(Representante representante) {
        System.out.println("Servicio PUT: " + representante.toString());
        try {
            Representante representateToEdit = this.gestionRepresentate.findById(representante.getId());
            if (representateToEdit == null) {
                var error = new Error();
                error.setCodigo(Codigos.ERROR_NOT_FOUND_CODE);
                error.setMensaje(Mensajes.ERROR_NOT_FOUND_MESSAGE);
                return Response.status(Response.Status.NOT_FOUND).entity(error).build();
            }
            this.gestionRepresentate.update(representante);
            return Response.status(Response.Status.OK).entity(representante).build();
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
            this.gestionRepresentate.delete(id);
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
