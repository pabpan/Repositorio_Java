package Interfaz;

import Conexion.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;

public class Frame_JList_MySQL extends JFrame {

    //CREAMOS LOS PANELES
    private JPanel panel_global = new JPanel();
    private JPanel panel_izquierda = new JPanel();
    private JPanel panel_centro = new JPanel();
    private JPanel panel_derecha = new JPanel();

    //CREAMOS LAS LISTAS
    private JList jlist_izquierda;
    private JList jlist_derecha;
    private DefaultListModel listmodel_izquierda = new DefaultListModel();
    private DefaultListModel listmodel_derecha = new DefaultListModel();

    //CREAMOS LOS BOTONES
    private JButton boton_superior = new JButton(">>>");
    private JButton boton_medio = new JButton("<<<");
    private JButton boton_inferior = new JButton("PRINT");

    public Frame_JList_MySQL() {

        setTitle("JList Example");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel_global.setLayout(new BorderLayout());

        GridLayout layout_botones = new GridLayout(3, 1, 10, 10);
        panel_centro.setLayout(layout_botones);
        panel_centro.add(boton_superior);
        panel_centro.add(boton_medio);
        panel_centro.add(boton_inferior);

        jlist_izquierda = new JList(listmodel_izquierda);
        jlist_derecha = new JList(listmodel_derecha);

        jlist_izquierda.setFixedCellWidth(100);
        jlist_derecha.setFixedCellWidth(100);

        panel_izquierda.add(new JScrollPane(jlist_izquierda));
        panel_derecha.add(new JScrollPane(jlist_derecha));

        panel_global.add(panel_izquierda, BorderLayout.WEST);
        panel_global.add(panel_centro, BorderLayout.CENTER);
        panel_global.add(panel_derecha, BorderLayout.EAST);
        add(panel_global);

        //CONECTAR LA BASE DE DATOS
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.Abrir_Conexion();
            Consultas consulta = new Consultas();

            ArrayList array_clientes = consulta.Buscar_Todos(con);

            for (int i = 0; i < array_clientes.size(); i++) {
                listmodel_izquierda.addElement(array_clientes.get(i));
            }
            conexion.Cerrar_Conexion(con);
        } catch (Exception e) {
        }

        //BOTÓN PARA PASAR DE IZQUIERDA A DERECHA
        boton_superior.addActionListener((ActionEvent e) -> {
            int index = jlist_izquierda.getSelectedIndex();
            if (index >= 0) {
                listmodel_derecha.addElement(jlist_izquierda.getSelectedValue());
                listmodel_izquierda.removeElement(jlist_izquierda.getSelectedValue());
            }
        });

        //BOTÓN PARA PASAR DE DERECHA A IZQUIERDA
        boton_medio.addActionListener((ActionEvent e) -> {
            int index = jlist_derecha.getSelectedIndex();
            if (index >= 0) {
                listmodel_izquierda.addElement(jlist_derecha.getSelectedValue());
                listmodel_derecha.removeElement(jlist_derecha.getSelectedValue());
            }
        });

        //BOTÓN PARA IMPRIMIR
        boton_inferior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                try {
                    JTextArea text = new JTextArea();
                    text.append("Lista de clientes seleccionados para imprimir: \n\n");
                    Cliente cliente_aux;
                    Object[] array_aux = listmodel_derecha.toArray();

                    for (int i = 0; i < array_aux.length; i++) {
                        cliente_aux = (Cliente) array_aux[i];
                        text.append("ID: " + cliente_aux.getId() + "\n");                      
                        text.append("NOTAS: " + cliente_aux.getNotes() + "\n\n");                      
                    }
                    
                    boolean ok = text.print();
                    if (ok) {
                        System.out.println("¡¡TODO CORRECTO!!");
                    } else {
                        System.out.println("¡¡OPERACIÓN CANCELADA!!");
                    }
                } catch (PrinterException e) {
                }
            }
        }
        );
    }
}
