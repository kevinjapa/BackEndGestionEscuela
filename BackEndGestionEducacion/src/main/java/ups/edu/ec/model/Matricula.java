package ups.edu.ec.model;

import jakarta.persistence.*;

@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id", nullable = true)
    private Curso curso;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "anio_lectivo_id", nullable = true)
    private Anio_Lectivo anioLectivo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "alumno_id", nullable = true)
    private Alumno alumno;

    @Column(nullable = false)
    private Double matricula;

    @Transient
    private Integer cursoId;

    @Transient
    private Integer anioLectivoId;

    @Transient
    private Integer alumnoId;

    public Matricula() {
    }

    public Matricula(int id, String nombre, Curso curso, Anio_Lectivo anioLectivo, Alumno alumno, Double matricula) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
        this.anioLectivo = anioLectivo;
        this.alumno = alumno;
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Anio_Lectivo getAnioLectivo() {
        return anioLectivo;
    }

    public void setAnioLectivo(Anio_Lectivo anioLectivo) {
        this.anioLectivo = anioLectivo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Double getMatricula() {
        return matricula;
    }

    public void setMatricula(Double matricula) {
        this.matricula = matricula;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
        if (cursoId != null) {
            Curso curso = new Curso();
            curso.setId(cursoId);
            setCurso(curso);
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

    public Integer getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Integer alumnoId) {
        this.alumnoId = alumnoId;
        if (alumnoId != null) {
            Alumno alumno = new Alumno();
            alumno.setId(alumnoId);
            setAlumno(alumno);
        }
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", curso=" + curso +
                ", anioLectivo=" + anioLectivo +
                ", alumno=" + alumno +
                ", matricula=" + matricula +
                '}';
    }
}