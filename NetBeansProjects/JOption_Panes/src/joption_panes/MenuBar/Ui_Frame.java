/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joption_panes.MenuBar;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Ui_Frame extends JFrame {

    public Ui_Frame() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // MENU ITEMS:
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
// We instantiate the menu bar.
        menuBar = new JMenuBar();
// The first option on the menu.
        menu = new JMenu("First Menu");
        menuBar.add(menu);
// to the first option of the menu we put two items.
        menuItem = new JMenuItem("Option 1");
        menu.add(menuItem);
        menu.addSeparator(); //separator
        menuItem = new JMenuItem("Option 2");
        menu.add(menuItem);
// Second option in the menu bar without any item.
        menu = new JMenu("Second Menu");
        menuBar.add(menu);

        JPanel pane = new JPanel();
        setSize(500, 300);
        pane.add(menuBar);
        add(pane);
    }

}
