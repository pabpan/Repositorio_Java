/*
 * PRÁCTICA CRUD
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DISEÑO DE INTERFACES
 * 
 */
package Vistas;

import Dao.DAOCliente;
import Modelo.Cliente;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VistaClientes extends JFrame {

    private JPanel panel_principal, panel_botones_derecha, panel_datos_inferior; //PANEL PRINICPAL DEL PROYECTO
    private JLabel etiqueta_id, etiqueta_nombre, etiqueta_apellidos, etiqueta_direccion, etiqueta_localidad, etiqueta_telefono;
    private JTextField texto_id, texto_nombre, texto_apellidos, texto_direccion, texto_localidad, texto_telefono;
    private JButton boton_crear_usuario, boton_read_usuarios, boton_update_usuario, boton_delete_usuario; //BONES PANEL LATERAL
    private JTable tabla_datos = new JTable();
    private String columnas[] = {"Id", "Nombre", "Apellidos", "Dirección", "Localidad", "Teléfono"};
    private DefaultTableModel modelo_de_tabla = new DefaultTableModel(columnas, 0);
    private Dao.DAOCliente dao = new DAOCliente();
    private ArrayList<Object[]> datos = new ArrayList<>();

    public VistaClientes() {

        setTitle("ELSEUINFORMATIC - PRÁCTICA CRUD");
        setSize(800, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //INSTANCIAMOS LOS PANELES
        panel_principal = new JPanel(new BorderLayout());
        panel_botones_derecha = new JPanel(new GridLayout(4, 1, 10, 5));
        panel_datos_inferior = new JPanel(new GridLayout(2, 6, 10, 5));

        //INSTANCIAMOS LOS BOTONES, LAS ETIQEUTAS Y LOS CAMPOS DE TEXTO PARA EL PANEL INFERIOR
        boton_crear_usuario = new JButton("Nuevo usuario");
        boton_read_usuarios = new JButton("Mostrar usuarios");
        boton_update_usuario = new JButton("Actualizar usuario");
        boton_delete_usuario = new JButton("Borrar usuario");
        etiqueta_id = new JLabel("Id");
        etiqueta_nombre = new JLabel("Nombre");
        etiqueta_apellidos = new JLabel("Apellidos");
        etiqueta_direccion = new JLabel("Dirección");
        etiqueta_localidad = new JLabel("Localidad");
        etiqueta_telefono = new JLabel("Teléfono");

        texto_id = new JTextField("", 2);
        texto_nombre = new JTextField("");
        texto_apellidos = new JTextField("");
        texto_direccion = new JTextField("");
        texto_localidad = new JTextField("");
        texto_telefono = new JTextField("");

        panel_datos_inferior.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel_datos_inferior.add(etiqueta_id);
        panel_datos_inferior.add(etiqueta_nombre);
        panel_datos_inferior.add(etiqueta_apellidos);
        panel_datos_inferior.add(etiqueta_direccion);
        panel_datos_inferior.add(etiqueta_localidad);
        panel_datos_inferior.add(etiqueta_telefono);
        panel_datos_inferior.add(texto_id);
        panel_datos_inferior.add(texto_nombre);
        panel_datos_inferior.add(texto_apellidos);
        panel_datos_inferior.add(texto_direccion);
        panel_datos_inferior.add(texto_localidad);
        panel_datos_inferior.add(texto_telefono);

        panel_botones_derecha.add(boton_crear_usuario);
        boton_crear_usuario.addActionListener(new Agregar_usuario());
        panel_botones_derecha.add(boton_update_usuario);
        boton_update_usuario.addActionListener(new Update_usuario());
        panel_botones_derecha.add(boton_delete_usuario);
        boton_delete_usuario.addActionListener(new Borrar_usuario());
        panel_botones_derecha.add(boton_read_usuarios);
        boton_crear_usuario.addActionListener(new Cargar_usuarios());

        //LLAMAMOS AL MÉTODO PARA CARGAR LA TABLA
        cargar();

        tabla_datos.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                texto_id.setText(tabla_datos.getValueAt(tabla_datos.getSelectedRow(), 0).toString());
                texto_nombre.setText(tabla_datos.getValueAt(tabla_datos.getSelectedRow(), 1).toString());
                texto_apellidos.setText(tabla_datos.getValueAt(tabla_datos.getSelectedRow(), 2).toString());
                texto_direccion.setText(tabla_datos.getValueAt(tabla_datos.getSelectedRow(), 3).toString());
                texto_localidad.setText(tabla_datos.getValueAt(tabla_datos.getSelectedRow(), 4).toString());
                texto_telefono.setText(tabla_datos.getValueAt(tabla_datos.getSelectedRow(), 5).toString());

            }
        });

        //CONFIGURAMOS LAS COLUMNAS DEL MODELO DE TABLA
        Object[] etiquetas = new Object[6];
        etiquetas[0] = "Id";
        etiquetas[1] = "Nombre";
        etiquetas[2] = "Apellidos";
        etiquetas[3] = "Dirección";
        etiquetas[4] = "Localidad";
        etiquetas[5] = "Teléfono";
        modelo_de_tabla.setColumnIdentifiers(etiquetas);
        tabla_datos.setModel(modelo_de_tabla);
        tabla_datos.getColumnModel().getColumn(0).setPreferredWidth(20);
        tabla_datos.getColumnModel().getColumn(1).setPreferredWidth(60);
        tabla_datos.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabla_datos.getColumnModel().getColumn(3).setPreferredWidth(200);
        tabla_datos.getColumnModel().getColumn(4).setPreferredWidth(60);
        tabla_datos.getColumnModel().getColumn(5).setPreferredWidth(60);

        //Añadimos la tabla través de un JScolPane
        JScrollPane scroll = new JScrollPane(tabla_datos);

        panel_principal.add(scroll, BorderLayout.CENTER);
        panel_principal.add(panel_botones_derecha, BorderLayout.EAST);
        panel_principal.add(panel_datos_inferior, BorderLayout.SOUTH);

        add(panel_principal);

    }

    private void cargar() {
        this.datos = dao.consultar();
        modelo_de_tabla.setNumRows(0);
        for (Object[] dato : this.datos) {
            this.modelo_de_tabla.addRow(dato);
        }
    }

    private class Agregar_usuario implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            Cliente cliente = new Cliente(Integer.parseInt(texto_id.getText()), texto_nombre.getText(),
                    texto_apellidos.getText(), texto_direccion.getText(), texto_localidad.getText(), Integer.parseInt(texto_telefono.getText()));

            if (dao.insertar(cliente)) {
                JOptionPane.showMessageDialog(null, "Éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar");
            }
            cargar();
        }
    }

    private class Cargar_usuarios implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            cargar();
        }
    }

    private class Update_usuario implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {

            Cliente cliente = new Cliente(Integer.parseInt(texto_id.getText()), texto_nombre.getText(),
                    texto_apellidos.getText(), texto_direccion.getText(), texto_localidad.getText(), Integer.parseInt(texto_telefono.getText()));

            if (dao.actualizar(cliente)) {
                JOptionPane.showMessageDialog(null, "Éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar");
            }
            cargar();
        }
    }

    private class Borrar_usuario implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {

            Cliente cliente = new Cliente(Integer.parseInt(texto_id.getText()), texto_nombre.getText(),
                    texto_apellidos.getText(), texto_direccion.getText(), texto_localidad.getText(), Integer.parseInt(texto_telefono.getText()));

            if (dao.eliminar(cliente)) {
                JOptionPane.showMessageDialog(null, "Éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
            cargar();
        }
    }

}
