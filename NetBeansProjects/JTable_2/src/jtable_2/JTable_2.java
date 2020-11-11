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

        //CONFIGURAMOS LAS COLUMNAS DEL DEFAULTTABLEMODEL
        Object[] etiquetas = new Object[2];
        etiquetas[0] = "Id";
        etiquetas[1] = "Notes";
        modelo_de_tabla.setColumnIdentifiers(etiquetas);

        //AÑADIMOS EL CONTENIDO DESDE LA TABLE MYSQL
        //CONECTAMOS CON LA BASE DE DATOS
        String UrlOdbc = "jdbc:mysql://localhost:3306/di?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Connection with = (java.sql.DriverManager.getConnection(UrlOdbc, "root", "0123456789"));

        //Le aplicamos a la tabla el modelo de tabla
        tabla.setModel(modelo_de_tabla);

        //Añadimos la a través de un JScolPane
        JScrollPane scroll = new JScrollPane(tabla);

        //añadimos el JScrollPane
        add(scroll);
    }

}
