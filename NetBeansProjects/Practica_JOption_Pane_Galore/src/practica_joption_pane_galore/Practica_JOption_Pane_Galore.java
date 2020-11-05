package practica_joption_pane_galore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Practica_JOption_Pane_Galore extends JFrame {

    JPanel panel_global = new JPanel();
    JButton boton_info, boton_adv, boton_error, boton_ok, boton_texto, boton_combo, boton_mas;

    public Practica_JOption_Pane_Galore() {

        setTitle("Montones de JoptionPane");
        setSize(500, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        boton_info = new JButton("Info");
        boton_adv = new JButton("Advertencia");
        boton_error = new JButton("Error");
        boton_ok = new JButton("Confimación");
        boton_texto = new JButton("Texto");
        boton_combo = new JButton("Combo");
        boton_mas = new JButton("Más");

        boton_info.addActionListener(new Info());
        boton_adv.addActionListener(new Adv());
        boton_error.addActionListener(new Error());
        boton_ok.addActionListener(new Confirmacion());
        boton_texto.addActionListener(new Texto());

        panel_global.add(boton_info);
        panel_global.add(boton_adv);
        panel_global.add(boton_error);
        panel_global.add(boton_ok);
        panel_global.add(boton_texto);
        panel_global.add(boton_combo);
        panel_global.add(boton_mas);

        add(panel_global);
    }

    public class Info implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            JOptionPane.showMessageDialog(null, "Este es un mensaje simple tipo información", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Este es un mensaje simple tipo información", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public class Adv implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            JOptionPane.showMessageDialog(null, "Este es un mensaje de advertencia", "Mensaje", JOptionPane.WARNING_MESSAGE);
        }
    }

    public class Error implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            JOptionPane.showMessageDialog(null, "Este es un mensaje de Error", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public class Confirmacion implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            JOptionPane.showMessageDialog(null, "Este es un mensaje de confirmación o pregunta", "Mensaje", JOptionPane.QUESTION_MESSAGE);
        }
    }

    public class Texto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String texto = JOptionPane.showInputDialog(null, "Escribe un número para multiplicarlo por 2");
            try {
                int resultado = 2 * Integer.parseInt(texto);
                JOptionPane.showMessageDialog(null, "El resultado es: " + texto + "*2 = " + resultado, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "El valor ingresado debe ser numérico", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
