package jtable_2;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTable_2 extends JFrame {

    public static void main(String[] args) throws SQLException {

        JTable_2 tabla_nueva = new JTable_2();
        tabla_nueva.setVisible(true);
    }

    public JTable_2() throws SQLException {

        setTitle("TABLA CON CONEXIÓN");
        setSize(800, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Creamos la tabla
        JTable tabla = new JTable();

        //Instanciamos DefaultDataModel
        DefaultTableModel modelo_de_tabla = new DefaultTableModel();

        //Configuramos las columnas del DefaultTableModel
        Object[] etiquetas = new Object[2];
        etiquetas[0] = "Id";
        etiquetas[1] = "Notes";
        modelo_de_tabla.setColumnIdentifiers(etiquetas);

        //Añadimos el contenido desde la tabla MySQL
        //Conectamos con la base de datos
        String UrlOdbc = "jdbc:mysql://localhost:3306/di?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Connection con = (java.sql.DriverManager.getConnection(UrlOdbc, "root", "0123456789"));
        //Preparamos la consulta
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from clients");

        //Revisamos el resultado, mientras hay registros para leer agrega cada registro al DefaultDataModel
        int numero_fila = 0;
        while (rs.next()) {
            //Se crea y se completa la fila para el modelo de tabla.
            Object[] datos_fila = new Object[modelo_de_tabla.getColumnCount()];
            datos_fila[0] = rs.getObject(1);
            datos_fila[1] = rs.getObject(2);
            modelo_de_tabla.addRow(datos_fila);
            numero_fila++;
        }
        //Cerramos las conexión a la base de datos
        rs.close();
        statement.close();
        con.close();
        
        //Le aplicamos a la tabla el modelo de tabla
        tabla.setModel(modelo_de_tabla);

        //Añadimos la a través de un JScolPane
        JScrollPane scroll = new JScrollPane(tabla);

        //añadimos el JScrollPane
        add(scroll);
    }

}
