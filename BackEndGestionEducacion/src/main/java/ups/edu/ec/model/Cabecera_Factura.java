package ups.edu.ec.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
@Entity
public class Cabecera_Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int codigo_Factura;
    private String cedula;
    private String direccion;
    private String telefono;
    private Date fechaEmision;
    private int id_anioLectivo;
    private Double totalMatricula;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;

    @OneToMany(mappedBy = "cabeceraFactura", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Detalle_Factura> detalles;

    @Transient
    private Representante representante;

    @PostLoad
    @PostPersist
    @PostUpdate
    private void loadRepresentante() {
        if (this.alumno != null) {
            this.representante = this.alumno.getRepresentante();
        }
    }

    public Cabecera_Factura() {
    }

    public Cabecera_Factura(int id, int codigo_Factura, Alumno alumno, String cedula, String direccion, String telefono, Date fechaEmision, int id_anioLectivo, Double totalMatricula) {
        this.id = id;
        this.codigo_Factura = codigo_Factura;
        this.alumno = alumno;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaEmision = fechaEmision;
        this.id_anioLectivo = id_anioLectivo;
        this.totalMatricula = totalMatricula;
        loadRepresentante();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo_Factura() {
        return codigo_Factura;
    }

    public void setCodigo_Factura(int codigo_Factura) {
        this.codigo_Factura = codigo_Factura;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
        loadRepresentante();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int getId_anioLectivo() {
        return id_anioLectivo;
    }

    public void setId_anioLectivo(int id_anioLectivo) {
        this.id_anioLectivo = id_anioLectivo;
    }

    public Double getTotalMatricula() {
        return totalMatricula;
    }

    public void setTotalMatricula(Double totalMatricula) {
        this.totalMatricula = totalMatricula;
    }

    public List<Detalle_Factura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle_Factura> detalles) {
        this.detalles = detalles;
    }

    public Representante getRepresentante() {
        return representante;
    }

    @Override
    public String toString() {
        return "Cabecera_Factura{" +
                "id=" + id +
                ", codigo_Factura=" + codigo_Factura +
                ", alumno=" + alumno +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaEmision=" + fechaEmision +
                ", id_anioLectivo=" + id_anioLectivo +
                ", totalMatricula=" + totalMatricula +
                ", detalles=" + detalles +
                ", representante=" + representante +
                '}';
    }
}