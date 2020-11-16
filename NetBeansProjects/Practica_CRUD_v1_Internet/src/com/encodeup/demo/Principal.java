/*
 * PRÁCTICA CRUD
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DISEÑO DE INTERFACES
 * 
 */
package com.encodeup.demo;

import java.sql.SQLException;

public class Principal {

    public static void main(String[] args) throws SQLException {
        
        Ui_Frame nueva_ventana = new Ui_Frame();
        nueva_ventana.setVisible(true);

        //Cliente cliente = new Cliente();

        //CONTROLADOR
        //ControllerCliente controlador = new ControllerCliente();

        //GUARDAR UN CLIENTE A TRAVÉS DEL CONTROLADOR
        //controlador.registrar(cliente);
        
        //ACTUALIZAR UN CLIENTE POR EL ID
        //cliente.setId(11);
        //cliente.setNombre("Pedro");       
        //controlador.actualizar(cliente);
        
        //ELIMINAR UN CLIENTE POR MEDIO DEL ID
        //cliente.setId(10);
        //controlador.eliminar(cliente);

        //VER CLIENTES
        //controlador.verClientes();
    }

}
