/**
 * @autor ---------> Pablo Suárez
 * @curso ---------> 2DAM
 * @descripción ---> SUPERCOMPRÍN
 */
package Datos;

import Conexion.Conexion;
import static Conexion.Conexion.*;
import Domain.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT * FROM productos";
    private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, puntos) Values(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=?, puntos=? where id_producto=?";
    private static final String SQL_DELETE = "DELETE FROM productos WHERE id_producto=?";

    public ProductoDAO() {
    }

    public ProductoDAO(Connection conexionTransaccional) {
        try {
            this.conexionTransaccional = conexionTransaccional;
        } catch (Exception e) {
        }
    }

    //MUESTRA LISTA DE WALLETS EXISTENTES
    public List<Producto> seleccionarProducto() throws SQLException {

        List<Producto> lista_productos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto_aux;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_producto = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                int precio = rs.getInt("precio");
                int puntos = rs.getInt("puntos");
                producto_aux = new Producto(id_producto, nombre, precio, puntos);
                lista_productos.add(producto_aux);
            }
        } finally {
            Cerrar(rs);
            Cerrar(stmt);
            if (this.conexionTransaccional == null) {
                Cerrar(conn);
            }
        }
        return lista_productos;
    }

    public int insertarProducto(Producto p) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, p.getNombre());
            stmt.setInt(2, p.getPrecio());
            stmt.setInt(3, p.getPuntos());
            registros = stmt.executeUpdate();
        } finally {
            try {
                Cerrar(stmt);
                if (this.conexionTransaccional == null) {
                    Cerrar(conn);
                }
            } catch (SQLException ex) {
                System.out.println("EXCEPCIÓN: TRY CATCH EN INSERTAR PRODUCTO" + ex.getMessage());
            }
        }
        return registros;
    }

    public int actualizarProducto(Producto p) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, p.getNombre());
            stmt.setInt(2, p.getPrecio());
            stmt.setInt(3, p.getPuntos());
            stmt.setInt(4, p.getId_producto());
            registros = stmt.executeUpdate();
        } finally {
            try {
                Cerrar(stmt);
                if (this.conexionTransaccional == null) {
                    Cerrar(conn);
                }
            } catch (SQLException ex) {
                System.out.println("EXCEPCIÓN: TRY CATCH EN ACTUALIZAR PRODUCTO" + ex.getMessage());
            }
        }
        return registros;
    }

    public int borrarProducto(Producto p) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, p.getId_producto());
            registros = stmt.executeUpdate();
        } finally {
            try {
                Cerrar(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.Cerrar(conn);
                }
            } catch (SQLException ex) {
                System.out.println("EXCEPCIÓN: TRY CATCH EN BORRAR PRODUCTO" + ex.getMessage());
            }
        }
        return registros;
    }
}
