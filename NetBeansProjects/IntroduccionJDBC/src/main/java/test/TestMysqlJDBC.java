package test;

import java.sql.*;

public class TestMysqlJDBC {

    public static void main(String[] args) throws SQLException {

        try {
            String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "0123456789");
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT Id_persona, Nombre, Apellidos, Edad FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                System.out.println("Id_persona: " + resultado.getInt("Id_persona"));
                System.out.println("Nombre: " + resultado.getString("Nombre"));
                System.out.println("Apellidos " + resultado.getString("Apellidos"));
                System.out.println("Id_persona: " + resultado.getInt("Edad"));
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
