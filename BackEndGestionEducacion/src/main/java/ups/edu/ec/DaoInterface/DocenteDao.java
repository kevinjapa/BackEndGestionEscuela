package ups.edu.ec.DaoInterface;


import ups.edu.ec.model.Docente;

import java.util.List;

public interface DocenteDao {
    void create(Docente docente);
    Docente search(int id);
    void update(Docente docente);
    void delete(int id);
    List<Docente> getAll();
}
