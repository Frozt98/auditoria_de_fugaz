public class Paciente implements Cloneable {
    private String id;
    private String nombre;
    private int edad;
    private Diagnostico diagnostico;

    public Paciente(String id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Paciente(String id, String nombre, int edad, Diagnostico diagnostico) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.diagnostico = diagnostico;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Paciente clon = (Paciente) super.clone();
        if (this.diagnostico != null) {
            clon.diagnostico = (Diagnostico) this.diagnostico.clone();
        }
        return clon;
    }

    @Override
    public String toString() {
        return "Paciente{id='" + id + "', nombre='" + nombre + "', edad=" + edad +
                (diagnostico != null ? ", diagnostico='" + diagnostico.getDescripcion() + "'" : "") + "}";
    }
}
