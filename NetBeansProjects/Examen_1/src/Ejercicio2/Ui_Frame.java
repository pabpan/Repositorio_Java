package Ejercicio2;

import java.awt.*;
import javax.swing.*;

public class Ui_Frame extends JFrame {

    JPanel panel_principal, panel_preguntas, panel_pregunta_1, panel_pregunta_2, panel_pregunta_3, panel_pregunta_4, panel_pregunta_5;

    String[] pregunta_1 = {"A", "B", "C"};
    String[] pregunta_2 = {"A", "B", "C"};
    String[] pregunta_3 = {"A", "B", "C"};
    String[] pregunta_4 = {"A", "B", "C"};
    String[] pregunta_5 = {"A", "B", "C"};

    JButton boton_corregir = new JButton("Corregir");

    ButtonGroup grupo_botones_1, grupo_botones_2, grupo_botones_3, grupo_botones_4, grupo_botones_5;

    public Ui_Frame() {

        setTitle("Ejercicio2");
        setSize(500, 625);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel_principal = new JPanel(new BorderLayout());
        panel_preguntas = new JPanel(new GridLayout(5, 1));
        panel_pregunta_1 = new JPanel(new GridLayout(4, 1));
        panel_pregunta_2 = new JPanel(new GridLayout(4, 1));
        panel_pregunta_3 = new JPanel(new GridLayout(4, 1));
        panel_pregunta_4 = new JPanel(new GridLayout(4, 1));
        panel_pregunta_5 = new JPanel(new GridLayout(4, 1));

        grupo_botones_1 = new ButtonGroup();
        grupo_botones_2 = new ButtonGroup();
        grupo_botones_3 = new ButtonGroup();
        grupo_botones_4 = new ButtonGroup();
        grupo_botones_5 = new ButtonGroup();

        for (int i = 0; i < pregunta_1.length; i++) {
            JRadioButton aux = new JRadioButton(pregunta_1[i]);
            grupo_botones_1.add(aux);
            panel_pregunta_1.add(aux);
        }

        for (int i = 0; i < pregunta_2.length; i++) {
            JRadioButton aux = new JRadioButton(pregunta_2[i]);
            grupo_botones_2.add(aux);
            panel_pregunta_2.add(aux);
        }
        for (int i = 0; i < pregunta_3.length; i++) {
            JRadioButton aux = new JRadioButton(pregunta_3[i]);
            grupo_botones_3.add(aux);
            panel_pregunta_3.add(aux);
        }
        for (int i = 0; i < pregunta_4.length; i++) {
            JRadioButton aux = new JRadioButton(pregunta_4[i]);
            grupo_botones_4.add(aux);
            panel_pregunta_4.add(aux);
        }
        for (int i = 0; i < pregunta_5.length; i++) {
            JRadioButton aux = new JRadioButton(pregunta_5[i]);
            grupo_botones_5.add(aux);
            panel_pregunta_5.add(aux);
        }
        add(panel_principal);

        panel_pregunta_1.setBorder(BorderFactory.createTitledBorder("Pregunta 1"));
        panel_pregunta_2.setBorder(BorderFactory.createTitledBorder("Pregunta 2"));
        panel_pregunta_3.setBorder(BorderFactory.createTitledBorder("Pregunta 3"));
        panel_pregunta_4.setBorder(BorderFactory.createTitledBorder("Pregunta 4"));
        panel_pregunta_5.setBorder(BorderFactory.createTitledBorder("Pregunta 5"));

        panel_preguntas.add(panel_pregunta_1);
        panel_preguntas.add(panel_pregunta_2);
        panel_preguntas.add(panel_pregunta_3);
        panel_preguntas.add(panel_pregunta_4);
        panel_preguntas.add(panel_pregunta_5);

        panel_principal.add(panel_preguntas, BorderLayout.NORTH);

        panel_principal.add(boton_corregir, BorderLayout.SOUTH);

    }
}
