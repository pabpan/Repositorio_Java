package joption_panes.MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class DialogModal extends JDialog {
    
    private JTextField textflied;
    
    public DialogModal(JFrame parent) {
        super (parent, true);
        setTitle("Enter a data");
        textflied = new JTextField(20);
        add(textflied);
        
        textflied.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
    }
    public String getText() {
        return textflied.getText();
    }
    
}