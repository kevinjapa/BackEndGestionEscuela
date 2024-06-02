package ups.edu.ec.DaoImpl;

import ups.edu.ec.DaoInterface.AlumnoDao;
import ups.edu.ec.model.Alumno;
import ups.edu.ec.model.Conexion;
import java.sql.*;

import java.util.List;

public class AlumnoDaoImp implements AlumnoDao {
    private static final String URL = "jdbc:postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    Conexion conexion;
    String query;
    @Override
    public void create(Alumno alumno){
        query="Inserte Alumnos values(?)";
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement pstmt = conn.prepareStatement(query); {
                pstmt.setString(1, "hola");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Alumno search(int id) {
        return null;
    }

    @Override
    public void update(Alumno alumno) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Alumno> getAll() {
        return null;
    }
}
