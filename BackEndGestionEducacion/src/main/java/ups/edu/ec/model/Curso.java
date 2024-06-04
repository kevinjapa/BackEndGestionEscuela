package ups.edu.ec.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id_docente;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "anio_lectivo_id")
    private Anio_Lectivo anioLectivo;

    @ManyToMany(mappedBy = "cursos")
    private List<Alumno> alumnos;

    public Curso(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_docente() {
        return id_docente;
    }

    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", id_docente=" + id_docente +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
