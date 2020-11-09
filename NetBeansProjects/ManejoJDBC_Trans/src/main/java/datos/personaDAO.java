package datos;

import java.util.*;
import domain.Persona;
import java.sql.*;
import datos.Conexion;
import static datos.Conexion.close;

public class personaDAO {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT Id_persona, Nombre, Apellidos, Edad FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (Nombre, Apellidos, Edad) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET Nombre=?, Apellidos=?, Edad=? where Id_persona=?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE Id_persona=?";

    public personaDAO(){};
    public personaDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Persona> seleccionar() throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("Id_persona");
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");
                int edad = rs.getInt("Edad");
                persona = new Persona(idPersona, nombre, apellidos, edad);
                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }
        return personas;
    }

    public int insertar(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellidos());
            stmt.setInt(3, persona.getEdad());
            registros = stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
            } catch (Exception ex) {
            }
            try {
                close(conn);
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int update(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellidos());
            stmt.setInt(3, persona.getEdad());
            stmt.setInt(4, persona.getIdPersona());
            registros = stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
            } catch (Exception ex) {
            }
            try {
                close(conn);
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int delete(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            registros = stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
            } catch (Exception ex) {
            }
            try {
                close(conn);
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
