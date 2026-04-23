public class Diagnostico {
    private String descripcion;

    public Diagnostico(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void clon(){
        this.descripcion = this.descripcion;
    }
}
