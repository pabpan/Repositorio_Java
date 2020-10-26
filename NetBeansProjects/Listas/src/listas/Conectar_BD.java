package listas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Conectar_BD {

    public Connection OpenConnection() throws Exception {
        Connection con = null; // install a connection
        try {
            String urlOdbc = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

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
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("It was impossible to close the connection" + e.getMessage());
        }
    }

    public void getClientRow(ResultSet rs, client cli) throws SQLException {
        cli.setId(rs.getString("id"));
        cli.setNotes(rs.getString("notes"));
    }

    public List<client> findAll(Connection con) throws Exception {
        List<client> listClients = new ArrayList();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery("Select * from clients");
            client cli = null;
            while (rs.next()) {
                cli = new client();
                getClientRow(rs, cli);
                listClients.add(cli);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("There was a problem searching the client" + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close(); // We close the result
            }
            if (st != null) {
                st.close(); // We close the Statement 
            }
        }
        return listClients;
    }
}
