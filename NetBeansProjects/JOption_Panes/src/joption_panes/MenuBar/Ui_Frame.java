package joption_panes.MenuBar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;

public class Ui_Frame extends JFrame {

    public Ui_Frame() {

        setSize(800, 600);
        setTitle("Model and non-modal windows");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // MENU ITEMS:
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        // We instantiate the menu bar.
        menuBar = new JMenuBar();
        

        JCheckBoxMenuItem jchecjMenu1, jchecjMenu2;
        JRadioButtonMenuItem jRadioButtonMenu1 = new JRadioButtonMenuItem("Radio1");
        JRadioButtonMenuItem jRadioButtonMenu2 = new JRadioButtonMenuItem("Radio2");
        ButtonGroup grupoRadios;

        JPanel panel_global = new JPanel();

        JPopupMenu menuEmergente = new JPopupMenu();
        menuItem = new JMenuItem("Opción Emergente 1");
        menuEmergente.add(menuItem);
        menuEmergente.addSeparator(); //separator
        menuItem = new JMenuItem("Opción Emergente 2");
        menuEmergente.add(menuItem);
        panel_global.setComponentPopupMenu(menuEmergente);

        // The first option on the menu.
        menu = new JMenu("First Menu");
        menuBar.add(menu);
        // to the first option of the menu we put two items.
        menuItem = new JMenuItem("Option 1");
        menu.add(menuItem);
        menu.addSeparator(); //separator
        menuItem.addActionListener(new em(this));
        menuItem = new JMenuItem("Option 2");
        menu.add(menuItem);
        menu.addSeparator(); //separator

        //Metemos checkboxes
        jchecjMenu1 = new JCheckBoxMenuItem("check1");
        menu.add(jchecjMenu1);
        menu.addSeparator(); //separator
        jchecjMenu2 = new JCheckBoxMenuItem("check2");
        menu.add(jchecjMenu2);
        menu.addSeparator(); //separator

        //Metemos los radiobuttons
        grupoRadios = new ButtonGroup();
        grupoRadios.add(jRadioButtonMenu1);
        grupoRadios.add(jRadioButtonMenu2);
        menu.add(jRadioButtonMenu1);
        menu.addSeparator(); //separator
        menu.add(jRadioButtonMenu2);

        // Second option in the menu bar without any item.
        menu = new JMenu("Second Menu");
        menuBar.add(menu);
        add(menuBar, BorderLayout.NORTH);
        add(panel_global);

    }

    class em implements ActionListener {

        JFrame miframe;

        public em(JFrame f) {
            miframe = f;
        }

        public void actionPerformed(ActionEvent e) {
            DialogModal dialogmodal = new DialogModal(miframe);
            dialogmodal.pack();
            dialogmodal.setVisible(true);
            System.out.println(dialogmodal.getText());
        }
    }

}
