/**
 * @autor ---------> Pablo Suárez
 * @curso ---------> 2DAM
 * @descripción ---> SUPERCOMPRÍN
 */
package Datos;

import Conexion.Conexion;
import static Conexion.Conexion.*;
import Domain.Devolucion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DevolucionDAO {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT * FROM devolucion";
    private static final String SQL_INSERT = "INSERT INTO devolucion (id_wallet, id_producto, fecha_devolucion) Values(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE devolucion SET id_wallet=?, id_producto=?, fecha_devolucion=? where id_devolucion=?";
    private static final String SQL_DELETE = "DELETE FROM devolucion WHERE id_devolucion=?";

    public DevolucionDAO() {
    }

    public DevolucionDAO(Connection conexionTransaccional) {
        try {
            this.conexionTransaccional = conexionTransaccional;
        } catch (Exception e) {
        }
    }

    //MUESTRA LISTA DE WALLETS EXISTENTES
    public List<Devolucion> seleccionarDevolucion() throws SQLException {

        List<Devolucion> lista_devoluciones = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Devolucion devolucion_aux;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_devolucion = rs.getInt("id_devolucion");
                int id_wallet = rs.getInt("id_wallet");
                int id_producto = rs.getInt("id_producto");
                Date fecha_devolucion = rs.getDate("fecha_devoluciona");
                devolucion_aux = new Devolucion(id_devolucion, id_wallet, id_producto, fecha_devolucion);
                lista_devoluciones.add(devolucion_aux);
            }
        } finally {
            Cerrar(rs);
            Cerrar(stmt);
            if (this.conexionTransaccional == null) {
                Cerrar(conn);
            }
        }
        return lista_devoluciones;
    }

    public int insertarDevolucion(Devolucion d) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, d.getId_wallet());
            stmt.setInt(2, d.getId_producto());
            stmt.setDate(3, d.getFecha_devolucion());
            registros = stmt.executeUpdate();
        } finally {
            try {
                Cerrar(stmt);
                if (this.conexionTransaccional == null) {
                    Cerrar(conn);
                }
            } catch (SQLException ex) {
                System.out.println("EXCEPCIÓN: TRY CATCH EN INSERTAR DEVOLUCIÓN" + ex.getMessage());
            }
        }
        return registros;
    }

    public int actualizarDevolucion(Devolucion d) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, d.getId_wallet());
            stmt.setInt(2, d.getId_producto());
            stmt.setDate(3, d.getFecha_devolucion());
            stmt.setInt(4, d.getId_devolucion());
            registros = stmt.executeUpdate();
        } finally {
            try {
                Cerrar(stmt);
                if (this.conexionTransaccional == null) {
                    Cerrar(conn);
                }
            } catch (SQLException ex) {
                System.out.println("EXCEPCIÓN: TRY CATCH EN ACTUALIZAR DEVOLUCIÓN" + ex.getMessage());
            }
        }
        return registros;
    }

    public int borrarDevolucion(Devolucion d) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, d.getId_devolucion());
            registros = stmt.executeUpdate();
        } finally {
            try {
                Cerrar(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.Cerrar(conn);
                }
            } catch (SQLException ex) {
                System.out.println("EXCEPCIÓN: TRY CATCH EN BORRAR DEVOLUCIÓN" + ex.getMessage());
            }
        }
        return registros;
    }
}
