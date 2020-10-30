/*
 * PRÁCTICA 1
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - ACCESO A DATOS
 * 
 */
package Capa_Negocio;

import Capa_Datos.*;
import Capa_Datos.Conexion;
import java.sql.*;
import java.util.*;

public class Consultas_Coches {

    private static final String SQL_SELECT = "SELECT Matricula, Marca, Precio, DNI FROM coches";
    private static final String SQL_SELECT_1 = "SELECT * FROM coches WHERE DNI=?";
    private static final String SQL_INSERT = "INSERT INTO coches (Matricula, Marca, Precio, DNI) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE coches SET Marca=?, Precio=? WHERE Matricula=?";
    private static final String SQL_DELETE = "DELETE FROM coches WHERE Matricula=?";
    private static final String SQL_DELETE_1 = "DELETE FROM coches WHERE DNI=?";


        /************************************/
        /************ SELECCIONAR ***********/
        /************************************/
    
    public List<Coches> seleccionar() throws SQLException {

        /*Instanciamos Conexión*/
        Connection conectar = null;
        /*Instanciamos Consultas*/
        PreparedStatement stmt = null;
        /*Instanciamos Resultado*/
        ResultSet rs = null;
        /*Creamos un usuario nuevo vacío*/
        Coches coche_nuevo = null;
        /*Cremos una lista de usuarios vacía*/
        List<Coches> lista_coches = new ArrayList<>();

        try {
            /*Realizamos Conexión*/
            conectar = Conexion.Realizar_Conexion();
            /*Le decimos qué tipo de consulta le pasamos al Statement*/
            stmt = conectar.prepareStatement(SQL_SELECT);
            /*Al resultado le pasamos la consulta a ejecutar*/
            rs = stmt.executeQuery();
            /*Empieza el bucle dentro de la Consulta*/
            while (rs.next()) {
                String matricula = rs.getString("Matricula");
                String marca = rs.getString("Marca");
                int precio = rs.getInt("Precio");
                String dni = rs.getString("DNI");
                coche_nuevo = new Coches(matricula, marca, precio, dni);
                lista_coches.add(coche_nuevo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            /*Cerramos las conexiones*/
            Conexion.Cerrar_Conexion(conectar);
            Conexion.Cerrar_RS(rs);
            Conexion.Cerrar_STMT(stmt);
        }
        return lista_coches;
    }
    
        /************************************/
        /************* INSERTAR *************/
        /************************************/
    
    public int insertar(Coches coche) {
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
            stmt.setString(1, coche.getMatricula());
            stmt.setString(2, coche.getMarca());
            stmt.setInt(3, coche.getPrecio());
            stmt.setString(4, coche.getDNI());
                        stmt.setString(1, coche.getMatricula());

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

    public int update(Coches coche) {
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
            stmt.setString(1, coche.getMarca());
            stmt.setInt(2, coche.getPrecio());
            stmt.setString(3, coche.getMatricula());

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
    
    public int delete(Coches coche) {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conectar = Conexion.Realizar_Conexion();
            stmt = conectar.prepareStatement(SQL_DELETE);
            stmt.setString(1, coche.getMatricula());
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
        /***** SELECCIONAR POR USUARIO ******/
        /************************************/
    
    public List<Coches> seleccionar_por_usuario(Propietarios propietario) throws SQLException {

        /*Instanciamos Conexión*/
        Connection conectar = null;
        /*Instanciamos Consultas*/
        PreparedStatement stmt = null;
        /*Instanciamos Resultado*/
        ResultSet rs = null;
        /*Creamos un usuario nuevo vacío*/
        Coches coche_nuevo = null;
        /*Cremos una lista de usuarios vacía*/
        List<Coches> lista_coches = new ArrayList<>();

        try {
            /*Realizamos Conexión*/
            conectar = Conexion.Realizar_Conexion();
            /*Le decimos qué tipo de consulta le pasamos al Statement*/
            stmt = conectar.prepareStatement(SQL_SELECT_1);
            stmt.setString(1, propietario.getDNI());
            /*Al resultado le pasamos la consulta a ejecutar*/
            rs = stmt.executeQuery();
            /*Empieza el bucle dentro de la Consulta*/
            while (rs.next()) {
                String matricula = rs.getString("Matricula");
                String marca = rs.getString("Marca");
                int precio = rs.getInt("Precio");
                String dni = rs.getString("DNI");
                coche_nuevo = new Coches(matricula, marca, precio, dni);
                lista_coches.add(coche_nuevo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            /*Cerramos las conexiones*/
            Conexion.Cerrar_Conexion(conectar);
            Conexion.Cerrar_RS(rs);
            Conexion.Cerrar_STMT(stmt);
        }
        return lista_coches;
    }

        /************************************/
        /********* BORRAR POR DNI ***********/
        /************************************/
    
        public int delete_coches_por_dni(Coches coche) {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conectar = Conexion.Realizar_Conexion();
            stmt = conectar.prepareStatement(SQL_DELETE_1);
            stmt.setString(1, coche.getDNI());
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
