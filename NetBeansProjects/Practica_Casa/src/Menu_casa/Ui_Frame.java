package Menu_casa;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;

public class Ui_Frame extends JFrame {

    private ImageIcon casa, casa_redmiensionada;//ICONO HOME
    private JPanel panel;
    private JMenuBar Barra_menu;//BARRA QUE ALOJA EL MENÚ
    private JMenu casa_menu, extras_menu, habitaciones_menu;//MENÚS QUE FORMARÁN LA BARRA
    private JMenuItem hab1_item, hab2_item, garaje_item, trastero_item;//ITEM QUE FORMARÁN LOS MENÚS
    private JCheckBoxMenuItem salon;
    private JRadioButtonMenuItem cocina, banyo;
    private ButtonGroup grupo_radiobuttons;

    public Ui_Frame() {

        setTitle("Práctica Menú Casa");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel(new BorderLayout());

        Barra_menu = new JMenuBar();
        casa = new ImageIcon("src/Imagenes/hogar.png");

        //PARA PODER REDMIENSIONAR UN ICONO HAY QUE CONVERTIRLO PRIMERO A IMAGEN
        Image img = casa.getImage();
        Image nueva_img = img.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
        casa_redmiensionada = new ImageIcon(nueva_img);

        casa_menu = new JMenu("Casa");
        casa_menu.setIcon(casa_redmiensionada);
        extras_menu = new JMenu("Extras");
        garaje_item = new JMenuItem("Garaje");
        garaje_item.setAccelerator(KeyStroke.getKeyStroke('G', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        trastero_item = new JMenuItem("Trastero");
        trastero_item.setAccelerator(KeyStroke.getKeyStroke('T', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        extras_menu.add(garaje_item);
        extras_menu.add(trastero_item);
        Barra_menu.add(casa_menu);
        Barra_menu.add(extras_menu);
        habitaciones_menu = new JMenu("Habitaciones");
        casa_menu.add(habitaciones_menu);
        hab1_item = new JMenuItem("Habitación 1");
        hab2_item = new JMenuItem("Habitación 2");
        hab2_item.setEnabled(false);
        habitaciones_menu.add(hab1_item);
        habitaciones_menu.add(hab2_item);

        salon = new JCheckBoxMenuItem("Salón");
        salon.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        salon.setSelected(true);
        casa_menu.add(salon);
        casa_menu.addSeparator();

        cocina = new JRadioButtonMenuItem("Cocina");
        cocina.setAccelerator(KeyStroke.getKeyStroke('C', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        cocina.setSelected(true);
        banyo = new JRadioButtonMenuItem("Baño");
        banyo.setAccelerator(KeyStroke.getKeyStroke('B', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        grupo_radiobuttons = new ButtonGroup();
        grupo_radiobuttons.add(banyo);
        grupo_radiobuttons.add(cocina);
        casa_menu.add(cocina);
        casa_menu.add(banyo);

        add(Barra_menu, BorderLayout.NORTH);
        add(panel);
    }
//    public Ui_Frame() {
//
//        setSize(800, 600);
//        setTitle("Model and non-modal windows");
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLayout(new FlowLayout());
//
//        //MENU ITEMS:
//        JMenuBar menuBar;
//        JMenu menu;
//        JMenuItem menuItem;
//        // We instantiate the menu bar.
//        menuBar = new JMenuBar();
//
//        JCheckBoxMenuItem jchecjMenu1, jchecjMenu2;
//        JRadioButtonMenuItem jRadioButtonMenu1 = new JRadioButtonMenuItem("Radio1");
//        JRadioButtonMenuItem jRadioButtonMenu2 = new JRadioButtonMenuItem("Radio2");
//        ButtonGroup grupoRadios;
//
//        //Menu
//        menu = new JMenu("Casa");
//        menuBar.add(menu);
//
//        menu = new JMenu("Extras");
//        menuBar.add(menu);
//        
//        menuItem = new JMenuItem("Habitaciones");
//        menu.add(menuItem);
//        menu.addSeparator(); //separator
//        menuItem = new JMenuItem("Salón");
//        menu.add(menuItem);
//        menu.addSeparator(); //separator
//
//        //Metemos checkboxes
//        jchecjMenu1 = new JCheckBoxMenuItem("check1");
//        menu.add(jchecjMenu1);
//        menu.addSeparator(); //separator
//        jchecjMenu2 = new JCheckBoxMenuItem("check2");
//        menu.add(jchecjMenu2);
//        menu.addSeparator(); //separator
//
//        //Metemos los radiobuttons
//        grupoRadios = new ButtonGroup();
//        grupoRadios.add(jRadioButtonMenu1);
//        grupoRadios.add(jRadioButtonMenu2);
//        menu.add(jRadioButtonMenu1);
//        menu.addSeparator(); //separator
//        menu.add(jRadioButtonMenu2);
//
//        // Second option in the menu bar without any item.
//        add(menuBar);
//
//    }
//
//    class em implements ActionListener {
//
//        JFrame miframe;
//
//        public em(JFrame f) {
//            miframe = f;
//        }
//
//        public void actionPerformed(ActionEvent e) {
//            DialogModal dialogmodal = new DialogModal(miframe);
//            dialogmodal.pack();
//            dialogmodal.setVisible(true);
//            System.out.println(dialogmodal.getText());
//        }
//    }

}
