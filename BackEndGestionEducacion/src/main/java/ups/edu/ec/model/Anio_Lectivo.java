package ups.edu.ec.model;

public class Anio_Lectivo {
    private int id;
    private String descripcion;

    public Anio_Lectivo(){

    }

    public Anio_Lectivo(int id, String descripcion) {
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

    @Override
    public String toString() {
        return "Anio_Lectivo{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
