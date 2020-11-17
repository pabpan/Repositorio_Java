/*
 * PRÁCTICA CRUD
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DISEÑO DE INTERFACES
 * 
 */
package Vista;

//import Controlador.Controlador;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Ui_Frame extends JFrame {

    public JPanel panel_principal, panel_botones_derecha; //PANEL PRINICPAL DEL PROYECTO
    public JButton boton_crear_usuario, boton_read_usuarios, boton_update_usuario, boton_delete_usuario; //BONES PANEL LATERAL
    public JTextField txt_id, txt_nombre, txt_apellidos, txt_direccion, txt_localidad, txt_telefono;
    public JTable tabla = new JTable();
    //public Controlador controlador = new Controlador();

    public Ui_Frame() {

        //INSTANCIAMOS LOS PANELES
        panel_principal = new JPanel(new BorderLayout());
        panel_botones_derecha = new JPanel(new GridLayout(3, 1, 20, 30));

        //INSTANCIAMOS LOS BOTONES PARA EL PANEL LATERAL
        boton_crear_usuario = new JButton("Nuevo usuario");
        boton_read_usuarios = new JButton("Mostrar usuarios");
        boton_update_usuario = new JButton("Actualizar usuario");
        boton_delete_usuario = new JButton("Borrar usuario");
        txt_id = new JTextField();
        txt_nombre = new JTextField();
        txt_apellidos = new JTextField();
        txt_direccion = new JTextField();
        txt_localidad = new JTextField();
        txt_telefono = new JTextField();

        panel_botones_derecha.add(txt_id);
        panel_botones_derecha.add(txt_nombre);
        panel_botones_derecha.add(txt_apellidos);
        panel_botones_derecha.add(txt_direccion);
        panel_botones_derecha.add(txt_localidad);
        panel_botones_derecha.add(txt_telefono);

        panel_botones_derecha.add(boton_crear_usuario);
        panel_botones_derecha.add(boton_read_usuarios);
        panel_botones_derecha.add(boton_update_usuario);
        panel_botones_derecha.add(boton_delete_usuario);

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
}
