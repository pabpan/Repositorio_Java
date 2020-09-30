package miprimerframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JtextField extends JFrame {

    JTextField textField1, textField2;
    JPanel panel = new JPanel();

    public JtextField() {
        setTitle("JTextField example");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3, 1, 5, 5));
        // Create two textfields and a button
        textField1 = new JTextField("Type something and press return", 20); 
        // 20 columns wide
        // Add a listener
        textField1.addActionListener(new TextFieldListener());
        // Assign a black border line. 
        textField1.setBorder(BorderFactory.createLineBorder(Color.black));
        textField2 = new JTextField(20);
        textField2.setBorder(BorderFactory.createLineBorder(Color.blue));

        JButton button = new JButton("Clear");
        button.addActionListener(new ButtonListener());
        // Add the elements to the panel
        panel.add(textField1);
        panel.add(textField2);
        panel.add(button);
        add(panel);
    }
    // textfield listener

    class TextFieldListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // get the text typed in textfield1
            // and assign it to the other textfield.
            String text = textField1.getText();
            textField2.setText(text);
        }
    }
    // listener of the button.

    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // clean the textfields.
            textField1.setText("");
            textField1.requestFocus(); // Give focus to textfield1
            textField2.setText("");
        }
    }
}
