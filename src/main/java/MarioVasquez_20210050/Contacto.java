package MarioVasquez_20210050;

public class Contacto {
    int id;
    String nombre;
    String apellido;
    String correo;
    String telefono;

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public Contacto(int id, String nombre, String apellido, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }
}
