package Ejercicio1;

import java.awt.event.*;
import javax.swing.*;

public class Ui_Frame extends JFrame {

    //Creamos los paneles
    JPanel panel_global = new JPanel();

    //Creamos la lista del JCombo
    String[] cursos = {"Selecciona un curso", "1DAM", "2DAM"};
    JComboBox lista_cursos = new JComboBox(cursos);

    //Creamos el JList de las asignaturas
    String[] asignaturas_1 = {"ED", "IT", "SI", "FOL", "PRO"};
    String[] asignaturas_2 = {"DI", "PMDM", "ADA", "SGE", "IE"};
    String[] asignaturas_vacio = {" ", " ", " ", " ", " "};
    JList lista_asignaturas;

    JButton mostrar_mensaje = new JButton("Mostrar asignaturas");
    JOptionPane nuevo_Jpane;

    public Ui_Frame() {

        setTitle("JButton and JCombo");
        setBounds(382, 512, 600, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        lista_asignaturas = new JList(asignaturas_vacio);
        lista_asignaturas.setFixedCellHeight(15);
        lista_asignaturas.setFixedCellWidth(60);
        lista_asignaturas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        lista_cursos.addActionListener(new Gestion_ComboBox());

        panel_global.add(lista_cursos);

        panel_global.add(lista_asignaturas);

        mostrar_mensaje.addActionListener(new Gestion_Mensaje());
        panel_global.add(mostrar_mensaje);

        add(panel_global);
    }

    public class Gestion_ComboBox implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {

            int indice = lista_cursos.getSelectedIndex();
            String aux = cursos[indice];
            if (lista_cursos.getSelectedIndex() == 0) {
                lista_asignaturas.setListData(asignaturas_vacio);
            }
            if (lista_cursos.getSelectedIndex() == 1) {
                lista_asignaturas.setListData(asignaturas_1);
            }
            if (lista_cursos.getSelectedIndex() == 2) {
                lista_asignaturas.setListData(asignaturas_2);
            }
        }
    }

    public class Gestion_Mensaje implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String curso = "";
            if (lista_cursos.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Selecciona primero un curso y luego sus asignaturas", "Lista de asignaturas", JOptionPane.PLAIN_MESSAGE);
            }
            if (lista_cursos.getSelectedIndex() == 1) {
                curso = "1º DAM ";
                if (lista_asignaturas.getSelectedValue() == null) {
                    JOptionPane.showMessageDialog(null, "Selecciona las asignaturas a mostrar", "Lista de asignaturas", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Tienes estas asignaturas de " + curso + lista_asignaturas.getSelectedValuesList(), "Lista de asignaturas", JOptionPane.PLAIN_MESSAGE);
                }
            }
            if (lista_cursos.getSelectedIndex() == 2) {
                curso = "2º DAM ";
                if (lista_asignaturas.getSelectedValue() == null) {
                    JOptionPane.showMessageDialog(null, "Selecciona las asignaturas a mostrar", "Lista de asignaturas", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Tienes estas asignaturas de " + curso + lista_asignaturas.getSelectedValuesList(), "Lista de asignaturas", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
    }
}
