/*
 * PRÁCTICA CRUD
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DISEÑO DE INTERFACES
 * 
 */
package Modelo;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class DAOCliente {

    Conexion conexion;
    Cliente cliente = new Cliente();

    public DAOCliente() {
        conexion = new Conexion();
    }

    public String insertar_cliente(int id, String nombre, String apellidos, String direccion, String localidad, int telefono) {

        String respuesta_registro = null;

        Connection con = null;
        PreparedStatement pst;

        String sql = "INSERT INTO CLIENTE VALUES (?, ?, ?, ?, ?, ?)";

        try {

            con = Conexion.conectar();
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, nombre);
            pst.setString(3, apellidos);
            pst.setString(4, direccion);
            pst.setString(5, localidad);
            pst.setInt(6, telefono);

            int filas = pst.executeUpdate();

            if (filas > 0) {
                con.close();
                respuesta_registro = "Usuario dado de alta";
            } else {
                con.close();
                respuesta_registro = "No se ha podido crear el usuario";
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió el siguiente error: " + e.getMessage());
        }
        return respuesta_registro;
    }

    public int actualizar_Usuario(int id, String nombre, String apellidos, String direccion, String localidad, int telefono) {

        int filas_afectadas = 0;

        Connection con = null;
        PreparedStatement pst;

        String sql = "UPDATE CLIENTE SET Nombre=?, Apellidos=?, Direccion=?, Localidad=?, Telefono=? WHERE Id_Cliente=?";

        try {
            con = Conexion.conectar();
            pst = con.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, apellidos);
            pst.setString(3, direccion);
            pst.setString(4, localidad);
            pst.setInt(5, telefono);
            pst.setInt(6, id);

            filas_afectadas = pst.executeUpdate();

        } catch (Exception e) {
        }
        return filas_afectadas;
    }

    public int eliminar_cliente(int id) {
        int filas_afectadas = 0;

        Connection con = null;
        PreparedStatement pst;

        String sql = "DELETE FROM CLIENTE WHERE Id_Cliente = ?";

        try {
            con = Conexion.conectar();
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            filas_afectadas = pst.executeUpdate();
        } catch (Exception e) {
        }
        return filas_afectadas;
    }

    public ArrayList<Cliente> lista_Cliente() {

        ArrayList lista_cliente = new ArrayList<>();
        Cliente cliente;

        try {
            Connection acceder_BD = conexion.conectar();
            PreparedStatement pst = acceder_BD.prepareStatement("SELECT * FROM CLIENTE");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellidos(rs.getString(3));
                cliente.setDireccion(rs.getString(4));
                cliente.setLocalidad(rs.getString(5));
                cliente.setTelefono(rs.getInt(6));
                lista_cliente.add(cliente);
            }
        } catch (Exception e) {
        }
        return lista_cliente;
    }

    public ArrayList<Cliente> buscar_cliente_por_apellido(String apellidos) {
        ArrayList lista_cliente = new ArrayList<>();
        Cliente cliente;
        try {
            Connection acceder_BD = conexion.conectar();
            CallableStatement cs = acceder_BD.prepareCall("{call sp_busca_por_apellidos(?)}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellidos(rs.getString(3));
                cliente.setDireccion(rs.getString(4));
                cliente.setLocalidad(rs.getString(5));
                cliente.setTelefono(rs.getInt(6));
                lista_cliente.add(cliente);
            }
        } catch (Exception e) {
        }
        return lista_cliente;
    }
}
