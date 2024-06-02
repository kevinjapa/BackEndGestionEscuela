package ups.edu.ec.model;

public class Curso {

    private int id;
    private int id_docente;
    private String descripcion;

    public Curso(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_docente() {
        return id_docente;
    }

    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", id_docente=" + id_docente +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
