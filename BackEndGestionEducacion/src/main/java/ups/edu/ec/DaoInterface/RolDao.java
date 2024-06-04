package ups.edu.ec.DaoInterface;


import ups.edu.ec.model.Rol;

import java.util.List;

public interface RolDao {
    void create(Rol rol);
    Rol search(int id);
    void update(Rol rol);
    void delete(int id);
    List<Rol> getAll();
}
