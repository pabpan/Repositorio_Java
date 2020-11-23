/**
 * @autor ---------> Pablo Suárez
 * @curso ---------> 2DAM
 * @descripción ---> SUPERCOMPRÍN
 */
package Datos;

import Conexion.Conexion;
import static Conexion.Conexion.*;
import Domain.Wallet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WalletDAO {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT * FROM ewallet";
    private static final String SQL_INSERT = "INSERT INTO ewallet (nombre, apellidos, DNI, fecha_nacimiento, email, saldo_puntos, saldo_euros) Values(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE ewallet SET nombre=?, apellidos=?, DNI=?, fecha_nacimiento=?, email=?, saldo_puntos=?, saldo_euros=? where id_wallet=?";
    private static final String SQL_DELETE = "DELETE FROM ewallet WHERE id_wallet=?";

    public WalletDAO() {
    }

    public WalletDAO(Connection conexionTransaccional) {
        try {
            this.conexionTransaccional = conexionTransaccional;
        } catch (Exception e) {
        }
    }

    //MUESTRA LISTA DE WALLETS EXISTENTES
    public List<Wallet> seleccionarWallet() throws SQLException {

        List<Wallet> lista_wallets = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Wallet wallet_aux;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_wallet = rs.getInt("id_wallet");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String DNI = rs.getString("DNI");
                Date fecha_nacimiento = rs.getDate("fecha_nacimiento");
                String email = rs.getString("email");
                int saldo_puntos = rs.getInt("saldo_puntos");
                int saldo_euros = rs.getInt("saldo_euros");
                wallet_aux = new Wallet(id_wallet, nombre, apellidos, DNI, fecha_nacimiento, email, saldo_puntos, saldo_euros);
                lista_wallets.add(wallet_aux);
            }
        } finally {
            Cerrar(rs);
            Cerrar(stmt);
            if (this.conexionTransaccional == null) {
                Cerrar(conn);
            }
        }
        return lista_wallets;
    }

    public int insertarWallet(Wallet w) throws SQLException, SQLIntegrityConstraintViolationException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, w.getNombre());
            stmt.setString(2, w.getApellidos());
            stmt.setString(3, w.getDNI());
            stmt.setDate(4, w.getFecha_nacimiento());
            stmt.setString(5, w.getEmail());
            stmt.setInt(6, w.getSaldo_puntos());
            stmt.setInt(7, w.getSaldo_euros());

            registros = stmt.executeUpdate();
        } finally {
            try {
                Cerrar(stmt);
                if (this.conexionTransaccional == null) {
                    Cerrar(conn);
                }
            } catch (SQLException ex) {
                System.out.println("EXCEPCIÓN: TRY CATCH EN INSERTAR WALLET" + ex.getMessage());
            }
        }
        return registros;
    }

    public int actualizarWallet(Wallet w) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, w.getNombre());
            stmt.setString(2, w.getApellidos());
            stmt.setString(3, w.getDNI());
            stmt.setDate(4, w.getFecha_nacimiento());
            stmt.setString(5, w.getEmail());
            stmt.setInt(6, w.getSaldo_puntos());
            stmt.setInt(7, w.getSaldo_euros());
            stmt.setInt(8, w.getId_wallet());

            registros = stmt.executeUpdate();
        } finally {
            try {
                Cerrar(stmt);
                if (this.conexionTransaccional == null) {
                    Cerrar(conn);
                }
            } catch (SQLException ex) {
                System.out.println("EXCEPCIÓN: TRY CATCH EN ACTUALIZAR WALLET" + ex.getMessage());
            }
        }
        return registros;
    }

    public int borrarWallet(Wallet w) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, w.getId_wallet());
            registros = stmt.executeUpdate();
        } finally {
            try {
                Cerrar(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.Cerrar(conn);
                }
            } catch (SQLException ex) {
                System.out.println("EXCEPCIÓN: TRY CATCH EN BORRAR WALLET" + ex.getMessage());
            }
        }
        return registros;
    }
}
