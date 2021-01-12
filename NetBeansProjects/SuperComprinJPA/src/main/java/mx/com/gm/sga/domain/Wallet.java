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
@Table(name = "ewallet")
public class Wallet implements Serializable {

    private static final long SerialVersionUID = 1L;
    private static int contador = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_wallet")
    private int id_wallet;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "DNI")
    private String DNI;
    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;
    @Column(name = "email")
    private String email;
    @Column(name = "saldo_puntos")
    private int saldo_puntos;
    @Column(name = "saldo_euros")
    private int saldo_euros;

    public Wallet() {
    }

    public Wallet(int id_wallet, String nombre, String apellidos, String DNI, Date fecha_nacimiento, String email, int saldo_puntos, int saldo_euros) {
        this.id_wallet = id_wallet;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email = email;
        this.saldo_puntos = saldo_puntos;
        this.saldo_euros = saldo_euros;
    }

    public Wallet(String nombre, String apellidos, String DNI, Date fecha_nacimiento, String email, int saldo_puntos, int saldo_euros) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email = email;
        this.saldo_puntos = saldo_puntos;
        this.saldo_euros = saldo_euros;
    }

    public int getId_wallet() {
        return id_wallet;
    }

    public void setId_wallet(int id_wallet) {
        this.id_wallet = id_wallet;
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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public int getSaldo_puntos() {
        return saldo_puntos;
    }

    public void setSaldo_puntos(int saldo_puntos) {
        this.saldo_puntos = saldo_puntos;
    }

    public int getSaldo_euros() {
        return saldo_euros;
    }

    public void setSaldo_euros(int saldo_euros) {
        this.saldo_euros = saldo_euros;
    }

    @Override
    public String toString() {
        contador++;
        return "id_wallet= " + id_wallet + ", Nombre= " + nombre + ", Apellidos= " + apellidos + ", DNI= " + DNI + ", Fecha de nacimiento= " + fecha_nacimiento + ", Email= " + email + ", Saldo de puntos= " + saldo_puntos + ", Saldo en euros= " + saldo_euros + '.';
    }
}
