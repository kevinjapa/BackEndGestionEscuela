package ups.edu.ec.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String email;
    private String sexo;
    private Date fecha_N;
    private String direccion;

    @OneToMany(mappedBy = "alumno", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Matricula> matriculas;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "representante_id", nullable = true)
    private Representante representante;

    @Transient
    private Integer representanteId;

    public Alumno() {
    }

    public Alumno(String nombre, String apellido, String cedula, String telefono, String email, String sexo, Date fecha_N, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.email = email;
        this.sexo = sexo;
        this.fecha_N = fecha_N;
        this.direccion = direccion;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFecha_N() {
        return fecha_N;
    }

    public void setFecha_N(Date fecha_N) {
        this.fecha_N = fecha_N;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    public Integer getRepresentanteId() {
        return representanteId;
    }

    public void setRepresentanteId(Integer representanteId) {
        this.representanteId = representanteId;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", sexo='" + sexo + '\'' +
                ", fecha_N=" + fecha_N +
                ", direccion='" + direccion + '\'' +
                ", representante=" + representante +
                '}';
    }
}