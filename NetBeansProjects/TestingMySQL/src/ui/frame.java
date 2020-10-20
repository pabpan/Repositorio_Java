package ui;

import java.awt.*;
import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class frame extends JFrame {

    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JButton backwards, forward, search, all;
    private JLabel e1, e2, e3;
    private JTextField id, idSearch;
    private JTextArea notes;
    private listener myListener; // this line will fail until the listener class is created

    public frame() {
        // usual properties of windows
        setSize(800, 200);
        setTitle("Access to MySQL");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // instance of design panels
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new FlowLayout());
        panel3.setLayout(new FlowLayout());
        panel4.setLayout(new FlowLayout());
        add(panel1);
        panel1.add(panel3, BorderLayout.SOUTH);
        panel1.add(panel2, BorderLayout.CENTER);
        panel1.add(panel4, BorderLayout.NORTH);
        // south panel with scroll buttons
        backwards = new JButton("<");
        forward = new JButton(">");
        panel3.add(backwards);
        panel3.add(forward);

        // central panel with data
        e1 = new JLabel("ID");
        id = new JTextField(10);
        panel2.add(e1);
        panel2.add(id);
        e2 = new JLabel("Notes");
        notes = new JTextArea(5, 40);
        panel2.add(e2);
        panel2.add(notes);
        // north panel with searches
        e3 = new JLabel("ID to find:");
        idSearch = new JTextField(10);
        search = new JButton("Search");
        all = new JButton("All");
        panel4.add(e3);
        panel4.add(idSearch);
        panel4.add(search);
        panel4.add(all);
        // add listeners, this line will fail until the listener class is not created
        myListener = new listener(id, notes, idSearch, backwards, forward, search, all);
        backwards.addActionListener(myListener);
        forward.addActionListener(myListener);
        search.addActionListener(myListener);
        all.addActionListener(myListener);
        // initially motion buttons disabled
        forward.setEnabled(false);
        backwards.setEnabled(false);
    }
}
