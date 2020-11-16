/*
 * PRÁCTICA CRUD
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DISEÑO DE INTERFACES
 * 
 */
package Dao;

import Modelo.Cliente;
import Modelo.Conexion;
import Modelo.Operaciones;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class DAOCliente implements Operaciones {

    Conexion conexion = new Conexion();
    Cliente cliente = new Cliente();

    @Override
    public boolean insertar(Object objeto) {

        cliente = (Cliente) objeto;
        Connection con = null;
        PreparedStatement pst;

        String sql = "INSERT INTO CLIENTE VALUES (?, ?, ?, ?, ?, ?)";

        try {
            con = Conexion.conectar();
            pst = con.prepareStatement(sql);
            pst.setInt(1, cliente.getId());
            pst.setString(2, cliente.getNombre());
            pst.setString(3, cliente.getApellidos());
            pst.setString(4, cliente.getDireccion());
            pst.setString(5, cliente.getLocalidad());
            pst.setInt(6, cliente.getTelefono());

            int filas = pst.executeUpdate();

            if (filas > 0) {
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió el siguiente error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(Object objeto) {

        cliente = (Cliente) objeto;
        Connection con = null;
        PreparedStatement pst;

        String sql = "DELETE FROM CLIENTE WHERE Id_Cliente = ?";

        try {
            con = Conexion.conectar();
            pst = con.prepareStatement(sql);
            pst.setInt(1, cliente.getId());

            int filas = pst.executeUpdate();

            if (filas > 0) {
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió el siguiente error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Object objeto) {

        cliente = (Cliente) objeto;
        Connection con = null;
        PreparedStatement pst;

        String sql = "UPDATE CLIENTE SET Nombre=?, Apellidos=?, Direccion=?, Localidad=?, Telefono=? WHERE Id_Cliente=?";

        try {
            con = Conexion.conectar();
            pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellidos());
            pst.setString(3, cliente.getDireccion());
            pst.setString(4, cliente.getLocalidad());
            pst.setInt(5, cliente.getTelefono());
            pst.setInt(6, cliente.getId());

            int filas = pst.executeUpdate();

            if (filas > 0) {
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió el siguiente error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Object[]> consultar() {

        ArrayList<Object[]> datos = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM CLIENTE ORDER BY Id_Cliente";
        
        try {
            con = Conexion.conectar();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                Object[] fila = new Object[6];
                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                datos.add(fila);
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió el siguiente error: " + e.getMessage());
        } finally {
            return datos;
        }
    }
}
