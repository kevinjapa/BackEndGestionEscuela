package ups.edu.ec.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;

    @Column(nullable = false)
    private String usuario;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id", nullable = true)
    private Rol rol;

    @Transient
    private Integer rolId;

    public Usuario() {
    }

    public Usuario(int id, String usuario, String password, String estado, Rol rol) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
        this.rol = rol;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
        if (rolId != null) {
            Rol rol = new Rol();
            rol.setId(rolId);
            setRol(rol);
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", estado='" + estado + '\'' +
                ", rol=" + rol +
                '}';
    }
}