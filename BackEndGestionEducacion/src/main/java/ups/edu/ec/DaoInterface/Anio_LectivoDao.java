package ups.edu.ec.DaoInterface;

import ups.edu.ec.model.Alumno;
import ups.edu.ec.model.Anio_Lectivo;

import java.util.List;

public interface Anio_LectivoDao {
    void create(Anio_Lectivo anio_lectivo);
    Anio_Lectivo search(int id);
    void update(Anio_Lectivo anio_lectivo);
    void delete(int id);
    List<Anio_Lectivo> getAll();
}
