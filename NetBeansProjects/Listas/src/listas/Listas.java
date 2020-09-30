package listas;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Listas extends JFrame {

    private JPanel panel = new JPanel();
    private JList Jlist_colores;
    private final String nombre_colores[] = {"Red", "Blue", "Green", "Pink", "Black", "Cyan"};
    private final Color colores[] = {Color.RED, Color.BLUE, Color.GREEN, Color.PINK, Color.BLACK, Color.CYAN};

    public Listas() {

        setTitle("Listas");
        setSize(800, 600);
        add(panel);

        //Instanciamos el JList con el vector de colores
        Jlist_colores = new JList(nombre_colores);
        Jlist_colores.setVisibleRowCount(5);       
        
        panel.add(new JScrollPane(Jlist_colores));

        Jlist_colores.addListSelectionListener(new Manejador_lista());

    }

    private class Manejador_lista implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent event) {
            panel.setBackground(colores[Jlist_colores.getSelectedIndex()]);
        }

    }

}
