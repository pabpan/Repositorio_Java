package listas;

import java.awt.*;
import javax.swing.*;

public class Listas_1 extends JFrame {

    private JPanel panel_global = new JPanel();
    private JPanel panel_izquierda = new JPanel();
    private JPanel panel_centro = new JPanel();
    private JPanel panel_derecha = new JPanel();
    private JList jlist_izquierda = new JList();
    private final String nombre_colores[] = {"Red", "Blue", "Green", "Pink", "Black", "Cyan"};
    private JList jlist_derecha = new JList();
    private final String nombre_colores_2[] = {"Red", "Blue", "Green", "Pink", "Black", "Cyan"};
    private JButton boton_superior = new JButton(">>>");
    private JButton boton_medio = new JButton("<<<");
    private JButton boton_inferior = new JButton("PRINT");

    public Listas_1() {

        setTitle("JList Example");
        setSize(300, 200);

        panel_global.setLayout(new BorderLayout());

        jlist_izquierda = new JList(nombre_colores);
        panel_izquierda.add(jlist_izquierda);

        GridLayout layout_botones = new GridLayout(3, 1, 10, 10);
        panel_centro.setLayout(layout_botones);
        panel_centro.add(boton_superior);
        panel_centro.add(boton_medio);
        panel_centro.add(boton_inferior);

        jlist_derecha = new JList(nombre_colores_2);
        panel_derecha.add(jlist_derecha);

        panel_global.add(panel_izquierda, BorderLayout.WEST);
        panel_global.add(panel_centro, BorderLayout.CENTER);
        panel_global.add(panel_derecha, BorderLayout.EAST);

        add(panel_global);

    }

}
