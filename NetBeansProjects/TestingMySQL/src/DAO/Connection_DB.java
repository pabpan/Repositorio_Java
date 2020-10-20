/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;

public class Connection_DB {

    public Connection OpenConnection() throws Exception {
        Connection con = null; // install a connection
        try {
            String urlOdbc = "jdbc:mysql://localhost:3306/di?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

// create connection. NOTE in my case MySql user -> root, empty password
            con = (java.sql.DriverManager.getConnection(urlOdbc, "root", "0123456789"));
            return con;
        } catch (Exception e) {// SQLException and ClassNotFoundException
            e.printStackTrace();
            throw new Exception("Connection could not be established" + e.getMessage());
        }
    }

    public void CloseConnection(Connection con) throws Exception {
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("It was impossible to close the connection" + e.getMessage());
        }
    }
}
