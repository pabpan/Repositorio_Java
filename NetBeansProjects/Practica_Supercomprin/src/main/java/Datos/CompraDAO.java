/**
 * @autor ---------> Pablo Suárez
 * @curso ---------> 2DAM
 * @descripción ---> SUPERCOMPRÍN
 */
package Datos;

import Conexion.Conexion;
import static Conexion.Conexion.*;
import Domain.Compra;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT * FROM compra";
    private static final String SQL_INSERT = "INSERT INTO compra (id_wallet, id_producto, fecha_compra) Values(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE compra SET id_wallet=?, id_producto=?, fecha_compra=? where id_compra=?";
    private static final String SQL_DELETE = "DELETE FROM compra WHERE id_compra=?";

    public CompraDAO() {
    }

    public CompraDAO(Connection conexionTransaccional) {
        try {
            this.conexionTransaccional = conexionTransaccional;
        } catch (Exception e) {
        }
    }

    //MUESTRA LISTA DE COMPRAS EXISTENTES
    public List<Compra> seleccionarCompra() throws SQLException {

        List<Compra> lista_compras = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Compra compra_aux;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_compra = rs.getInt("id_compra");
                int id_wallet = rs.getInt("id_wallet");
                int id_producto = rs.getInt("id_producto");
                Date fecha_compra = rs.getDate("fecha_compra");
                compra_aux = new Compra(id_compra, id_wallet, id_producto, fecha_compra);
                lista_compras.add(compra_aux);
            }
        } finally {
            Cerrar(rs);
            Cerrar(stmt);
            if (this.conexionTransaccional == null) {
                Cerrar(conn);
            }
        }
        return lista_compras;
    }

    public int insertarCompra(Compra c) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, c.getId_wallet());
            stmt.setInt(2, c.getId_producto());
            stmt.setDate(3, c.getFecha_compra());
            registros = stmt.executeUpdate();
        } finally {
            try {
                Cerrar(stmt);
                if (this.conexionTransaccional == null) {
                    Cerrar(conn);
                }
            } catch (SQLException ex) {
                System.out.println("EXCEPCIÓN: TRY CATCH EN INSERTAR COMPRA" + ex.getMessage());
            }
        }
        return registros;
    }

    public int actualizarCompra(Compra c) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, c.getId_wallet());
            stmt.setInt(2, c.getId_producto());
            stmt.setDate(3, c.getFecha_compra());
            stmt.setInt(4, c.getId_compra());
            registros = stmt.executeUpdate();
        } finally {
            try {
                Cerrar(stmt);
                if (this.conexionTransaccional == null) {
                    Cerrar(conn);
                }
            } catch (SQLException ex) {
                System.out.println("EXCEPCIÓN: TRY CATCH EN ACTUALIZAR COMPRA" + ex.getMessage());
            }
        }
        return registros;
    }

    public int borrarCompra(Compra c) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, c.getId_compra());
            registros = stmt.executeUpdate();
        } finally {
            try {
                Cerrar(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.Cerrar(conn);
                }
            } catch (SQLException ex) {
                System.out.println("EXCEPCIÓN: TRY CATCH EN BORRAR COMPRA" + ex.getMessage());
            }
        }
        return registros;
    }
}
