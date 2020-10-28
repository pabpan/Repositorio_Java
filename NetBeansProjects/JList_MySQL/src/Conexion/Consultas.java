package Conexion;

import java.sql.*;
import java.util.*;

public class Consultas {

    public Cliente Buscar_por_ID(Connection conexion, Cliente cliente) throws Exception {

        Cliente c = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexion.prepareCall("SELECT * FROM clients WHERE id =?");
            stmt.setString(1, cliente.getId());
            while (rs.next()) {
                c = new Cliente();
                Fila_Cliente(rs, c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Hubp un problema buscando el cliente por id" + ex.getMessage());
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

    private void Fila_Cliente(ResultSet rs, Cliente cli) throws SQLException {
        cli.setId(rs.getString("id"));
        cli.setNotes(rs.getString("notes"));

    }

    public ArrayList<Cliente> Buscar_Todos(Connection con) throws Exception {
        ArrayList<Cliente> lista_clientes = new ArrayList();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery("Select * from clients");
            Cliente cli = null;
            while (rs.next()) {
                cli = new Cliente();
                Fila_Cliente(rs, cli);
                lista_clientes.add(cli);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Hubo un problema buscando el cliente" + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        }
        return lista_clientes;
    }
}
