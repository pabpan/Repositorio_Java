package mx.com.gm.sga.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name="contactos")
public class Contacto implements Serializable {
    
    private static final long SerialVersionUID=1L; 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idContacto")
    private int idContacto;
    @Column(name="nombre")    
    private String nombre;
    @Column(name="email")    
    private String email;
    @Column(name="telefono")    
    private int telefono;

    public Contacto () {
        
    }
    
    public Contacto(String nombre, String email, int telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Contacto{" + "idContacto=" + idContacto + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + '}';
    }  
}
