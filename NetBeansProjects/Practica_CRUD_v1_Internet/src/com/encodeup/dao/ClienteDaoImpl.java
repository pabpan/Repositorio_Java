/*
 * PRÁCTICA CRUD
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DISEÑO DE INTERFACES
 * 
 */
package com.encodeup.dao;

import java.sql.*;
import java.util.*;

import com.connection.Conexion;
import com.encodeup.idao.IClienteDao;
import com.encodeup.model.Cliente;

public class ClienteDaoImpl implements IClienteDao {

    @Override
    public boolean registrar(Cliente cliente) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;

        String sql = "INSERT INTO cliente values (NULL,'" + cliente.getNombre() + "','" + cliente.getApellidos() + "','" + cliente.getDireccion()
                + "','" + cliente.getLocalidad() + "','" + cliente.getTelefono() + "')";

        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: Clase ClienteDaoImple, método registrar");
            e.printStackTrace();
        }
        return registrar;
    }

    @Override
    public List<Cliente> obtener() {

        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM CLIENTE ORDER BY Id_Cliente";
        List<Cliente> lista_clientes = new ArrayList<Cliente>();

        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellidos(rs.getString(3));
                cliente.setDireccion(rs.getString(4));
                cliente.setLocalidad(rs.getString(5));
                cliente.setTelefono(rs.getInt(6));
                lista_clientes.add(cliente);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }
        return lista_clientes;
    }

    @Override
    public boolean actualizar(Cliente cliente) {
        boolean actualizar = false;
        Connection con = null;
        Statement stm = null;

        String sql = "UPDATE CLIENTE SET Nombre='" + cliente.getNombre() + "', Apellidos='" + cliente.getApellidos() + "', Direccion='" + cliente.getDireccion()
                + "', Localidad='" + cliente.getLocalidad() + "', Telefono='" + cliente.getTelefono() + "'" + " WHERE Id_Cliente=" + cliente.getId();

        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (Exception e) {
            System.out.println("Error: Clase ClienteDaoImple, método actualizar");
            e.printStackTrace();
        }

        return actualizar;
    }

    @Override
    public boolean eliminar(Cliente cliente) {
        boolean eliminar = false;
        Connection con = null;
        Statement stm = null;

        String sql = "DELETE FROM CLIENTE WHERE Id_Cliente="+cliente.getId();
        
        try {
            con=Conexion.conectar();
            stm=con.createStatement();
            stm.execute(sql);
            eliminar=true;
        } catch (Exception e) {
            System.out.println("Error: Clase ClienteDaoImple, método eliminar");
            e.printStackTrace();
        }

        return eliminar;
    }

}
