/**
 * @autor ---------> Pablo Suárez
 * @curso ---------> 2DAM
 * @descripción ---> SUPERCOMPRÍN
 */
package Domain;

import java.sql.*;

public class Compra {

    private static int contador=0;
    private int id_compra;
    private int id_wallet;
    private int id_producto;
    private Date fecha_compra;

    public Compra(int id_compra, int id_wallet, int id_producto, Date fecha_compra) {
        this.id_compra = id_compra;
        this.id_wallet = id_wallet;
        this.id_producto = id_producto;
        this.fecha_compra = fecha_compra;
    }

    public Compra(int id_wallet, int id_producto, Date fecha_compra) {
        this.id_wallet = id_wallet;
        this.id_producto = id_producto;
        this.fecha_compra = fecha_compra;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
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

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    @Override
    public String toString() {
        
        return "id_compra= " + id_compra + ", id_wallet= " + id_wallet + ", id_producto= " + id_producto + ", fecha_compra= " + fecha_compra + '.';
    }
}
