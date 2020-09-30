package practicacombo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PracticaCombo extends JFrame {

    private JComboBox cajacombo;
    private JPanel panel;
    private JLabel label;
    private String[] images = {"Rabbit", "Cat", "Dog", "Bird", "Pig"};
    private Icon img;

    public PracticaCombo() {
        setSize(500, 300);
        setTitle("Combos e images");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        add(panel);

        //Pasamos el array de imágenes al lado norte
        cajacombo = new JComboBox(images);
        panel.add(cajacombo, BorderLayout.NORTH);

        //Con ImageIcon creamos una etiqueta en la que meteremos la imagen
        img = new ImageIcon(getClass().getResource("images/Rabbit.gif"));
        label = new JLabel();
        label.setText("Rabbit");
        label.setIcon(img);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setToolTipText("This is a label");
        panel.add(label, BorderLayout.CENTER);

        cajacombo.addItemListener(new Manejador_combo());
    }

    private class Manejador_combo implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {
            int indice = cajacombo.getSelectedIndex();
            String s = images[indice];
            img = new ImageIcon(getClass().getResource("images/" + s + ".gif"));
            label.setIcon(img);
            label.setText(s);
        }

    }
}
