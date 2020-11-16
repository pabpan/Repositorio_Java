/*
 * PRÁCTICA CRUD
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DISEÑO DE INTERFACES
 * 
 */
package Modelo;

public class Cliente {

    private int id, telefono;
    private String nombre, apellidos, direccion, localidad;

    public Cliente() {
    }

    public Cliente(String nombre) {
        this.nombre=nombre;
    }
    
    public Cliente(int id, String nombre, String apellidos, String direccion, String localidad, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", localidad=" + localidad + ", telefono=" + telefono + '}';
    }
}
