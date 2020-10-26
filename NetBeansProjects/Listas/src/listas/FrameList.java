package listas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.util.*;
import listas.Conectar_BD.*;
import java.sql.*;

public class FrameList extends JFrame {

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
    private ArrayList array_clientes = new ArrayList();

    public FrameList() {

        setTitle("JList Example");
        setSize(300, 200);

        panel_global.setLayout(new BorderLayout());

        GridLayout layout_botones = new GridLayout(3, 1, 10, 10);
        panel_centro.setLayout(layout_botones);
        panel_centro.add(boton_superior);
        panel_centro.add(boton_medio);
        panel_centro.add(boton_inferior);

        //CONECTAR LA BASE DE DATOS
        try {
            Conectar_BD conexion = new Conectar_BD();
            Connection con = conexion.OpenConnection();

            //CALL THE METHOD ALL REGISTERS() -> CREATE AN ARRAYLIST FOR THE CLIENTS ->
            //ITERATE THROUGH THE ARRAY (YOU NEED AN INSTANCE OF CLIENT) ->
            //GET THE ID FROM EACH CLIENT -> ADD IT TO THE LISTMODEL FROM THE FIRST JLIST
            listmodel_izquierda = new DefaultListModel();
//            Iterator iter = array_clientes.iterator();
//            client cliente_aux;
//            while (iter.hasNext()) {
//                cliente_aux = (client) iter.next();
//            }

            array_clientes.forEach((t) -> {
                listmodel_izquierda.addElement(t);
            });

            jlist_izquierda = new JList(listmodel_izquierda);
            panel_izquierda.add(new JScrollPane(jlist_izquierda));

            conexion.CloseConnection(con);

        } catch (Exception e) {
        }

//        jlist_derecha = new JList(listmodel_derecha);
//        panel_derecha.add(jlist_derecha);
        panel_global.add(panel_izquierda, BorderLayout.WEST);
        panel_global.add(panel_centro, BorderLayout.CENTER);
        panel_global.add(panel_derecha, BorderLayout.EAST);
        add(panel_global);

    }

}
