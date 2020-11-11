package jtable_1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTable_1 extends JFrame {

    public static void main(String[] args) {

        JTable_1 tabla_nueva = new JTable_1();
        tabla_nueva.setVisible(true);
    }

    public JTable_1() {

        setTitle("TABLA SIN CONEXIÓN");
        setSize(800, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Cabeceras para las columnas
        String[] headers = new String[]{"Name", "Address", "Telephone", "Car"};

        //Datos para las tablas
        Object[][] data = new Object[][]{
            {"Pablo Suárez", "Valencia, Valencia", new Long(65115112), true},
            {"Adrián Piquero", "Valencia, Valencia", new Long(68945715), false},
            {"Kevin Rosales", "Valencia, Valencia", new Long(69857458), true}
        };

        JTable tabla = new JTable();
        tabla.setModel(new DefaultTableModel(data, headers){

            Class[] tipoColumn = {String.class, String.class, Long.class, Boolean.class};

            //Override the getColumnClass method
            @Override
            public Class getColumnClass (int indColumn) 
            {
            return tipoColumn[indColumn];
        }
            });
        
        //La tabla necesita un Scroll, como el JList
        JScrollPane scroll = new JScrollPane(tabla);
        
        add(scroll);
    }

}
