package ups.edu.ec.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "docente_id", nullable = true)
    private Docente docente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "anio_lectivo_id", nullable = true)
    private Anio_Lectivo anioLectivo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "curso_alumno",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "alumno_id")
    )
    private List<Alumno> alumnos;

    @Transient
    private Integer docenteId;

    @Transient
    private Integer anioLectivoId;

    @Transient
    private List<Integer> alumnoIds;

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

    public Integer getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(Integer docenteId) {
        this.docenteId = docenteId;
        if (docenteId != null) {
            Docente docente = new Docente();
            docente.setId(docenteId);
            setDocente(docente);
        }
    }

    public Integer getAnioLectivoId() {
        return anioLectivoId;
    }

    public void setAnioLectivoId(Integer anioLectivoId) {
        this.anioLectivoId = anioLectivoId;
        if (anioLectivoId != null) {
            Anio_Lectivo anioLectivo = new Anio_Lectivo();
            anioLectivo.setId(anioLectivoId);
            setAnioLectivo(anioLectivo);
        }
    }

    public List<Integer> getAlumnoIds() {
        return alumnoIds;
    }

    public void setAlumnoIds(List<Integer> alumnoIds) {
        this.alumnoIds = alumnoIds;
        if (alumnoIds != null) {
            this.alumnos = alumnoIds.stream().map(id -> {
                Alumno alumno = new Alumno();
                alumno.setId(id);
                return alumno;
            }).collect(Collectors.toList());
        }
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", docente=" + docente +
                ", anioLectivo=" + anioLectivo +
                ", alumnos=" + alumnos +
                '}';
    }
}