package ups.edu.ec.model;

import jakarta.persistence.*;

import java.util.List;

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String usuario;
    private String password;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @OneToMany(mappedBy = "usuario")
    private List<Cabecera_Factura> facturas;

    public Usuario(){

    }

    public Usuario(int id, String usuario, String password, String estado, Rol rol, List<Cabecera_Factura> facturas) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
        this.rol = rol;
        this.facturas = facturas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", rol=" + rol +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
