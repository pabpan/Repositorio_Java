/**
 * @author pabpan
 */

package miprimerframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class miprimerframe extends JFrame {

// I create an object of type JPanel
    JPanel panel = new JPanel();

    public miprimerframe() {

        setTitle("¡HOLA MUNDO!");
// window title
        setSize(300, 200);
// size
        setDefaultCloseOperation(EXIT_ON_CLOSE);

// I add the panel to the frame
        add(panel);
// I put the background color of the panel red
        panel.setBackground(Color.red);
// instantiate a button
        JButton button = new JButton("Cambiar color de fondo");
// add the listener created earlier        
        button.addActionListener (new listener_button());
// set the button dimensions
        Dimension d = new Dimension();
        d.height = 40;
        d.width = 200;
        button.setPreferredSize(d);
// add the button to the panel
        panel.add(button);
    }

// class to listen to button events
    class listener_button implements ActionListener {
// The actionPerformed method has to be rewritten, it is the one that responds to the button click
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.blue);
        }
    } // from listener_button
}
