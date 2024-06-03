package ups.edu.ec.DaoInterface;


import ups.edu.ec.model.Usuario;

import java.util.List;

public interface UsuarioDao {
    void create(Usuario usuario);
    Usuario search(int id);
    void update(Usuario usuario);
    void delete(int id);
    List<Usuario> getAll();
}
