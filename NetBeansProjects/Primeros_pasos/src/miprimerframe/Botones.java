/**
 * @author pabpan
 */

package miprimerframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Botones extends JFrame {

    JPanel panel = new JPanel();
    private JButton blue, pink, yellow, green;

    public Botones() {
        setTitle("Botones para cambiar colores en BorderLayout");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new BorderLayout());
        blue = new JButton("Azul");
        Dimension d = new Dimension();
        d.height = 40;
        d.width = 100;
        blue.setPreferredSize(d);
        blue.addActionListener(new listener_button_blue());
        green = new JButton("Verde");
        d.height = 40;
        d.width = 100;
        green.setPreferredSize(d);
        green.addActionListener(new listener_button_green());
        yellow = new JButton("Amarillo");
        d.height = 40;
        d.width = 100;
        yellow.setPreferredSize(d);
        yellow.addActionListener(new listener_button_yellow());
        pink = new JButton("Rosa");
        d.height = 40;
        d.width = 100;
        pink.setPreferredSize(d);
        pink.addActionListener(new listener_button_pink());
        panel.add(blue, BorderLayout.SOUTH);
        panel.add(green, BorderLayout.NORTH);
        panel.add(yellow, BorderLayout.EAST);
        panel.add(pink, BorderLayout.WEST);
        add(panel);
        panel.setBackground(Color.red);
    }

    class listener_button_blue implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.blue);
        }
    }

    class listener_button_green implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.green);
        }
    }

    class listener_button_yellow implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.yellow);
        }
    }

    class listener_button_pink implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.pink);
        }
    }
} // of frame
