/*
 * PRÁCTICA 1
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - ACCESO A DATOS
 * 
 */
package Capa_Datos;

public class Coches {

    private String matricula;
    private String marca;
    private int precio;
    private String DNI;

    public Coches(String matricula, String marca, int precio, String DNI) {
        this.matricula = matricula;
        this.marca = marca;
        this.precio = precio;
        this.DNI = DNI;
    }

    public Coches(String matricula, String marca, int precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.precio = precio;
    }

    public Coches(String DNI) {
        this.DNI = DNI;
    }
    
    public Coches() {
    }

    public Coches(String marca, int precio, String DNI) {
        this.marca = marca;
        this.precio = precio;
        this.DNI = DNI;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "{" + "matricula=" + matricula + ", marca=" + marca + ", precio=" + precio + ", DNI=" + DNI + '}';
    }
}
