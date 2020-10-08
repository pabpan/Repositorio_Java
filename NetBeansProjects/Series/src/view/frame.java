package view;

import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.show;

public class frame extends JFrame {

    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JButton b1, b2, b3, b4, b5, b6, b7;
    private JLabel e1, e2, e3, e4, e5, e6;
    private JTextField t1, t2, t3, t4, t5, t6;
    private controller c = null;

    public frame(controller control) {

        c = control;
        setSize(500, 300);
        setTitle("My series");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new GridLayout(7, 2, 10, 10));
        panel3.setLayout(new FlowLayout());

        panel1.add(panel3, BorderLayout.NORTH);

        buttonListener manejar_botones = new buttonListener();

        b1 = new JButton("|<");
        b1.addActionListener(manejar_botones);
        b2 = new JButton("<");
        b2.addActionListener(manejar_botones);
        b3 = new JButton(">");
        b3.addActionListener(manejar_botones);
        b4 = new JButton(">|");
        b4.addActionListener(manejar_botones);
        b5 = new JButton("+");
        b5.addActionListener(manejar_botones);
        b6 = new JButton("-");
        b6.addActionListener(manejar_botones);
        b7 = new JButton("*");
        b7.addActionListener(manejar_botones);
        panel3.add(b1);
        panel3.add(b2);
        panel3.add(b3);
        panel3.add(b4);
        panel3.add(b5);
        panel3.add(b6);
        panel3.add(b7);

        panel1.add(panel2, BorderLayout.CENTER);
        e1 = new JLabel("Title");
        t1 = new JTextField(50);
        t1.setEditable(false);
        panel2.add(e1);
        panel2.add(t1);
        e2 = new JLabel("Screenwriter");
        t2 = new JTextField(50);
        t2.setEditable(false);
        panel2.add(e2);
        panel2.add(t2);
        e3 = new JLabel("Season");
        t3 = new JTextField(50);
        t3.setEditable(false);
        panel2.add(e3);
        panel2.add(t3);
        e4 = new JLabel("Genre");
        t4 = new JTextField(50);
        t4.setEditable(false);
        panel2.add(e4);
        panel2.add(t4);
        e5 = new JLabel("Seen seasons");
        t5 = new JTextField(50);
        t5.setEditable(false);
        panel2.add(e5);
        panel2.add(t5);

        add(panel1);
    }

    class buttonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            show s = new show();
            if (e.getSource() == b1) {
                s = c.first();
            }
            updating(s);
        }
        
        private void updating (show s) {
            t1.setText(s.getTittle());
            t2.setText(s.getScriptwriter());
            t3.setText(String.valueOf(s.getSeasons()));
            t4.setText(s.getGenre());
            t5.setText(String.valueOf(s.getViews()));
        }
    }
}
