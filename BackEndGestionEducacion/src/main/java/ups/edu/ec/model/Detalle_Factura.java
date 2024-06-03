package ups.edu.ec.model;

import jakarta.persistence.*;

public class Detalle_Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id_cabeceraFactura;
    private int id_matricula;
    private int cantidad;
    private double subtotal;
    private double total;
    private String detalle;
    private double iva;

    @ManyToOne
    @JoinColumn(name = "cabecera_factura_id")
    private Cabecera_Factura cabeceraFactura;

    public Detalle_Factura(){

    }

    public Detalle_Factura(int id, int id_cabeceraFactura, int id_matricula, int cantidad, double subtotal, double total, String detalle, double iva) {
        this.id = id;
        this.id_cabeceraFactura = id_cabeceraFactura;
        this.id_matricula = id_matricula;
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

    public int getId_cabeceraFactura() {
        return id_cabeceraFactura;
    }

    public void setId_cabeceraFactura(int id_cabeceraFactura) {
        this.id_cabeceraFactura = id_cabeceraFactura;
    }

    public int getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(int id_matricula) {
        this.id_matricula = id_matricula;
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

    @Override
    public String toString() {
        return "Detalle_Factura{" +
                "id=" + id +
                ", id_cabeceraFactura=" + id_cabeceraFactura +
                ", id_matricula=" + id_matricula +
                ", cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                ", total=" + total +
                ", detalle='" + detalle + '\'' +
                ", iva=" + iva +
                '}';
    }
}
