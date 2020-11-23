/**
 * @autor ---------> Pablo Suárez
 * @curso ---------> 2DAM
 * @descripción ---> SUPERCOMPRÍN
 */
package Domain;

import java.sql.Date;

public class Devolucion {

    private int id_devolucion, id_wallet, id_producto;
    private Date fecha_devolucion;

    public Devolucion(int id_devolucion, int id_wallet, int id_producto, Date fecha_devolucion) {
        this.id_devolucion = id_devolucion;
        this.id_wallet = id_wallet;
        this.id_producto = id_producto;
        this.fecha_devolucion = fecha_devolucion;
    }

    public Devolucion(int id_wallet, int id_producto, Date fecha_devolucion) {
        this.id_wallet = id_wallet;
        this.id_producto = id_producto;
        this.fecha_devolucion = fecha_devolucion;
    }

    public int getId_devolucion() {
        return id_devolucion;
    }

    public void setId_devolucion(int id_devolucion) {
        this.id_devolucion = id_devolucion;
    }

    public int getId_wallet() {
        return id_wallet;
    }

    public void setId_wallet(int id_wallet) {
        this.id_wallet = id_wallet;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    @Override
    public String toString() {
        return "Devolucion{" + "id_devolucion=" + id_devolucion + ", id_wallet=" + id_wallet + ", id_producto=" + id_producto + ", fecha_devolucion=" + fecha_devolucion + '}';
    }
}
