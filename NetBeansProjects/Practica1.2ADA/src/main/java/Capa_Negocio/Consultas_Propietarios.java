/*
 * PRÁCTICA 1
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - ACCESO A DATOS
 * 
 */
package Capa_Negocio;

import Capa_Datos.Conexion;
import Capa_Datos.Propietarios;
import java.sql.*;
import java.util.*;

public class Consultas_Propietarios {

    private static final String SQL_SELECT = "SELECT DNI, Nombre, Edad FROM propietarios";
    private static final String SQL_INSERT = "INSERT INTO propietarios (DNI, Nombre, Edad) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE propietarios SET Nombre=?, Edad=? WHERE DNI=?";
    private static final String SQL_DELETE = "DELETE FROM propietarios WHERE DNI=?";
 
        /************************************/
        /************ SELECCIONAR ***********/
        /************************************/
    
    public List<Propietarios> seleccionar() throws SQLException {

        /*Cremos una lista de propietarios vacía*/
        List<Propietarios> lista_propietarios = new ArrayList<>();
        /*Instanciamos Conexión*/
        Connection conectar = null;
        /*Instanciamos Consultas*/
        PreparedStatement stmt = null;
        /*Instanciamos Resultado*/
        ResultSet rs = null;
        /*Creamos un usuario nuevo vacío*/
        Propietarios propietario_nuevo = null;


        try {
            /*Realizamos Conexión*/
            conectar = Conexion.Realizar_Conexion();
            /*Le decimos qué tipo de consulta le pasamos al Statement*/
            stmt = conectar.prepareStatement(SQL_SELECT);
            /*Al resultado le pasamos la consulta a ejecutar*/
            rs = stmt.executeQuery();
            /*Empieza el bucle dentro de la Consulta*/
            while (rs.next()) {
                String dni = rs.getString("DNI");
                String marca = rs.getString("Nombre");
                int edad = rs.getInt("Edad");
                propietario_nuevo = new Propietarios(dni, marca, edad);
                lista_propietarios.add(propietario_nuevo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            /*Cerramos las conexiones*/
            Conexion.Cerrar_Conexion(conectar);
            Conexion.Cerrar_RS(rs);
            Conexion.Cerrar_STMT(stmt);
        }
        return lista_propietarios;
    }
    
        /************************************/
        /************* INSERTAR *************/
        /************************************/
    
    public int insertar(Propietarios propietario) {
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
            stmt.setString(1, propietario.getDNI());
            stmt.setString(2, propietario.getNombre());
            stmt.setInt(3, propietario.getEdad());
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

    public int update(Propietarios propietario) {
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
            stmt.setString(1, propietario.getNombre());
            stmt.setInt(2, propietario.getEdad());
            stmt.setString(3, propietario.getDNI());
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
    
    public int delete(Propietarios propietario) {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conectar = Conexion.Realizar_Conexion();
            stmt = conectar.prepareStatement(SQL_DELETE);
            stmt.setString(1, propietario.getDNI());
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
