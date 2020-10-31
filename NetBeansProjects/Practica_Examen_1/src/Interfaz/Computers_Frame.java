package Interfaz;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import javax.swing.*;

public class Computers_Frame extends JFrame {

    JPanel panel_global, panel_componentes, panel_micros, panel_ram, panel_monitores, panel_miscelanea, panel_inferior;
    String[][] micros = {{"Intel 1", "300"}, {"Intel 2", "350"}, {"AMD 1", "200"}, {"AMD 2", "250"}};
    String[][] ram = {{"1GB", "10"}, {"2GB", "25"}, {"4GB", "40"}, {"8GB", "60"}};
    String[][] monitores = {{"LG1", "150"}, {"LG2", "300"}, {"HP1", "250"}, {"HP2", "350"}};
    String[][] opcionales = {{"Mouse normal", "10"}, {"Mouse profesional", "20"}, {"Keyboard normal", "10"}, {"Keyboard profesional", "20"}};
    ButtonGroup grupo_micros, grupo_ram, grupo_monitores;
    JCheckBox mouse_normal, mouse_pro, keyboard_normal, keyboard_pro;
    JButton boton_previsualizar, boton_imprimir;
    JTextArea area_texto_imprimir;

    public Computers_Frame() {

        setTitle("Choose a computer");
        setSize(800, 510);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Creamos los paneles
        panel_global = new JPanel(new BorderLayout());
        panel_componentes = new JPanel(new GridLayout(1, 4));
        panel_inferior = new JPanel(new BorderLayout());
        panel_micros = new JPanel(new GridLayout(4, 1));
        panel_ram = new JPanel(new GridLayout(4, 1));
        panel_monitores = new JPanel(new GridLayout(4, 1));
        panel_miscelanea = new JPanel(new GridLayout(4, 1));

        //Creamos los grupos
        grupo_micros = new ButtonGroup();
        grupo_ram = new ButtonGroup();
        grupo_monitores = new ButtonGroup();

        //Creamos los checkboxes opcionales
        mouse_normal = new JCheckBox("Mouse normal");
        mouse_pro = new JCheckBox("Mouse pro");
        keyboard_normal = new JCheckBox("Keyboard normal");
        keyboard_pro = new JCheckBox("Keyboard pro");

        //Recorremos los micros y los añadimos al panel
        for (String[] micro : micros) {
            JRadioButton aux = new JRadioButton(micro[0]);
            grupo_micros.add(aux);
            panel_micros.add(aux);
        }

        //Recorremos las rams y las añadimos al panel
        for (String[] ram1 : ram) {
            JRadioButton aux = new JRadioButton(ram1[0]);
            grupo_ram.add(aux);
            panel_ram.add(aux);
        }

        //Recorremos los monitores y las añadimos al panel
        for (String[] monitores1 : monitores) {
            JRadioButton aux = new JRadioButton(monitores1[0]);
            grupo_monitores.add(aux);
            panel_monitores.add(aux);
        }

        //Recorremos los periféricos opcionales y los añadimos al panel
        for (String[] opcionales1 : opcionales) {
            JCheckBox aux = new JCheckBox(opcionales1[0]);
            panel_miscelanea.add(aux);
        }

        //Añadimos títulos a los bordes de los paneles
        panel_micros.setBorder(BorderFactory.createTitledBorder("Micros"));
        panel_ram.setBorder(BorderFactory.createTitledBorder("Ram"));
        panel_monitores.setBorder(BorderFactory.createTitledBorder("Monitores"));
        panel_miscelanea.setBorder(BorderFactory.createTitledBorder("Miscelanea"));

        //Añadimos el contenedor de paneles
        add(panel_global);

        //Añadimos los paneles al panel de componentes
        panel_componentes.add(panel_micros);
        panel_componentes.add(panel_ram);
        panel_componentes.add(panel_monitores);
        panel_componentes.add(panel_miscelanea);

        //Añadimos los componentes del panel inferior
        boton_previsualizar = new JButton("Previsualizar Factura");
        area_texto_imprimir = new JTextArea();
        area_texto_imprimir.setEditable(false);
        boton_imprimir = new JButton("Imprimir");
        panel_inferior.add(boton_previsualizar, BorderLayout.NORTH);
        panel_inferior.add(area_texto_imprimir, BorderLayout.CENTER);
        panel_inferior.add(boton_imprimir, BorderLayout.SOUTH);

        //Añadimos el panel de componentes al panel global
        panel_global.add(panel_componentes, BorderLayout.NORTH);

        //Añadimos los botones y area a imprimir al panel inferior del panel global
        panel_global.add(panel_inferior, BorderLayout.CENTER);

        //Una vez creada la interfaz empezamos a añadir las acciones
        //ACCIONES PARA LOS RADIOBUTTONS
        //MICROS
        boton_previsualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int precio_micro, precio_ram, precio_monitor, precio_componente_adicional, precio_total = 0;
                String previsualizar_texto = "";
                
                for (int i = 0; i < panel_micros.getComponentCount(); i++) {
                    JRadioButton aux = (JRadioButton) panel_micros.getComponent(i);
                    if (aux.isSelected()) {
                        precio_micro = Integer.parseInt(micros[i][1]);
                        precio_total += precio_micro;
                        previsualizar_texto += ("- Procesador seleccionado:\n\t" + aux.getText() + "\t\t ----------------------- " + precio_micro + "€\n");
                    }
                }

                for (int i = 0; i < panel_ram.getComponentCount(); i++) {
                    JRadioButton aux = (JRadioButton) panel_ram.getComponent(i);
                    if (aux.isSelected()) {
                        precio_ram = Integer.parseInt(ram[i][1]);
                        precio_total += precio_ram;
                        previsualizar_texto += ("- RAM seleccionada:\n\t" + aux.getText() + "\t\t ----------------------- " + precio_ram + "€\n");
                    }
                }
                for (int i = 0; i < panel_monitores.getComponentCount(); i++) {
                    JRadioButton aux = (JRadioButton) panel_monitores.getComponent(i);
                    if (aux.isSelected()) {
                        precio_monitor = Integer.parseInt(monitores[i][1]);
                        precio_total += precio_monitor;
                        previsualizar_texto += ("- Monitor seleccionado:\n\t" + aux.getText() + "\t\t ----------------------- " + precio_monitor + "€\n");
                    }
                }
                for (int i = 0; i < panel_miscelanea.getComponentCount(); i++) {
                    JCheckBox aux = (JCheckBox) panel_miscelanea.getComponent(i);

                    if (aux.isSelected()) {
                        precio_componente_adicional = Integer.parseInt(opcionales[i][1]);
                        precio_total += precio_componente_adicional;
                        previsualizar_texto += ("- Componente adicional: \n"
                                + "\t" + aux.getText() + "\t ----------------------- " + precio_componente_adicional + "€\n");
                    }
                }
                area_texto_imprimir.setText("\nFACTURA PROFORMA ORDENADOR\n"
                        + "-----------------------------------------------------------------------------------------------------\n"
                        + previsualizar_texto + "-----------------------------------------------------------------------------------------------------\n"
                        + " TOTAL FACTURA :\t\t ----------------------- " + precio_total + "€ \n"
                        + "-----------------------------------------------------------------------------------------------------");
            }
        });
        
        boton_imprimir.addActionListener((ActionEvent arg0) -> {
            try {
                boolean ok = area_texto_imprimir.print();
                if (ok) {
                    System.out.println("¡¡TODO CORRECTO!!");
                } else {
                    System.out.println("¡¡OPERACIÓN CANCELADA!!");
                }
            } catch (PrinterException e) {
            }
        });
    }
}
