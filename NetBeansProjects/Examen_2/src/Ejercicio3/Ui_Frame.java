/*
 * EXÁMEN
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DESARROLLO DE INTERFACES
 * 
 */
package Ejercicio3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ui_Frame extends JFrame {

    JPanel panel_global, panel_radiobutons, panel_imagen, panel_boton;
    JRadioButton btn_windows, btn_linux, btn_mac;
    JButton boton_ok = new JButton("OK");
    ButtonGroup grupo_botones = new ButtonGroup();
    JLabel label;
    ImageIcon[] vector_imagenes;
    Icon img1, img2, img3;

    public Ui_Frame() {

        setTitle("Swing JRadioButton Demo");
        setSize(800, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel_global = new JPanel(new BorderLayout());
        panel_radiobutons = new JPanel(new GridLayout(1, 3));
        panel_imagen = new JPanel();

        btn_windows = new JRadioButton("Windows");
        btn_linux = new JRadioButton("Linux");
        btn_mac = new JRadioButton("Mac");

        grupo_botones.add(btn_windows);
        grupo_botones.add(btn_linux);
        grupo_botones.add(btn_mac);

        btn_windows.addItemListener(new Manejador_radiobuttons());
        btn_linux.addItemListener(new Manejador_radiobuttons());
        btn_mac.addItemListener(new Manejador_radiobuttons());

        vector_imagenes = new ImageIcon[3];
        vector_imagenes[0] = new ImageIcon(getClass().getResource("imagesExamB/windows.jpg"));
        vector_imagenes[1] = new ImageIcon(getClass().getResource("imagesExamB/linux.jpg"));
        vector_imagenes[2] = new ImageIcon(getClass().getResource("imagesExamB/mac.jpg"));

        label = new JLabel();
        label.setIcon(vector_imagenes[1]);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.CENTER);

        panel_radiobutons.add(btn_windows);
        panel_radiobutons.add(btn_linux);
        panel_radiobutons.add(btn_mac);

        panel_imagen.add(label, BorderLayout.CENTER);
        panel_global.add(panel_radiobutons, BorderLayout.NORTH);
        panel_global.add(panel_imagen, BorderLayout.CENTER);

        panel_global.add(boton_ok, BorderLayout.SOUTH);
        add(panel_global);

        boton_ok.addActionListener(new Manejador_Mensajes());
    }

    public class Manejador_radiobuttons implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent arg0) {
            if (btn_windows.isSelected()) {
                label.setIcon(vector_imagenes[0]);
            }
            if (btn_linux.isSelected()) {
                label.setIcon(vector_imagenes[1]);
            }
            if (btn_mac.isSelected()) {
                label.setIcon(vector_imagenes[2]);
            }
        }
    }

    public class Manejador_Mensajes implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (btn_windows.isSelected()) {
                JOptionPane.showMessageDialog(null, "You select: Windows");
            }
            if (btn_linux.isSelected()) {
                JOptionPane.showMessageDialog(null, "You select: Linux");
            }
            if (btn_mac.isSelected()) {
                JOptionPane.showMessageDialog(null, "You select: Mac");
            }
        }
    }
}
