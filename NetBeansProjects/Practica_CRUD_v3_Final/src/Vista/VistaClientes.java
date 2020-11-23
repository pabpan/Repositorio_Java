/*
 * PRÁCTICA CRUD
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DISEÑO DE INTERFACES
 * 
 */
package Vista;

import Modelo.*;
import java.awt.*;
import Controlador.ControladorCRUD;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VistaClientes extends JFrame {

    public JPanel panel_principal, panel_botones_derecha, panel_datos_inferior; //PANEL PRINICPAL DEL PROYECTO
    public JLabel etiqueta_id, etiqueta_nombre, etiqueta_apellidos, etiqueta_direccion, etiqueta_localidad, etiqueta_telefono, etiqueta_ok;
    public JTextField texto_id, texto_nombre, texto_apellidos, texto_direccion, texto_localidad, texto_telefono, texto_buscar;
    public JButton boton_crear_usuario, boton_read_usuarios, boton_update_usuario, boton_delete_usuario, boton_ok; //BOTONES PANEL LATERAL
    public JTable tabla_datos = new JTable();
    public JTable tabla_datos_aux = new JTable();

    public String columnas[] = {"Id", "Nombre", "Apellidos", "Dirección", "Localidad", "Teléfono"};
    public DefaultTableModel modelo_de_tabla = new DefaultTableModel(columnas, 0);
    public Modelo.DAOCliente dao = new DAOCliente();
    public ArrayList<Object[]> datos = new ArrayList<>();

    public VistaClientes() {

        setTitle("ELSEUINFORMATIC - PRÁCTICA CRUD");
        setSize(800, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //INSTANCIAMOS LOS PANELES
        panel_principal = new JPanel(new BorderLayout());
        panel_botones_derecha = new JPanel(new GridLayout(7, 1, 10, 5));
        panel_datos_inferior = new JPanel(new GridLayout(2, 6, 10, 5));

        //INSTANCIAMOS LOS BOTONES, LAS ETIQEUTAS Y LOS CAMPOS DE TEXTO PARA EL PANEL INFERIOR
        boton_crear_usuario = new JButton("Nuevo usuario");
        boton_read_usuarios = new JButton("Mostrar usuarios");
        boton_update_usuario = new JButton("Actualizar usuario");
        boton_delete_usuario = new JButton("Borrar usuario");
        boton_ok = new JButton("Grabar cambios");
        etiqueta_id = new JLabel("Id");
        etiqueta_nombre = new JLabel("Nombre");
        etiqueta_apellidos = new JLabel("Apellidos");
        etiqueta_direccion = new JLabel("Dirección");
        etiqueta_localidad = new JLabel("Localidad");
        etiqueta_telefono = new JLabel("Teléfono");
        etiqueta_ok = new JLabel("Buscar apellido");

        texto_id = new JTextField("");
        texto_nombre = new JTextField("");
        texto_apellidos = new JTextField("");
        texto_direccion = new JTextField("");
        texto_localidad = new JTextField("");
        texto_telefono = new JTextField("");
        texto_buscar = new JTextField("");

        panel_datos_inferior.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel_datos_inferior.add(etiqueta_id);
        panel_datos_inferior.add(etiqueta_nombre);
        panel_datos_inferior.add(etiqueta_apellidos);
        panel_datos_inferior.add(etiqueta_direccion);
        panel_datos_inferior.add(etiqueta_localidad);
        panel_datos_inferior.add(etiqueta_telefono);
        panel_datos_inferior.add(texto_id);
        texto_id.setEnabled(false);
        panel_datos_inferior.add(texto_nombre);
        panel_datos_inferior.add(texto_apellidos);
        panel_datos_inferior.add(texto_direccion);
        panel_datos_inferior.add(texto_localidad);
        panel_datos_inferior.add(texto_telefono);

        panel_botones_derecha.add(boton_crear_usuario);
        panel_botones_derecha.add(boton_update_usuario);
        boton_ok.setEnabled(false);
        panel_botones_derecha.add(boton_ok);
        panel_botones_derecha.add(boton_delete_usuario);
        panel_botones_derecha.add(boton_read_usuarios);
        panel_botones_derecha.add(etiqueta_ok);
        panel_botones_derecha.add(texto_buscar);

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
}
