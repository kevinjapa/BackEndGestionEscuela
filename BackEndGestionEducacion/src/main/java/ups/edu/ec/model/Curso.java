package ups.edu.ec.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "docente_id", nullable = false)
    private Docente docente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "anio_lectivo_id", nullable = false)
    private Anio_Lectivo anioLectivo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "curso_alumno",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "alumno_id")
    )
    private List<Alumno> alumnos;

    public Curso() {
    }


    public Curso(int id, String descripcion, Docente docente, Anio_Lectivo anioLectivo) {
        this.id = id;
        this.descripcion = descripcion;
        this.docente = docente;
        this.anioLectivo = anioLectivo;
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

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Anio_Lectivo getAnioLectivo() {
        return anioLectivo;
    }

    public void setAnioLectivo(Anio_Lectivo anioLectivo) {
        this.anioLectivo = anioLectivo;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", docente=" + docente +
                ", anioLectivo=" + anioLectivo +
                '}';
    }
}