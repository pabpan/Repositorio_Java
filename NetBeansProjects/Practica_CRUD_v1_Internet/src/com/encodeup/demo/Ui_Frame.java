/*
 * PRÁCTICA CRUD
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DISEÑO DE INTERFACES
 * 
 */
package com.encodeup.demo;

import com.connection.Conexion;
import com.encodeup.controller.ControllerCliente;
import com.encodeup.model.Cliente;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Ui_Frame extends JFrame {

    private ImageIcon usuario, usuario_redmiensionado; //ICONO USUARIO
    private JPanel panel_principal, panel_botones_derecha; //PANEL PRINICPAL DEL PROYECTO
    private JButton boton_crear_usuario, boton_read_usuarios, boton_update_usuario, boton_delete_usuario; //BONES PANEL LATERAL
    private JTable tabla = new JTable();
    private ControllerCliente controlador = new ControllerCliente();

    public Ui_Frame() throws SQLException {

        //INSTANCIAMOS LOS PANELES
        panel_principal = new JPanel(new BorderLayout());
        panel_botones_derecha = new JPanel(new GridLayout(3, 1, 20, 30));

        //INSTANCIAMOS LOS BOTONES PARA EL PANEL LATERAL
        boton_crear_usuario = new JButton("Nuevo usuario");
        boton_read_usuarios = new JButton("Mostrar usuarios");
        boton_update_usuario = new JButton("Actualizar usuario");
        boton_delete_usuario = new JButton("Borrar usuario");
        panel_botones_derecha.add(boton_crear_usuario);
        panel_botones_derecha.add(boton_read_usuarios);
        panel_botones_derecha.add(boton_update_usuario);
        panel_botones_derecha.add(boton_delete_usuario);

        boton_crear_usuario.addActionListener(new Listener_Crear_Usuario());
        boton_read_usuarios.addActionListener(new Listener_Mostrar_Usuarios());

        //CREAMOS LA TABLA QUE METEREMOS EN EL CENTRO
        JTable tabla = new JTable();

        //CREAMOS EL MODELO DE TABLA
        DefaultTableModel modelo_de_tabla = new DefaultTableModel();

        //CONFIGURAMOS LAS COLUMNAS DEL MODELO DE TABLA
        Object[] etiquetas = new Object[6];
        etiquetas[0] = "Id";
        etiquetas[1] = "Nombre";
        etiquetas[2] = "Apellidos";
        etiquetas[3] = "Dirección";
        etiquetas[4] = "Localidad";
        etiquetas[5] = "Teléfono";
        modelo_de_tabla.setColumnIdentifiers(etiquetas);
     
        //Le aplicamos a la tabla el modelo de tabla
        tabla.setModel(modelo_de_tabla);

        //Añadimos la tabla través de un JScolPane
        JScrollPane scroll = new JScrollPane(tabla);

        setTitle("ELSEUINFORMATIC - PRÁCTICA CRUD");
        setSize(800, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //añadimos el JScrollPane
        panel_principal.add(scroll, BorderLayout.CENTER);
        panel_principal.add(panel_botones_derecha, BorderLayout.EAST);
        add(panel_principal);

    }

    class Listener_Mostrar_Usuarios implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            controlador.verClientes();
        }
    }

    class Listener_Crear_Usuario implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {

            JPanel panel_alta_usuario = new JPanel();
            setSize(400, 400);
            add(panel_alta_usuario);
        }

    }

}

//
//        int numero_fila = 0;
//        for (Cliente cliente : lista_clientes) {
//            //Se crea y se completa la fila para el modelo de tabla.
//            Object[] datos_fila = new Object[modelo_de_tabla.getColumnCount()];
//            datos_fila[0] = lista_clientes.get(0).getId();
//            datos_fila[1] = lista_clientes.get(2).getNombre();
//            datos_fila[2] = lista_clientes.get(3).getApellidos();
//            datos_fila[3] = lista_clientes.get(4).getDireccion();
//            datos_fila[4] = lista_clientes.get(5).getLocalidad();
//            datos_fila[5] = lista_clientes.get(6).getTelefono();
//
//            modelo_de_tabla.addRow(datos_fila);
//            numero_fila++;
//        }
//

