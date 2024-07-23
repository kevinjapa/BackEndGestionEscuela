package ups.edu.ec.servicio;


import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.model.Alumno;
import ups.edu.ec.model.Matricula;
import ups.edu.ec.model.Representante;
import ups.edu.ec.negocio.GestionAlumno;
import ups.edu.ec.utlils.Codigos;
import ups.edu.ec.utlils.Mensajes;

import java.util.List;
@Path("/Alumno")
public class AlumnoService {

    @Inject
    private GestionAlumno gestionAlumno;

    @GET
    @Path("/List")
    @Produces("application/json")
    public List<Alumno> getAll() throws Exception {
        try {
            return this.gestionAlumno.getAll();
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
    public Alumno getById(@PathParam("id") int id) throws Exception {
        try {
            return this.gestionAlumno.findById(id);
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
public Response save(Alumno alumno) {
    System.out.println("Servicio POST: " + alumno.toString());
    try {
        if (alumno.getRepresentanteId() != null) {
            System.out.println("Representante ID recibido: " + alumno.getRepresentanteId());
        } else {
            System.out.println("No se recibió Representante ID.");
        }
        this.gestionAlumno.save(alumno);
        return Response.status(Response.Status.OK).entity(alumno).build();
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
    public Response update(Alumno alumno) {
        System.out.println("Servicio PUT: " + alumno.toString());
        try {
            Alumno alumnoToEdit = this.gestionAlumno.findById(alumno.getId());
            if (alumnoToEdit == null) {
                var error = new Error();
                error.setCodigo(Codigos.ERROR_NOT_FOUND_CODE);
                error.setMensaje(Mensajes.ERROR_NOT_FOUND_MESSAGE);
                return Response.status(Response.Status.NOT_FOUND).entity(error).build();
            }
            this.gestionAlumno.update(alumno);
            return Response.status(Response.Status.OK).entity(alumno).build();
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
            this.gestionAlumno.delete(id);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            System.out.println("Error en servicio DELETE: " + e.getMessage());
            var error = new Error();
            error.setCodigo(Codigos.ERROR_DELETE_CODE);
            error.setMensaje(Mensajes.ERROR_DELETE_MESSAGE + " : " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
        }
    }

    @GET
    @Path("/buscarCedula/{cedula}")
    @Produces("application/json")
    public Alumno getByCedula(@PathParam("cedula") String cedula) throws Exception {
        try {
            return this.gestionAlumno.findByCedula(cedula);
        } catch (Exception e) {
            System.out.println("Error en servicio GET: objeto no encontrado " + e.getMessage());
            var error = new Error();
            error.setCodigo(Codigos.ERROR_NOT_FOUND_CODE);
            error.setMensaje(Mensajes.ERROR_NOT_FOUND_MESSAGE + " : " + e.getMessage());
            throw new Exception(error + " : " + e.getMessage());
        }
    }

    @GET
    @Path("/matricula/{alumnoId}")
    @Produces("application/json")
    public Response getMatriculaByAlumnoId(@PathParam("alumnoId") int alumnoId) {
        try {
            Matricula matricula = gestionAlumno.getMatriculaByAlumnoId(alumnoId);
            return Response.ok(matricula).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al obtener matrícula por alumno").build();
        }
    }
}