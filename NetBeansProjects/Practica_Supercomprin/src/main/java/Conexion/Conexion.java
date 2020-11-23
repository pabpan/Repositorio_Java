/**
 * @autor ---------> Pablo Suárez
 * @curso ---------> 2DAM
 * @descripción ---> SUPERCOMPRÍN
 */
package Conexion;

import java.sql.*;

public class Conexion {

    private static final String BD_URL = "jdbc:mysql://localhost:3306/supercomprin?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String BD_USUARIO = "root";
    private static final String BD_CONTRASENYA = "0123456789";

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(BD_URL, BD_USUARIO, BD_CONTRASENYA);
    }

    public static void Cerrar(ResultSet resultado) throws SQLException {
        resultado.close();
    }

    public static void Cerrar(Statement setencia) throws SQLException {
        setencia.close();
    }

    public static void Cerrar(Connection conexion) throws SQLException {
        conexion.close();
    }
}
