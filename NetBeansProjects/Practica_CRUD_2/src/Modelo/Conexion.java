/*
 * PRÁCTICA CRUD
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DISEÑO DE INTERFACES
 * 
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection conectar() {

        Connection conexion = null;

        String password = "0123456789";
        String usuario = "root";
        String url = "jdbc:mysql://localhost:3306/elseuinformatic?user=" + usuario + "&password=" + password;

        try {
            conexion = DriverManager.getConnection(url);
            if (conexion != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
            e.printStackTrace();
        }
        return conexion;
    }
}
