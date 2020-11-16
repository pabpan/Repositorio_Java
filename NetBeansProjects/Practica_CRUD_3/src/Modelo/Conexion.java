/*
 * PRÁCTICA CRUD
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DISEÑO DE INTERFACES
 * 
 */
package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {

    public static Connection conectar() {

        Connection conexion = null;

        String password = "0123456789";
        String usuario = "root";
        String url = "jdbc:mysql://localhost:3306/elseuinformatic?user=" + usuario + "&password=" + password;

        try {
            conexion = DriverManager.getConnection(url);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido conectar");
            e.printStackTrace();
        }
        return conexion;
    }
}
