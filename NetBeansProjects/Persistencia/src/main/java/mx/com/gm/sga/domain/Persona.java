package mx.com.gm.sga.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Persona implements Serializable {
  
    private static final long SerialVersionUID=1L; 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id_persona")
    private int idPersona;
    @Column(name="Nombre")    
    private String nombre;
    @Column(name="Apellidos")    
    private String apellidos;
    @Column(name="Email")    
    private String email;
    @Column(name="Edad")    
    private int edad;

    public Persona() {
    }

    public Persona(String nombre, String apellidos, String email, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.edad = edad;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", edad=" + edad + '}';
    }
}
