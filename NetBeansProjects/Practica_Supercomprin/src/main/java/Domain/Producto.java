/**
 * @autor ---------> Pablo Suárez
 * @curso ---------> 2DAM
 * @descripción ---> SUPERCOMPRÍN
 */
package Domain;

public class Producto {

    private int id_producto;
    private String nombre;
    private int precio;
    private int puntos;

    public Producto(int id_producto, String nombre, int precio, int puntos) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.puntos = puntos;
    }

    public Producto(String nombre, int precio, int puntos) {
        this.nombre = nombre;
        this.precio = precio;
        this.puntos = puntos;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "id_producto= "+ id_producto + ", Nombre= " + nombre + ", Precio= " + precio + ", Puntos= " + puntos + '.';
    }
}
