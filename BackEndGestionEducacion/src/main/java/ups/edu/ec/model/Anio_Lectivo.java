package ups.edu.ec.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Anio_Lectivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;

    @OneToMany(mappedBy = "anioLectivo")
    private List<Curso> cursos;

    public Anio_Lectivo(){

    }

    public Anio_Lectivo(int id, String descripcion) {
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
        return "Anio_Lectivo{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
