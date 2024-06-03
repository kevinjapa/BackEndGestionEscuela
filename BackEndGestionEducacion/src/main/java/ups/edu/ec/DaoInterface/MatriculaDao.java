package ups.edu.ec.DaoInterface;


import ups.edu.ec.model.Matricula;

import java.util.List;

public interface MatriculaDao {
    void create(Matricula matricula);
    Matricula search(int id);
    void update(Matricula matricula);
    void delete(int id);
    List<Matricula> getAll();
}
