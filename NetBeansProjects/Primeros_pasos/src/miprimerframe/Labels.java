/**
 * @author pabpan
 */
package miprimerframe;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Labels extends JFrame {

    public Labels() {
        setTitle("JLablel EJEMPLO");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        // change the default panel layout
        panel.setLayout(new GridLayout(3, 1));
        // create three labels
        JLabel label1 = new JLabel("First label"); // default left justification
        JLabel label2 = new JLabel("Second label", JLabel.CENTER); //centered
        JLabel label3 = new JLabel("Third label", JLabel.RIGHT); //right
        // add them to the panel
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        add(panel);
    }
} // of frame
