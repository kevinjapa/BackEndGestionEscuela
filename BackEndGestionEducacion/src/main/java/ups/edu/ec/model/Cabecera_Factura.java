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
    private int id_representante;
    private int id_alumno;
    private String cedula;
    private String direccion;
    private String telefono;
    private Date fechaEmision;
    private int id_anioLectivo;

    @OneToMany(mappedBy = "cabeceraFactura")
    private List<Detalle_Factura> detalles;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Cabecera_Factura(){

    }

    public Cabecera_Factura(int id, int codigo_Factura, int id_representante, int id_alumno, String cedula, String direccion, String telefono, Date fechaEmision, int id_anioLectivo) {
        this.id = id;
        this.codigo_Factura = codigo_Factura;
        this.id_representante = id_representante;
        this.id_alumno = id_alumno;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaEmision = fechaEmision;
        this.id_anioLectivo = id_anioLectivo;
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

    public int getId_representante() {
        return id_representante;
    }

    public void setId_representante(int id_representante) {
        this.id_representante = id_representante;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
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

    @Override
    public String toString() {
        return "Cabecera_Factura{" +
                "id=" + id +
                ", codigo_Factura=" + codigo_Factura +
                ", id_representante=" + id_representante +
                ", id_alumno=" + id_alumno +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaEmision=" + fechaEmision +
                ", id_anioLectivo=" + id_anioLectivo +
                '}';
    }
}
