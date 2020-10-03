package cities_jcombo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cities_JCombo extends JFrame {

    final JPanel panel = new JPanel();
    //final GridLayout layout = new GridLayout(0, 3);
    JLabel etiqueta_roja = new JLabel("Select your city");
    final String ciudades[] = {"", "Roma", "New York", "Tokio", "Moscou"};
    final JComboBox<String> lista_combobox = new JComboBox<String>(ciudades);
    JLabel etiqueta_azul = new JLabel("Where do you want to go?");

    public Cities_JCombo() {

        setSize(550, 70);
        setTitle("Cities I would like to visit when the Pandemic is over");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.add(etiqueta_roja);
        etiqueta_roja.setForeground(Color.red);
        lista_combobox.addActionListener(new Gestion_combobox());
        panel.add(lista_combobox);
        etiqueta_azul.setForeground(Color.blue);
        panel.add(etiqueta_azul);
        add(panel);
    }

    private class Gestion_combobox implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            int indice = lista_combobox.getSelectedIndex();
            String aux = ciudades[indice];
            etiqueta_azul.setText(aux + " is selected.");
            if (lista_combobox.getSelectedIndex() == 0) {
                etiqueta_azul.setText("Nothing selected");
            }
        }
    }
}
