/**
 * @autor ---------> Pablo Suárez
 * @curso ---------> 2DAM
 * @descripción ---> SUPERCOMPRÍN
 */
package mx.com.gm.sga.domain;

import java.sql.Date;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "devolucion")
public class Devolucion implements Serializable {

    private static final long SerialVersionUID = 1L;
    private static int contador = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_devolucion")
    private int id_devolucion;
    @Column(name = "id_wallet")
    private int id_wallet;
    @Column(name = "id_producto")
    private int id_producto;
    @Column(name = "fecha_devolucion")
    private Date fecha_devolucion;

    public Devolucion() {
    }

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
        return "id_devolucion= " + id_devolucion + ", id_wallet= " + id_wallet + ", id_producto= " + id_producto + ", fecha_devolucion= " + fecha_devolucion + '.';
    }
}
