package ups.edu.ec.DaoInterface;


import ups.edu.ec.model.Conexion;

import java.util.List;

public interface ConexionDao {
    void create(Conexion conexion);
    Conexion search(int id);
    void update(Conexion conexion);
    void delete(int id);
    List<Conexion> getAll();
}
