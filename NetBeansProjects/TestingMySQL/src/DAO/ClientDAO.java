package DAO;

import java.sql.*;
import java.util.*;

public class ClientDAO {

    public client findById(Connection con, client cli) throws Exception {
        client c = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM clients WHERE id =?");
            stmt.setString(1, cli.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                c = new client();
                getClientRow(rs, c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("There was a problem searching the client by DNI" + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close(); // We close the result
            }
            if (stmt != null) {
                stmt.close(); // We close the Statement 
            }
        }
        return c;
    }

    private void getClientRow(ResultSet rs, client cli) throws SQLException {
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
