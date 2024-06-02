package ups.edu.ec.model;

public class Usuario {
    private int id;
    private int rol;
    private String usuario;
    private String password;
    private String estado;

    public Usuario(){

    }

    public Usuario(int id, int rol, String usuario, String password, String estado) {
        this.id = id;
        this.rol = rol;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
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
