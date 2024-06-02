package ups.edu.ec.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.DaoImpl.AlumnoDaoImp;
import ups.edu.ec.model.Alumno;

@Path("/alumno")
public class AlumnoController {
    @Inject
    private AlumnoDaoImp alumnoDaoImp;
    @POST
    @Path("/create")
    public Response createAlumno(Alumno alumno) {
        alumnoDaoImp.create(alumno);
        return Response.status(Response.Status.CREATED).entity(alumno).build();
    }

}
