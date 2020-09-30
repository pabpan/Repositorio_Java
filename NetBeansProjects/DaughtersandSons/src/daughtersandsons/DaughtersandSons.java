//Create a window with 3 checkboxes: daugthers, sons and none, and two radiobuttons: 
//Female and Male. somewhere in the window there should be a message saying 
//"you have sons (or daughters or none) and you are male (or female)
package daughtersandsons;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DaughtersandSons extends JFrame {

    private JCheckBox daughter = new JCheckBox();
    private JCheckBox son = new JCheckBox();
    private JCheckBox none = new JCheckBox();
    private JRadioButton female;
    private JRadioButton male;
    private JLabel texto = new JLabel();
    private JLabel texto1 = new JLabel();
    private ButtonGroup opciones_grupo;

    public DaughtersandSons() {

        setTitle("Práctica 3: Daughters, sons or none");
        setSize(650, 200);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 5));

        //Inicializamos las checkboxes
        daughter = new JCheckBox("Daughter", false);
        panel.add(daughter);
        son = new JCheckBox("Son", false);
        panel.add(son);

        none = new JCheckBox("None", false);
        panel.add(none);

        //Inicializamos los radiobuttons
        female = new JRadioButton("Female", false);
        panel.add(female);
        male = new JRadioButton("Male", false);

        //creamos grupo de opciones
        ButtonGroup grupo_radiobutton = new ButtonGroup();
        grupo_radiobutton.add(female);
        grupo_radiobutton.add(male);

        panel.add(male);

        panel.add(texto);
        panel.add(texto1);

        add(panel);

        checkbox_listener manejador_checkboxes = new checkbox_listener();
        daughter.addItemListener(manejador_checkboxes);
        son.addItemListener(manejador_checkboxes);
        none.addItemListener(manejador_checkboxes);

        female.addItemListener(new radiobutton_listener());
        male.addItemListener(new radiobutton_listener());

    }

    private class checkbox_listener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {

            if (daughter.isSelected() && son.isSelected()) {
                texto.setText("You have daughters and sons and...");
                none.setSelected(false);
            } else if (daughter.isSelected()) {
                texto.setText("You have daughters and...");
                none.setSelected(false);
            } else {
                texto.setText("");
                if (son.isSelected()) {
                    texto.setText("You have sons and...");
                    none.setSelected(false);

                } else {
                    if (none.isSelected()) {
                        texto.setText("You don't have descendence and...");
                    }
                }
            }

        }
    }

    private class radiobutton_listener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {

            if (male.isSelected()) {
                texto1.setText("you are male.");
            }
            if (female.isSelected()) {
                texto1.setText("you are female.");
            }

        }

    }
}
