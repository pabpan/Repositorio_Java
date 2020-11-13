package domain;

public class Persona {

    private int idPersona;
    private String nombre;
    private String apellidos;
    private int edad;
    private String Email;
    private int id_cambio;

    public Persona() {
    }

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getId_cambio() {
        return id_cambio;
    }

    public void setId_cambio (int idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(int idPersona, int id_cambio) {
        this.idPersona = idPersona;
        this.id_cambio = id_cambio;
    }

    public Persona(String nombre, String apellidos, int edad, String Email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Persona(int idPersona, String nombre, String apellidos, int edad) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + '}';
    }

}
