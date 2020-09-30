package converter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame {

    JPanel panel = new JPanel();
    JTextField texto1, texto2;

    public Frame() {

        setSize(600, 400);

        panel.setLayout(new GridLayout(3, 2, 20, 20));
        JLabel etiqueta1 = new JLabel("Celsius Grades");
        JLabel etiqueta2 = new JLabel("Centigrades Grades");
        panel.add(etiqueta1);
        texto1 = new JTextField();
        texto1.addActionListener(new conversor());
        panel.add(texto1);
        panel.add(etiqueta2);
        texto2 = new JTextField();
        texto2.addActionListener(new inverso());
        panel.add(texto2);
        JButton boton_limpiar = new JButton("Clean");
        panel.add(boton_limpiar);
        boton_limpiar.addActionListener(new limpiar());
        add(panel);

    }

    class conversor implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            Double FH;
            String texto = texto1.getText();
            FH = Double.parseDouble(texto);
            FH += 273.15;
            texto = FH.toString();
            texto2.setText(texto);
        }
    }

    class inverso implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            Double CS;
            String texto = texto2.getText();
            CS = Double.parseDouble(texto);
            CS = CS - 273.15;
            texto = CS.toString();
            texto1.setText(texto);
        }
    }

    class limpiar implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            texto1.setText("");
            texto2.setText("");
        }

    }

}
