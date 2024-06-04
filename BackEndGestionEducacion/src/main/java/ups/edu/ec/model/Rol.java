package ups.edu.ec.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;

    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;

    public  Rol(){

    }

    public Rol(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
