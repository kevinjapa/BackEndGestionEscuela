package ups.edu.ec.servicio;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.model.Alumno;
import ups.edu.ec.model.Rol;
import ups.edu.ec.negocio.GestionRol;
import ups.edu.ec.utlils.Codigos;
import ups.edu.ec.utlils.Mensajes;

import java.util.List;

@Path("/Rol")
public class RolService {

    @Inject
    private GestionRol gestionRol;

    @GET
    @Path("/List")
    @Produces("application/json")
    public List<Rol> getAll() throws Exception {
        try {
            return this.gestionRol.getAll();
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
    public Rol getById(@PathParam("id") int id) throws Exception {
        try {
            return this.gestionRol.findById(id);
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
    public Response save(Rol rol) {
        System.out.println("Servicio POST: " + rol.toString());
        try {
            this.gestionRol.save(rol);
            return Response.status(Response.Status.OK).entity(rol).build();
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
    public Response update(Rol rol) {
        System.out.println("Servicio PUT: " + rol.toString());
        try {
            Rol rolToEdit = this.gestionRol.findById(rol.getId());
            if (rolToEdit == null) {
                var error = new Error();
                error.setCodigo(Codigos.ERROR_NOT_FOUND_CODE);
                error.setMensaje(Mensajes.ERROR_NOT_FOUND_MESSAGE);
                return Response.status(Response.Status.NOT_FOUND).entity(error).build();
            }
            this.gestionRol.update(rol);
            return Response.status(Response.Status.OK).entity(rol).build();
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
            this.gestionRol.delete(id);
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
