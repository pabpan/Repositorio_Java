package listas;

import java.awt.*;
import javax.swing.*;

public class Listas_1 extends JFrame {

    private JPanel panel_global = new JPanel();
    private JPanel panel_izquierda = new JPanel();
    private JPanel panel_centro = new JPanel();
    private JPanel panel_derecha = new JPanel();
    private JTextField jtextfield_izquierda = new JTextField();
    private JTextField jtextfield_derecha = new JTextField();
    private JButton boton_superior = new JButton(">>>");
    private JButton boton_medio = new JButton("<<<");
    private JButton boton_inferior = new JButton("PRINT");

    public Listas_1() {

        setTitle("JList Example");
        setSize(800, 600);
        add(panel_global);

        panel_izquierda.setLayout(new BorderLayout());
        panel_izquierda.add(jtextfield_izquierda);

        GridLayout layout_botones = new GridLayout(3, 1, 10, 10);
        panel_centro.setLayout(layout_botones);
        panel_centro.add(boton_superior);
        panel_centro.add(boton_medio);
        panel_centro.add(boton_inferior);

        panel_derecha.setLayout(new BorderLayout());
        panel_derecha.add(jtextfield_derecha);

        panel_global.add(panel_izquierda, BorderLayout.WEST);
        panel_global.add(panel_centro, BorderLayout.CENTER);
        panel_global.add(panel_derecha, BorderLayout.EAST);

        
    }

}
