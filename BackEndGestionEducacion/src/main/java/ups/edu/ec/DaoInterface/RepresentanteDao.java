package ups.edu.ec.DaoInterface;


import ups.edu.ec.model.Representante;

import java.util.List;

public interface RepresentanteDao {
    void create(Representante representante);
    Representante search(int id);
    void update(Representante representante);
    void delete(int id);
    List<Representante> getAll();
}
