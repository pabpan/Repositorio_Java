/*
 * EXÁMEN
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DESARROLLO DE INTERFACES
 * 
 */
package Ejercicio2;

import java.awt.*;
import javax.swing.*;

public class Ui_Frame extends JFrame {

    //DECALARACIÓN DE VARIABLES
    JPanel panel_global, panel_botones, panel_botones_2, panel_checkbox, panel_radiobuton;
    String[] personajes = {"Mortadelo", "Filemon", "Carpanta", " Rompetechos", "Pepe Gotera", "Otilio"};

    public Ui_Frame() {

        setTitle("Tutorial de Java, Swing");
        setSize(800, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel_global = new JPanel(new GridLayout(4, 1));
        panel_botones = new JPanel(new GridLayout(1, 7));
        panel_checkbox = new JPanel(new GridLayout(1, 7));
        panel_botones_2 = new JPanel(new GridLayout(1, 7));
        panel_radiobuton = new JPanel(new GridLayout(1, 7));

        for (int i = 0; i < personajes.length; i++) {
            JButton aux = new JButton(personajes[i]);
            JToggleButton aux2 = new JToggleButton(personajes[i]);
            JCheckBox aux1 = new JCheckBox(personajes[i]);
            JRadioButton aux3 = new JRadioButton(personajes[i]);
            panel_botones.add(aux);
            panel_checkbox.add(aux1);
            panel_botones_2.add(aux2);
            panel_radiobuton.add(aux3);
        }

        panel_botones.setBorder(BorderFactory.createTitledBorder("JButton"));
        panel_checkbox.setBorder(BorderFactory.createTitledBorder("JCheckBox"));
        panel_botones_2.setBorder(BorderFactory.createTitledBorder("JToggleButton"));
        panel_radiobuton.setBorder(BorderFactory.createTitledBorder("JJRadioButton"));

        panel_global.add(panel_botones);
        panel_global.add(panel_botones_2);
        panel_global.add(panel_checkbox);
        panel_global.add(panel_radiobuton);
        add(panel_global);

    }
}
