package practica_joption_pane_galore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
        boton_combo.addActionListener(new Combo());
        boton_mas.addActionListener(new Mas());

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
                JOptionPane.showMessageDialog(null, "El valor ingresado debe ser numérico", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public class Combo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            Object seleccion = JOptionPane.showInputDialog(null, "Selecciones un color", "COLORES", JOptionPane.QUESTION_MESSAGE,
                    null, new Object[]{"Seleccione", "Rojo", "amarillo", "Azul"}, "Seleccione");
            if (seleccion != null && seleccion != "Seleccione") {
                JOptionPane.showMessageDialog(null, "Color Seleccionado " + seleccion, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
            if (seleccion == "Seleccione") {
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningún color", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public class Mas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            JCheckBox opcion1 = new JCheckBox("A veces");
            JCheckBox opcion2 = new JCheckBox("A menudo");
            JCheckBox opcion3 = new JCheckBox("Siempre");
            Object[] opciones = {opcion1, opcion2, opcion3};

            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Selector de opciones", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcion1.isSelected()) {
                JOptionPane.showMessageDialog(null, "Seleccionado a veces", "A veces", JOptionPane.INFORMATION_MESSAGE);
            }
            if (opcion2.isSelected()) {
                JOptionPane.showMessageDialog(null, "Seleccionado a menudo", "A menudo", JOptionPane.INFORMATION_MESSAGE);
            }
            if (opcion3.isSelected()) {
                JOptionPane.showMessageDialog(null, "Seleccionado siempre", "Siempre", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }
}
