/*
 * PRÁCTICA CRUD
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DISEÑO DE INTERFACES
 * 
 */
package Controlador;

import java.awt.event.*;
import java.awt.event.KeyListener;
import Modelo.*;
import Vista.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorCRUD implements ActionListener, KeyListener {

    VistaClientes vistaCRUD = new VistaClientes();
    DAOCliente modeloCRUD = new DAOCliente();

    public ControladorCRUD(VistaClientes vistaCRUD, DAOCliente modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.boton_crear_usuario.addActionListener(this);
        this.vistaCRUD.boton_read_usuarios.addActionListener(this);
        this.vistaCRUD.boton_delete_usuario.addActionListener(this);
        this.vistaCRUD.boton_update_usuario.addActionListener(this);
        this.vistaCRUD.boton_ok.addActionListener(this);
        this.vistaCRUD.texto_id.addKeyListener(this);
        this.vistaCRUD.texto_nombre.addKeyListener(this);
        this.vistaCRUD.texto_apellidos.addKeyListener(this);
        this.vistaCRUD.texto_direccion.addKeyListener(this);
        this.vistaCRUD.texto_localidad.addKeyListener(this);
        this.vistaCRUD.texto_telefono.addKeyListener(this);
        this.vistaCRUD.texto_buscar.addKeyListener(this);

    }

    public void InicializarCrud() {

    }

    public void LLenarTabla(JTable tabla_datos) {
        DefaultTableModel modelo_tabla = new DefaultTableModel();
        tabla_datos.setModel(modelo_tabla);
        modelo_tabla.addColumn("ID");
        modelo_tabla.addColumn("Nombre");
        modelo_tabla.addColumn("Apellidos");
        modelo_tabla.addColumn("Dirección");
        modelo_tabla.addColumn("Localidad");
        modelo_tabla.addColumn("Teléfono");

        Object[] columna = new Object[6];

        int num_registros = modeloCRUD.lista_Cliente().size();

        for (int i = 0; i < num_registros; i++) {
            columna[0] = modeloCRUD.lista_Cliente().get(i).getId();
            columna[1] = modeloCRUD.lista_Cliente().get(i).getNombre();
            columna[2] = modeloCRUD.lista_Cliente().get(i).getApellidos();
            columna[3] = modeloCRUD.lista_Cliente().get(i).getDireccion();
            columna[4] = modeloCRUD.lista_Cliente().get(i).getLocalidad();
            columna[5] = modeloCRUD.lista_Cliente().get(i).getTelefono();
            modelo_tabla.addRow(columna);
        }

        tabla_datos.getColumnModel().getColumn(0).setPreferredWidth(20);
        tabla_datos.getColumnModel().getColumn(1).setPreferredWidth(60);
        tabla_datos.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabla_datos.getColumnModel().getColumn(3).setPreferredWidth(200);
        tabla_datos.getColumnModel().getColumn(4).setPreferredWidth(60);
        tabla_datos.getColumnModel().getColumn(5).setPreferredWidth(60);
    }

    public void limpiar_Campos() {
        vistaCRUD.texto_id.setText("");
        vistaCRUD.texto_id.setEditable(true);
        vistaCRUD.texto_nombre.setText("");
        vistaCRUD.texto_nombre.setEditable(true);
        vistaCRUD.texto_apellidos.setText("");
        vistaCRUD.texto_apellidos.setEditable(true);
        vistaCRUD.texto_direccion.setText("");
        vistaCRUD.texto_direccion.setEditable(true);
        vistaCRUD.texto_localidad.setText("");
        vistaCRUD.texto_localidad.setEditable(true);
        vistaCRUD.texto_telefono.setText("");
        vistaCRUD.texto_telefono.setEditable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == vistaCRUD.boton_crear_usuario) {
                String id = vistaCRUD.texto_id.getText();
                String nombre = vistaCRUD.texto_nombre.getText();
                String apellidos = vistaCRUD.texto_apellidos.getText();
                String direccion = vistaCRUD.texto_direccion.getText();
                String localidad = vistaCRUD.texto_localidad.getText();
                String telefono = vistaCRUD.texto_telefono.getText();

                String respuesta_Registro = modeloCRUD.insertar_cliente(Integer.parseInt(id), nombre, apellidos, direccion, localidad, Integer.parseInt(telefono));

                if (respuesta_Registro != null) {
                    JOptionPane.showMessageDialog(null, respuesta_Registro);
                } else {
                    JOptionPane.showMessageDialog(null, "Registro erróneo");
                }
            }

            if (e.getSource() == vistaCRUD.boton_read_usuarios) {
                LLenarTabla(vistaCRUD.tabla_datos);
            }
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, "Debe rellenar los campos antes");
        }

        if (e.getSource() == vistaCRUD.boton_delete_usuario) {

            int filaInicio = vistaCRUD.tabla_datos.getSelectedRow();
            int numero_filas_seleccionadas = vistaCRUD.tabla_datos.getSelectedRowCount();

            ArrayList<String> lista_id = new ArrayList();
            String id = "";
            if (filaInicio > 0) {
                for (int i = 0; i < numero_filas_seleccionadas; i++) {
                    id = String.valueOf(vistaCRUD.tabla_datos.getValueAt(i + filaInicio, 0));
                    lista_id.add(id);
                }
                for (int i = 0; i < numero_filas_seleccionadas; i++) {
                    int respuesta_usuario = JOptionPane.showConfirmDialog(null, "Quiere eliminar el resgistro con id " + id + "?");
                    if (respuesta_usuario == 0) {
                        modeloCRUD.eliminar_cliente(Integer.parseInt(id));
                    }
                }
                LLenarTabla(vistaCRUD.tabla_datos);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona al menos una fila a eliminar");
            }
        }

        if (e.getSource() == vistaCRUD.boton_update_usuario) {

            int fila_editar = vistaCRUD.tabla_datos.getSelectedRow();
            int num_filas_seleccionadas = vistaCRUD.tabla_datos.getSelectedRowCount();

            if (fila_editar >= 0 && num_filas_seleccionadas == 1) {
                vistaCRUD.texto_id.setText(String.valueOf(vistaCRUD.tabla_datos.getValueAt(fila_editar, 0)));
                vistaCRUD.boton_ok.setEnabled(true);
                vistaCRUD.texto_id.setEditable(false);
                vistaCRUD.boton_crear_usuario.setEnabled(false);
                vistaCRUD.boton_update_usuario.setEnabled(false);
                vistaCRUD.boton_delete_usuario.setEnabled(false);
                vistaCRUD.texto_buscar.setEnabled(false);
                vistaCRUD.texto_nombre.setEnabled(true);
                vistaCRUD.texto_apellidos.setEnabled(true);
                vistaCRUD.texto_direccion.setEnabled(true);
                vistaCRUD.texto_localidad.setEnabled(true);
                vistaCRUD.texto_telefono.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila o al menos una");
            }
        }

        //BOTON REALIZAR CAMBIOS
        if (e.getSource() == vistaCRUD.boton_ok) {
            String id = vistaCRUD.texto_id.getText();
            String nombre = vistaCRUD.texto_nombre.getText();
            String apellidos = vistaCRUD.texto_apellidos.getText();
            String direccion = vistaCRUD.texto_direccion.getText();
            String localidad = vistaCRUD.texto_localidad.getText();
            String telefono = vistaCRUD.texto_telefono.getText();

            int respuesta_ok = modeloCRUD.actualizar_Usuario(Integer.parseInt(id), nombre, apellidos, direccion, localidad, Integer.parseInt(telefono));
            if (respuesta_ok > 0) {
                JOptionPane.showMessageDialog(null, "Actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido actualizar");
            }
            limpiar_Campos();
            LLenarTabla(vistaCRUD.tabla_datos);
            vistaCRUD.boton_crear_usuario.setEnabled(true);
            vistaCRUD.boton_update_usuario.setEnabled(true);
            vistaCRUD.boton_delete_usuario.setEnabled(true);
            vistaCRUD.texto_buscar.setEnabled(true);
            vistaCRUD.boton_ok.setEnabled(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        if (arg0.getSource() == vistaCRUD.texto_id || arg0.getSource() == vistaCRUD.texto_telefono) {
            char c = arg0.getKeyChar();
            if (c < '0' || c > '9') {
                arg0.consume();
            }
        }
        if (arg0.getSource() == vistaCRUD.texto_nombre || arg0.getSource() == vistaCRUD.texto_apellidos || arg0.getSource() == vistaCRUD.texto_localidad) {
            char c = arg0.getKeyChar();
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != (char) KeyEvent.VK_SPACE)) {
                arg0.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent arg0) {

    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        if (arg0.getSource() == vistaCRUD.texto_buscar) {
            String apellidos = vistaCRUD.texto_buscar.getText();
            DefaultTableModel modelo_tabla = new DefaultTableModel();
            vistaCRUD.tabla_datos.setModel(modelo_tabla);
            modelo_tabla.addColumn("ID");
            modelo_tabla.addColumn("Nombre");
            modelo_tabla.addColumn("Apellidos");
            modelo_tabla.addColumn("Dirección");
            modelo_tabla.addColumn("Localidad");
            modelo_tabla.addColumn("Teléfono");

            Object[] columna = new Object[6];

            int num_registros = modeloCRUD.buscar_cliente_por_apellido(apellidos).size();

            for (int i = 0; i < num_registros; i++) {
                columna[0] = modeloCRUD.buscar_cliente_por_apellido(apellidos).get(i).getId();
                columna[1] = modeloCRUD.buscar_cliente_por_apellido(apellidos).get(i).getNombre();
                columna[2] = modeloCRUD.buscar_cliente_por_apellido(apellidos).get(i).getApellidos();
                columna[3] = modeloCRUD.buscar_cliente_por_apellido(apellidos).get(i).getDireccion();
                columna[4] = modeloCRUD.buscar_cliente_por_apellido(apellidos).get(i).getLocalidad();
                columna[5] = modeloCRUD.buscar_cliente_por_apellido(apellidos).get(i).getTelefono();
                modelo_tabla.addRow(columna);
            }

            vistaCRUD.tabla_datos.getColumnModel().getColumn(0).setPreferredWidth(20);
            vistaCRUD.tabla_datos.getColumnModel().getColumn(1).setPreferredWidth(60);
            vistaCRUD.tabla_datos.getColumnModel().getColumn(2).setPreferredWidth(100);
            vistaCRUD.tabla_datos.getColumnModel().getColumn(3).setPreferredWidth(200);
            vistaCRUD.tabla_datos.getColumnModel().getColumn(4).setPreferredWidth(60);
            vistaCRUD.tabla_datos.getColumnModel().getColumn(5).setPreferredWidth(60);
        }
    }

}
