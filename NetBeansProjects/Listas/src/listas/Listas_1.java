package listas;


import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.text.Document;

public class Listas_1 extends JFrame {

    //CREAMOS LOS PANELES
    private JPanel panel_global = new JPanel();
    private JPanel panel_izquierda = new JPanel();
    private JPanel panel_centro = new JPanel();
    private JPanel panel_derecha = new JPanel();

    //CREAMOS LAS LISTAS
    private DefaultListModel listmodel_izquierda;
    private DefaultListModel listmodel_derecha;
    private JList jlist_izquierda;
    private JList jlist_derecha;

    //CREAMOS LOS BOTONES
    private JButton boton_superior = new JButton(">>>");
    private JButton boton_medio = new JButton("<<<");
    private JButton boton_inferior = new JButton("PRINT");

    public Listas_1() throws SQLException {

        setTitle("JList Example");
        setSize(300, 200);

        panel_global.setLayout(new BorderLayout());

        GridLayout layout_botones = new GridLayout(3, 1, 10, 10);
        panel_centro.setLayout(layout_botones);
        panel_centro.add(boton_superior);
        panel_centro.add(boton_medio);
        panel_centro.add(boton_inferior);

        panel_global.add(panel_izquierda, BorderLayout.WEST);
        panel_global.add(panel_centro, BorderLayout.CENTER);
        panel_global.add(panel_derecha, BorderLayout.EAST);

        //acceder a la base de datos , tambien tenemos que selecionas el driver
        String url = "jdbc:mysql://localhost:3306/di?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //puede ser que sea requerido lo siguiente
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "0123456789");
            Statement instruccion = (Statement) conexion.createStatement();
            String sql = "Select id from clients";
            ResultSet resultado = instruccion.executeQuery(sql);

            while (resultado.next()) {
                listmodel_izquierda.addElement(resultado.getString("id"));
            }
            
            jlist_izquierda = new JList(listmodel_izquierda);
            panel_izquierda.add(jlist_izquierda);
            
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }

        jlist_derecha = new JList(listmodel_derecha);
        panel_derecha.add(jlist_derecha);

        add(panel_global);

    }

}
