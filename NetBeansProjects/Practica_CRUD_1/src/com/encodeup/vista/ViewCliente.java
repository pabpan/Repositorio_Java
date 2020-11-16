/*
 * PRÁCTICA CRUD
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DISEÑO DE INTERFACES
 * 
 */
package com.encodeup.vista;

import java.util.List;
import com.encodeup.model.Cliente;

public class ViewCliente {

    public void verCliente(Cliente cliente) {
        System.out.println("Datos del Cliente: " + cliente);
    }

    public void verClientes(List<Cliente> lista_clientes) {
        for (Cliente cliente : lista_clientes) {
            System.out.println("Datos del Cliente: " + cliente);
        }
    }
}
