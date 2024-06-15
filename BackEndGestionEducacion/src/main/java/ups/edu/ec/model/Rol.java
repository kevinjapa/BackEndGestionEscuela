package ups.edu.ec.model;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int id;

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "rol", fetch = FetchType.EAGER)
    @JsonbTransient // Evita la referencia circular durante la serialización
    private List<Usuario> usuarios;

    @Transient
    private Integer usuarioId;

    public Rol() {
    }

    public Rol(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
        if (usuarioId != null) {
            Usuario usuario = new Usuario();
            usuario.setId(usuarioId);
            this.usuarios.add(usuario);
        }
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}