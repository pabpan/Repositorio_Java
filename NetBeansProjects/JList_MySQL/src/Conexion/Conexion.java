package Conexion;

import java.sql.*;

public class Conexion {

    public Connection Abrir_Conexion() throws Exception {
        Connection con = null; // install a connection
        try {
            String urlOdbc = "jdbc:mysql://localhost:3306/di?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            con = (java.sql.DriverManager.getConnection(urlOdbc, "root", "0123456789"));
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Connection could not be established" + e.getMessage());
        }
    }

    public void Cerrar_Conexion(Connection con) throws Exception {
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("It was impossible to close the connection" + e.getMessage());
        }
    }
}
