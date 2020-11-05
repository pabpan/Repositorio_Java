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
    String[] marcas = {"Windows", "Linux", "Mac"};
    JButton boton_ok = new JButton("OK");
    ButtonGroup grupo_botones = new ButtonGroup();
    JLabel label;
    Icon img1, img2, img3;

    public Ui_Frame() {

        setTitle("Swing JRadioButton Demo");
        setSize(800, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel_global = new JPanel(new BorderLayout());
        panel_radiobutons = new JPanel(new GridLayout(1, 3));
        panel_imagen = new JPanel();

        for (int i = 0; i < marcas.length; i++) {
            JRadioButton aux = new JRadioButton(marcas[i]);
            grupo_botones.add(aux);
            panel_radiobutons.add(aux);
        }

        img1 = new ImageIcon(getClass().getResource("imagesExamB/windows.jpg"));
        img2 = new ImageIcon(getClass().getResource("imagesExamB/linux.jpg"));
        img3 = new ImageIcon(getClass().getResource("imagesExamB/mac.jpg"));

        label = new JLabel();
        label.setIcon(img1);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.CENTER);

        for (int i = 0; i < panel_radiobutons.getComponentCount(); i++) {
            //JRadioButton aux = (JRadioButton) panel_radiobutons.getComponent(i);
            if (panel_radiobutons.getComponent(i).equals("windows")) {
                label.setIcon(img1);
            }
            if (panel_radiobutons.getComponent(i).equals("linux")) {
                label.setIcon(img2);
            }
            if (panel_radiobutons.getComponent(i).equals("mac")) {
                label.setIcon(img3);
            }
        }

        panel_imagen.add(label, BorderLayout.CENTER);
        panel_global.add(panel_radiobutons, BorderLayout.NORTH);
        panel_global.add(panel_imagen, BorderLayout.CENTER);
        panel_global.add(boton_ok, BorderLayout.SOUTH);
        add(panel_global);

        boton_ok.addActionListener(new Mensaje_emergente());

    }

    public class Mensaje_emergente implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {

            for (int i = 0; i < panel_radiobutons.getComponentCount(); i++) {
                JRadioButton aux = (JRadioButton) panel_radiobutons.getComponent(i);
                if (aux.getComponentCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Windows", "Sistema seleccionado", JOptionPane.PLAIN_MESSAGE);
                }
                if (aux.getComponentCount() == 1) {
                    JOptionPane.showMessageDialog(null, "Linux", "Sistema seleccionado", JOptionPane.PLAIN_MESSAGE);
                }
                if (aux.getComponentCount() == 2) {
                    JOptionPane.showMessageDialog(null, "Mac", "Sistema seleccionado", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
    }
}
