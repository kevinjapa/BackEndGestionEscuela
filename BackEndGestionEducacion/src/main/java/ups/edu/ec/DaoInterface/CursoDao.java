package ups.edu.ec.DaoInterface;



import ups.edu.ec.model.Curso;

import java.util.List;

public interface CursoDao {
    void create(Curso curso);
    Curso search(int id);
    void update(Curso curso);
    void delete(int id);
    List<Curso> getAll();
}
