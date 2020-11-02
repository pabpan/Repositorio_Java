package Ejercicio3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ui_Frame extends JFrame {

    JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
    JLabel luz = new JLabel("Luz");
    JLabel agua = new JLabel("Agua");
    JLabel gas = new JLabel("Gas");
    JButton boton_calcular = new JButton("Calcular");
    JLabel resultado = new JLabel("0");
    JTextField area_luz = new JTextField("0");
    JTextField area_agua = new JTextField("0");
    JTextField area_gas = new JTextField("0");

    public Ui_Frame() {

        setTitle("Gastos");
        setBounds(450, 500, 400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel.add(luz);
        panel.add(area_luz);
        panel.add(agua);
        panel.add(area_agua);
        panel.add(gas);
        panel.add(area_gas);
        panel.add(boton_calcular);
        panel.add(resultado);

        boton_calcular.addActionListener(new Manejar_Resultado());

        add(panel);

    }

    public class Manejar_Resultado implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {

            int resultado_suma = 0;
            resultado_suma = Integer.parseInt(area_luz.getText()) + Integer.parseInt(area_agua.getText()) + Integer.parseInt(area_gas.getText());
            String convertido = Integer.toString(resultado_suma);
            resultado.setText(convertido);
            if (resultado.getText().equals("0")) {
                JOptionPane.showMessageDialog(null, "Introduce los números para sumar", "ERROR", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
