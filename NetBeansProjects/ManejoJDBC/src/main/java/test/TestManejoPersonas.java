package test;

import datos.personaDAO;
import domain.Persona;
import java.sql.SQLException;
import java.util.*;

public class TestManejoPersonas {

    public static void main(String[] args) throws SQLException {
        personaDAO personaDao = new personaDAO();
        List<Persona> personas;
        
        //CREAR NUEVO REGISTRO
        //Persona personaNueva = new Persona("Paco", "Pérez", 34);
        //personaDao.insertar(personaNueva);
        
        //ACTUALIZAR NUEVO REGISTRO
        //Persona modificar_persona = new Persona(1, "fgasdfsda", "fasdgsag", 89);
        //personaDao.update(modificar_persona);
        
        //BORRAR REGISTRO
        Persona borrar_persona = new Persona(2);
        personaDao.delete(borrar_persona);
        
        personas = personaDao.seleccionar();
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
    }
}
