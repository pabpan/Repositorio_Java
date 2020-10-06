package repaso_java.Ejercicio7;

public class Estudiante {

    private String Nombre;
    private int Edad;
    private String DNI;
    private float nota;
    private String clase;

    public Estudiante (String Nombre, int Edad, String DNI, float  nota, String clase) {

        this.Nombre = Nombre;
        this.Edad = Edad;
        this.DNI=DNI;
        this.nota=nota;
        this.clase=clase;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

}
