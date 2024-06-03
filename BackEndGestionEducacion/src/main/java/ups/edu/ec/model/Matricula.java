package ups.edu.ec.model;

import jakarta.persistence.*;

public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id_alumno;
    private String nombre;
    private int id_curso;
    private int id_anio_lectivo;
    private Double matricula;

    public Matricula(){

    }

    public Matricula(int id, int id_alumno, String nombre, int id_curso, int id_anio_lectivo, Double matricula) {
        this.id = id;
        this.id_alumno = id_alumno;
        this.nombre = nombre;
        this.id_curso = id_curso;
        this.id_anio_lectivo = id_anio_lectivo;
        this.matricula = matricula;
    }

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public int getId_anio_lectivo() {
        return id_anio_lectivo;
    }

    public void setId_anio_lectivo(int id_anio_lectivo) {
        this.id_anio_lectivo = id_anio_lectivo;
    }

    public Double getMatricula() {
        return matricula;
    }

    public void setMatricula(Double matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", id_alumno=" + id_alumno +
                ", nombre='" + nombre + '\'' +
                ", id_curso=" + id_curso +
                ", id_anio_lectivo=" + id_anio_lectivo +
                ", matricula=" + matricula +
                '}';
    }
}
