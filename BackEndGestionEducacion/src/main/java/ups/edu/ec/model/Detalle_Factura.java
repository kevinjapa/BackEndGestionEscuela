package ups.edu.ec.model;

import jakarta.persistence.*;

@Entity
public class Detalle_Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int cantidad;
    private double subtotal;
    private double total;
    private String detalle;
    private double iva;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cabecera_factura_id", nullable = true)
    private Cabecera_Factura cabeceraFactura;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "matricula_id", nullable = true)
    private Matricula matricula;

    @Transient
    private Integer cabeceraFacturaId;

    @Transient
    private Integer matriculaId;

    public Detalle_Factura() {
    }

    public Detalle_Factura(int id, Cabecera_Factura cabeceraFactura, Matricula matricula, int cantidad, double subtotal, double total, String detalle, double iva) {
        this.id = id;
        this.cabeceraFactura = cabeceraFactura;
        this.matricula = matricula;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.total = total;
        this.detalle = detalle;
        this.iva = iva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public Cabecera_Factura getCabeceraFactura() {
        return cabeceraFactura;
    }

    public void setCabeceraFactura(Cabecera_Factura cabeceraFactura) {
        this.cabeceraFactura = cabeceraFactura;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Integer getCabeceraFacturaId() {
        return cabeceraFacturaId;
    }

    public void setCabeceraFacturaId(Integer cabeceraFacturaId) {
        this.cabeceraFacturaId = cabeceraFacturaId;
        if (cabeceraFacturaId != null) {
            Cabecera_Factura cabeceraFactura = new Cabecera_Factura();
            cabeceraFactura.setId(cabeceraFacturaId);
            setCabeceraFactura(cabeceraFactura);
        }
    }

    public Integer getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(Integer matriculaId) {
        this.matriculaId = matriculaId;
        if (matriculaId != null) {
            Matricula matricula = new Matricula();
            matricula.setId(matriculaId);
            setMatricula(matricula);
        }
    }

    @Override
    public String toString() {
        return "Detalle_Factura{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                ", total=" + total +
                ", detalle='" + detalle + '\'' +
                ", iva=" + iva +
                ", cabeceraFactura=" + cabeceraFactura +
                ", matricula=" + matricula +
                '}';
    }
}