package ups.edu.ec.DaoInterface;

import ups.edu.ec.model.Alumno;

import java.util.List;

public interface AlumnoDao {
    void create(Alumno alumno);
    Alumno search(int id);
    void update(Alumno alumno);
    void delete(int id);
    List<Alumno> getAll();
}
