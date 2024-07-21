package ups.edu.ec.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String cedula;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String especialidad;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "curso_id", nullable = true)
//    private Curso curso;

    @Transient
    private Integer cursoId;

    public Docente() {
    }

    public Docente(int id, String cedula, String nombre, String apellido, String email, String telefono, String especialidad, Curso curso) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.especialidad = especialidad;
//        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

//    public Curso getCurso() {
//        return curso;
//    }

//    public void setCurso(Curso curso) {
//        this.curso = curso;
//    }

    public Integer getCursoId() {
        return cursoId;
    }

//    public void setCursoId(Integer cursoId) {
//        this.cursoId = cursoId;
//        if (cursoId != null) {
//            Curso curso = new Curso();
//            curso.setId(cursoId);
//            setCurso(curso);
//        }
//    }

    @Override
    public String toString() {
        return "Docente{" +
                "id=" + id +
                ", cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", especialidad='" + especialidad + '\'' +
//                ", curso=" + curso +
                '}';
    }
}