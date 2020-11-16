/*
 * PRÁCTICA CRUD
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DISEÑO DE INTERFACES
 * 
 */

 /*EL CONTROLADOR ES EL ENCARGADO DE ENLAZAR EL ACCESO A LOS DATOS CON LA VISTA*/
package com.encodeup.controller;

import java.util.List;
import java.util.ArrayList;

import com.encodeup.dao.ClienteDaoImpl;
import com.encodeup.idao.IClienteDao;
import com.encodeup.model.Cliente;
import com.encodeup.vista.ViewCliente;

public class ControllerCliente {

    private ViewCliente vista = new ViewCliente();

    public ControllerCliente() {
    }

    //llama al DAO para guardar un cliente
    public void registrar(Cliente cliente) {
        IClienteDao dao = new ClienteDaoImpl();
        dao.registrar(cliente);
    }

    //llama al DAO para actualizar un cliente
    public void actualizar(Cliente cliente) {
        IClienteDao dao = new ClienteDaoImpl();
        dao.actualizar(cliente);
    }

    //llama al DAO para eliminar un cliente
    public void eliminar(Cliente cliente) {
        IClienteDao dao = new ClienteDaoImpl();
        dao.eliminar(cliente);
    }
    
    //llama al DAO para obtener todos los clientes y luego los muestra en la vista
    public void verClientes() {
        List<Cliente> lista_clientes = new ArrayList<Cliente>();
        IClienteDao dao = new ClienteDaoImpl();
        lista_clientes=dao.obtener();
        vista.verClientes(lista_clientes);
    }
}
