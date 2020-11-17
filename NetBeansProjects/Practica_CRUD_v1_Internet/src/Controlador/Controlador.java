/*
 * PRÁCTICA CRUD
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DISEÑO DE INTERFACES
 * 
 */

 /*EL CONTROLADOR ES EL ENCARGADO DE ENLAZAR EL ACCESO A LOS DATOS CON LA VISTA*/
package Controlador;

import Datos_DAO.ClienteDAO;
import Modelo.Cliente;
import Vista.Ui_Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class Controlador implements ActionListener {
    
    Ui_Frame vistaCRUD = new Ui_Frame();
    ClienteDAO clienteCRUD = new ClienteDAO();

    public Controlador(Ui_Frame vistaCRUD, ClienteDAO clienteCRUD) {
        this.vistaCRUD = vistaCRUD;
        this.clienteCRUD = clienteCRUD;
        this.vistaCRUD.boton_crear_usuario.addActionListener(this);
        
    }

    //llama al DAO para guardar un cliente
    public boolean registrar(Cliente cliente) {
        
        boolean registro = false;
        ClienteDAO dao = new ClienteDAO();
        dao.registrar(cliente);
        
        if (dao.registrar(cliente) == true) {
            JOptionPane.showMessageDialog(null, "Registrado con éxito");
            registro = true;
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario");
        }
 
        return registro;
    }

//    //llama al DAO para actualizar un cliente
//    public boolean actualizar(Cliente cliente) {
//        ClienteDAO dao = new ClienteDAO();
//        dao.actualizar(cliente);
//    }
//
//    //llama al DAO para eliminar un cliente
//    public boolean eliminar(Cliente cliente) {
//        ClienteDAO dao = new ClienteDAO();
//        dao.eliminar(cliente);
//    }
//    
//    //llama al DAO para obtener todos los clientes y luego los muestra en la vista
//    public boolean verClientes() {
//        List<Cliente> lista_clientes = new ArrayList<Cliente>();
//        ClienteDAO dao = new ClienteDAO();
//        lista_clientes=dao.obtener();
//        dao.verClientes(lista_clientes);
//    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistaCRUD.boton_crear_usuario) {
            
        }
    }
}
