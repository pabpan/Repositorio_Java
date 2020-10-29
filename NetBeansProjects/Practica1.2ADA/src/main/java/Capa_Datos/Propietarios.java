/*
 * PRÁCTICA 1
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - ACCESO A DATOS
 * 
 */
package Capa_Datos;

public class Propietarios {

    private String DNI;
    private String nombre;
    private int edad;

    public Propietarios(String DNI, String nombre, int edad) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Propietarios(String DNI) {
        this.DNI = DNI;
    }

    public Propietarios(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Propietarios() {
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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

    @Override
    public String toString() {
        return "{" + nombre + ", DNI: " + DNI + ", edad: " + edad + "}";
    }
}
