package ups.edu.ec.model;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
//@Entity
//public class Cabecera_Factura {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private int codigo_Factura;
////    private int id_representante;
////    private int id_alumno;
//    private String cedula;
//    private String direccion;
//    private String telefono;
//
//    @JsonbDateFormat("yyyy-MM-dd")
//    private LocalDate fechaEmision;
//
////    private int id_anioLectivo;
//
//    @OneToMany(mappedBy = "cabeceraFactura")
//    private List<Detalle_Factura> detalles;
//
//    @ManyToOne
//    @JoinColumn(name = "usuario_id")
//    private Usuario usuario;
//
//    @Transient
//    private Integer usuarioId;
//
//    public Cabecera_Factura(){
//
//    }
//
//    public Cabecera_Factura(int id, int codigo_Factura, int id_representante, int id_alumno, String cedula, String direccion, String telefono, LocalDate fechaEmision, int id_anioLectivo,Usuario usuarioid) {
//        this.id = id;
//        this.codigo_Factura = codigo_Factura;
////        this.id_representante = id_representante;
////        this.id_alumno = id_alumno;
//        this.cedula = cedula;
//        this.direccion = direccion;
//        this.telefono = telefono;
//        this.fechaEmision = fechaEmision;
//        this.usuario=usuarioid;
////        this.id_anioLectivo = id_anioLectivo;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getCodigo_Factura() {
//        return codigo_Factura;
//    }
//
//    public void setCodigo_Factura(int codigo_Factura) {
//        this.codigo_Factura = codigo_Factura;
//    }
//
////    public int getId_representante() {
////        return id_representante;
////    }
//
////    public void setId_representante(int id_representante) {
////        this.id_representante = id_representante;
////    }
////
////    public int getId_alumno() {
////        return id_alumno;
////    }
//
////    public void setId_alumno(int id_alumno) {
////        this.id_alumno = id_alumno;
////    }
//
//    public String getCedula() {
//        return cedula;
//    }
//
//    public void setCedula(String cedula) {
//        this.cedula = cedula;
//    }
//
//    public String getDireccion() {
//        return direccion;
//    }
//
//    public void setDireccion(String direccion) {
//        this.direccion = direccion;
//    }
//
//    public String getTelefono() {
//        return telefono;
//    }
//
//    public void setTelefono(String telefono) {
//        this.telefono = telefono;
//    }
//
//    public LocalDate getFechaEmision() {
//        return fechaEmision;
//    }
//
//    public void setFechaEmision(LocalDate fechaEmision) {
//        this.fechaEmision = fechaEmision;
//    }
//
////    public int getId_anioLectivo() {
////        return id_anioLectivo;
////    }
////
////    public void setId_anioLectivo(int id_anioLectivo) {
////        this.id_anioLectivo = id_anioLectivo;
////    }
//
//    public List<Detalle_Factura> getDetalles() {
//        return detalles;
//    }
//
//    public void setDetalles(List<Detalle_Factura> detalles) {
//        this.detalles = detalles;
//    }
//
//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }
//
//    @Override
//    public String toString() {
//        return "Cabecera_Factura{" +
//                "id=" + id +
//                ", codigo_Factura=" + codigo_Factura +
//                ", cedula='" + cedula + '\'' +
//                ", direccion='" + direccion + '\'' +
//                ", telefono='" + telefono + '\'' +
//                ", fechaEmision=" + fechaEmision +
//                ", detalles=" + detalles +
//                ", usuario=" + usuario +
//                '}';
//    }
//
//    //    @Override
////    public String toString() {
////        return "Cabecera_Factura{" +
////                "id=" + id +
////                ", codigo_Factura=" + codigo_Factura +
//////                ", id_representante=" + id_representante +
//////                ", id_alumno=" + id_alumno +
////                ", cedula='" + cedula + '\'' +
////                ", direccion='" + direccion + '\'' +
////                ", telefono='" + telefono + '\'' +
////                ", fechaEmision=" + fechaEmision +
//////                ", id_anioLectivo=" + id_anioLectivo +
////                '}';
////    }
//}

import java.io.Serializable;


@Entity
public class Cabecera_Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int codigoFactura;
    private String cedula;
    private String direccion;
    private String telefono;

    @JsonbDateFormat("yyyy-MM-dd")
    private LocalDate fechaEmision;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "detalle_factura_id", nullable = true)
    private Detalle_Factura detalleFactura;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", nullable = true)
    private Usuario usuario;

    @Transient
    private Integer usuarioId;

    @Transient
    private Integer detalleFacturaId;

    public Cabecera_Factura() {}

    public Cabecera_Factura(int id, int codigoFactura, String cedula, String direccion, String telefono, LocalDate fechaEmision, Detalle_Factura detalleFactura, Integer usuarioId) {
        this.id = id;
        this.codigoFactura = codigoFactura;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaEmision = fechaEmision;
        this.detalleFactura = detalleFactura;
        this.usuarioId = usuarioId;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
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

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Detalle_Factura getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(Detalle_Factura detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
        if (usuarioId != null) {
            Usuario usuario = new Usuario();
            usuario.setId(usuarioId);
            setUsuario(usuario);
        }
    }

    public Integer getDetalleFacturaId() {
        return detalleFacturaId;
    }

    public void setDetalleFacturaId(Integer detalleFacturaId) {
        this.detalleFacturaId = detalleFacturaId;
        if (detalleFacturaId != null) {
            Detalle_Factura detalleFactura = new Detalle_Factura();
            detalleFactura.setId(detalleFacturaId);
            setDetalleFactura(detalleFactura);
        }
    }

    @Override
    public String toString() {
        return "Cabecera_Factura{" +
                "id=" + id +
                ", codigoFactura=" + codigoFactura +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaEmision=" + fechaEmision +
                ", detalleFactura=" + detalleFactura +
                ", usuario=" + usuario +
                '}';
    }
}

