package datos;

import java.util.*;
import domain.Persona;
import java.sql.*;
import static datos.Conexion.close;

public class personaDAO {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT Id_persona, Nombre, Apellidos, Edad FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (Nombre, Apellidos, Edad) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET Nombre=?, Apellidos=?, Email=?, Edad=? where Id_persona=?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE Id_persona=?";
    private static final String SQL_UPDATE_ID = "UPDATE persona SET Id_persona=? where Id_persona=?";

    public personaDAO() {
    }

    ;

    public personaDAO(Connection conexionTransaccional) {
        try {
            this.conexionTransaccional = conexionTransaccional;
        } catch (Exception e) {
        }
    }

    public void conexion() {

    }

    public List<Persona> seleccionar() throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
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
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }
        return personas;
    }

    public int insertar(Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellidos());
            stmt.setInt(3, persona.getEdad());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int update(Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellidos());
            stmt.setString(3, persona.getEmail());
            stmt.setInt(4, persona.getEdad());
            stmt.setInt(5, persona.getIdPersona());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    //CAMBIAR ID
    public int update_ID (Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_ID);
            stmt.setInt(1, persona.getId_cambio());
            stmt.setInt(2, persona.getIdPersona());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int delete(Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
