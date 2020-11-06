/*
 * EXÁMEN
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DESARROLLO DE INTERFACES
 * 
 */
//1. Create a window with a button “Introduce your name” and texts for 
//the name and surnames. There is also a JList and a JCombo. When the 
//user presses the button the full name is added to the JList. 
//The JList is multiselection. The selected elements will be added to the JCombo with another button.
package Ejercicio1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ui_Frame extends JFrame {

    JButton boton_nombre = new JButton("Introduce your name");
    JButton boton_anyadir = new JButton("Añadir");
    JLabel label_nombre, label_apellidos;
    JTextField texto_nombre, texto_apellidos;
    JList lista_nombre;
    JComboBox caja_nombre = new JComboBox();
    DefaultListModel listModel = new DefaultListModel();
    JPanel panel_global;

    public Ui_Frame() {

        setTitle("Swing JRadioButton Demo");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel_global = new JPanel();
        label_nombre = new JLabel();
        texto_nombre = new JTextField(10);
        label_apellidos = new JLabel();
        texto_apellidos = new JTextField(10);
        lista_nombre = new JList(listModel);
        lista_nombre.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        label_nombre.setText("Nombre");
        label_apellidos.setText("Apellidos");

        boton_nombre.addActionListener(new Manejar_lista());
        boton_anyadir.addActionListener(new Manejar_ComboBox());

        panel_global.add(label_nombre);
        panel_global.add(texto_nombre);
        panel_global.add(label_apellidos);
        panel_global.add(texto_apellidos);
        panel_global.add(boton_nombre);
        panel_global.add(lista_nombre);
        panel_global.add(boton_anyadir);
        panel_global.add(caja_nombre);

        add(panel_global);
    }

    public class Manejar_lista implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            listModel.addElement(texto_nombre.getText() + " " + texto_apellidos.getText());
            texto_nombre.setText("");
            texto_apellidos.setText("");
        }
    }

    public class Manejar_ComboBox implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int[] indices = lista_nombre.getSelectedIndices();
            for (int i = 0; i < indices.length; i++) {
                caja_nombre.addItem(listModel.get(indices[i]));
            }
        }
    }
}
