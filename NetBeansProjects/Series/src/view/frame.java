package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class frame extends JFrame{
    
    private JPanel panel1 = new JPanel();
    
    public frame (){
        setSize(500,300);
        setTitle("My series");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel1.setLayout(new BorderLayout());
        add(panel1);
    }
}
