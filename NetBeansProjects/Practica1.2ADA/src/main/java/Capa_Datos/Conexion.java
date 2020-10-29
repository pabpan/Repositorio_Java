/*
 * PRÁCTICA 1
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - ACCESO A DATOS
 * 
 */
package Capa_Datos;

import java.sql.*;

public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/concesionario?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "0123456789";

    public static Connection Realizar_Conexion() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static void Cerrar_RS(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void Cerrar_STMT(Statement smtm) throws SQLException {
        smtm.close();
    }

    public static void Cerrar_Conexion(Connection conn) throws SQLException {
        conn.close();
    }
}
