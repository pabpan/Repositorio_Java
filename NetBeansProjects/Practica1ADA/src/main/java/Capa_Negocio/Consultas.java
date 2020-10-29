/*
 * PRÁCTICA 1
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - ACCESO A DATOS
 * 
 */
package Capa_Negocio;

import Capa_Datos.Conexion;
import Capa_Datos.Usuario;
import java.sql.*;
import java.util.*;

public class Consultas {

    private static final String SQL_SELECT = "SELECT Id_usuario, Usuario, Password FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario (Id_usuario, Usuario, Password) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET Usuario=?, Password=? where Id_usuario=?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE Id_usuario=?";

        /************************************/
        /************ SELECCIONAR ***********/
        /************************************/
    
    public List<Usuario> seleccionar() throws SQLException {

        /*Instanciamos Conexión*/
        Connection conectar = null;
        /*Instanciamos Consultas*/
        PreparedStatement stmt = null;
        /*Instanciamos Resultado*/
        ResultSet rs = null;
        /*Creamos un usuario nuevo vacío*/
        Usuario usuario_nuevo = null;
        /*Cremos una lista de usuarios vacía*/
        List<Usuario> lista_usuarios = new ArrayList<>();

        try {
            /*Realizamos Conexión*/
            conectar = Conexion.Realizar_Conexion();
            /*Le decimos qué tipo de consulta le pasamos al Statement*/
            stmt = conectar.prepareStatement(SQL_SELECT);
            /*Al resultado le pasamos la consulta a ejecutar*/
            rs = stmt.executeQuery();
            /*Empieza el bucle dentro de la Consulta*/
            while (rs.next()) {
                int id_usuario = rs.getInt("Id_usuario");
                String usuario = rs.getString("Usuario");
                String password = rs.getString("Password");
                usuario_nuevo = new Usuario(id_usuario, usuario, password);
                lista_usuarios.add(usuario_nuevo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            /*Cerramos las conexiones*/
            Conexion.Cerrar_Conexion(conectar);
            Conexion.Cerrar_RS(rs);
            Conexion.Cerrar_STMT(stmt);
        }
        return lista_usuarios;
    }
    
        /************************************/
        /************* INSERTAR *************/
        /************************************/
    
    public int insertar(Usuario usuario) {
        /*Instanciamos Conexión*/
        Connection conectar = null;
        /*Instanciamos Consultas*/
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            /*Realizamos Conexión*/
            conectar = Conexion.Realizar_Conexion();
            /*Le decimos qué tipo de consulta le pasamos al Statement*/
            stmt = conectar.prepareStatement(SQL_INSERT);
            /*Le asignamos los campos los valores introducido en el principal*/
            stmt.setInt(1, usuario.getId_usuario());
            stmt.setString(2, usuario.getUsuario());
            stmt.setString(3, usuario.getPassword());
            /*Ejecutamos la consulta*/
            registros = stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            /*Cerramos las conexiones*/
        } finally {
            try {
                Conexion.Cerrar_STMT(stmt);
            } catch (Exception ex) {
            }
            try {
                Conexion.Cerrar_Conexion(conectar);
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
        /************************************/
        /************ ACTUALIZAR ***********/
        /************************************/

    public int update(Usuario usuario) {
        /*Instanciamos Conexión*/
        Connection conectar = null;
        /*Instanciamos Consultas*/
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            /*Realizamos Conexión*/
            conectar = Conexion.Realizar_Conexion();
            /*Le decimos qué tipo de consulta le pasamos al Statement*/
            stmt = conectar.prepareStatement(SQL_UPDATE);
            /*Le asignamos los campos los valores introducido en el principal*/
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getId_usuario());
            /*Ejecutamos la consulta*/
            registros = stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            /*Cerramos las conexiones*/
        } finally {
            try {
                Conexion.Cerrar_STMT(stmt);
            } catch (Exception ex) {
            }
            try {
                Conexion.Cerrar_Conexion(conectar);
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

        /************************************/
        /************** BORRAR **************/
        /************************************/
    
    public int delete(Usuario usuario) {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conectar = Conexion.Realizar_Conexion();
            stmt = conectar.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getId_usuario());
            registros = stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            /*Cerramos las conexiones*/
        } finally {
            try {
                Conexion.Cerrar_STMT(stmt);
            } catch (Exception ex) {
            }
            try {
                Conexion.Cerrar_Conexion(conectar);
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
