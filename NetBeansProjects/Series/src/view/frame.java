package view;

import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.listShow;
import model.show;

public class frame extends JFrame {

    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JButton b1, b2, b3, b4, b5, b6, b7;
    private JLabel e1, e2, e3, e4, e5, e6;
    private JTextField t1, t2, t3, t4, t5, t6;
    private final JComboBox JComboBox_plataformas = new JComboBox(plataformas);
    private static String plataformas[] = {"Netflix", "HBO", "Amazon Prime"};
    private controller c = null;

    public frame(controller control) {

        c = control;
        setSize(600, 300);
        setTitle("Pablo's Series Library");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new GridLayout(7, 2, 10, 10));
        panel3.setLayout(new FlowLayout());

        panel1.add(panel3, BorderLayout.NORTH);

        buttonListener manejar_botones = new buttonListener();

        show s2 = new show();
        s2 = c.first();

        b1 = new JButton("First");
        b1.addActionListener(manejar_botones);
        b2 = new JButton("Previous");
        b2.addActionListener(manejar_botones);
        b3 = new JButton("Next");
        b3.addActionListener(manejar_botones);
        b4 = new JButton("Last");
        b4.addActionListener(manejar_botones);
        b5 = new JButton("New");
        b5.addActionListener(manejar_botones);
        b6 = new JButton("Remove");
        b6.addActionListener(manejar_botones);
        b7 = new JButton("Modify");
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
        t1.setText(s2.getTittle());
        panel2.add(e1);
        panel2.add(t1);
        e2 = new JLabel("Screenwriter");
        t2 = new JTextField(50);
        t2.setEditable(false);
        t2.setText(s2.getScriptwriter());
        panel2.add(e2);
        panel2.add(t2);
        e3 = new JLabel("Season");
        t3 = new JTextField(50);
        t3.setEditable(false);
        int seasons = s2.getSeasons();
        t3.setText(String.valueOf(seasons));    
        panel2.add(e3);
        panel2.add(t3);
        e4 = new JLabel("Genre");
        t4 = new JTextField(50);
        t4.setEditable(false);
        t4.setText(s2.getGenre());
        panel2.add(e4);
        panel2.add(t4);
        e5 = new JLabel("Seen seasons");
        t5 = new JTextField(50);
        t5.setEditable(false);
        int views = s2.getViews();
        t5.setText(String.valueOf(views));
        panel2.add(e5);
        panel2.add(t5);

        e6 = new JLabel("Plataforma");
        t6 = new JTextField(50);
        t6.setEditable(false);
        t6.setText(s2.getPlataforma());
        panel2.add(e6);
        panel2.add(t6);

        add(panel1);
    }

    class buttonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            show s = new show();

            if (e.getSource() == b1) {
                s = c.first();
            }
            if (e.getSource() == b2) {
                s = c.previous();
            }
            if (e.getSource() == b3) {
                s = c.next();
            }
            if (e.getSource() == b5) {
                if (b5.getText().equals("New")) {
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");

                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(false);

                    t1.setEditable(true);
                    t2.setEditable(true);
                    t3.setEditable(true);
                    t4.setEditable(true);
                    t5.setEditable(true);
                    t6.setEditable(false);

                    b5.setText("Save");
                    JComboBox_plataformas.setVisible(true);
                    JComboBox_plataformas.setEnabled(true);
                    JComboBox_plataformas.addActionListener(new Gestion_combobox());
                    panel2.add(JComboBox_plataformas);

                } else {
                    t1.setEditable(false);
                    t2.setEditable(false);
                    t3.setEditable(false);
                    t4.setEditable(false);
                    t5.setEditable(false);
                    t6.setEditable(false);

                    b1.setEnabled(true);
                    b2.setEnabled(true);
                    b3.setEnabled(true);
                    b4.setEnabled(true);
                    b5.setEnabled(true);
                    b6.setEnabled(true);
                    b7.setEnabled(true);

                    b5.setText("New");
                    s = fillShow();
                    c.nuevo(s);
                    JComboBox_plataformas.setVisible(false);
                }
            }
            if (e.getSource() == b4) {
                s = c.last();
            }
            if (e.getSource() == b6) {
                c.delete();
                s = c.previous();
            }
            if (e.getSource() == b7) {
                if (b7.getText().equals("Modify")) {

                    s = fillShow();

                    t1.setEditable(true);
                    t2.setEditable(true);
                    t3.setEditable(true);
                    t4.setEditable(true);
                    t5.setEditable(true);
                    t6.setEditable(false);

                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    b5.setEnabled(false);
                    b6.setEnabled(false);
                    b7.setEnabled(true);
                    b7.setText("Save");

                    JComboBox_plataformas.setEnabled(true);
                    JComboBox_plataformas.setVisible(true);
                    JComboBox_plataformas.addActionListener(new Gestion_combobox());
                    panel2.add(JComboBox_plataformas);

                } else {
                    t1.setEditable(false);
                    t2.setEditable(false);
                    t3.setEditable(false);
                    t4.setEditable(false);
                    t5.setEditable(false);
                    t6.setEditable(false);

                    b1.setEnabled(true);
                    b2.setEnabled(true);
                    b3.setEnabled(true);
                    b4.setEnabled(true);
                    b5.setEnabled(true);
                    b6.setEnabled(true);
                    b7.setEnabled(true);
                    b7.setText("Modify");
                    s = fillShow();
                    c.nuevo(s);
                    JComboBox_plataformas.setEnabled(false);
                    JComboBox_plataformas.setVisible(false);
                }
            }

            updating(s);
        }

        private show fillShow() {
            show s = new show(t1.getText(), t2.getText(), Integer.parseInt(t3.getText()), t4.getText(), Integer.parseInt(t5.getText()), t6.getText());
            return s;
        }

        private void updating(show s) {
            t1.setText(s.getTittle());
            t2.setText(s.getScriptwriter());
            t3.setText(String.valueOf(s.getSeasons()));
            t4.setText(s.getGenre());
            t5.setText(String.valueOf(s.getViews()));
            t6.setText(s.getPlataforma());
        }
    }

    private class Gestion_combobox implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            int indice = JComboBox_plataformas.getSelectedIndex();
            String aux = plataformas[indice];
            if (JComboBox_plataformas.getSelectedIndex() == 0) {
                t6.setText("Netflix");
            }
            if (JComboBox_plataformas.getSelectedIndex() == 1) {
                t6.setText("HBO");
            }
            if (JComboBox_plataformas.getSelectedIndex() == 2) {
                t6.setText("Amazon Prime");
            }
        }

    }
}
