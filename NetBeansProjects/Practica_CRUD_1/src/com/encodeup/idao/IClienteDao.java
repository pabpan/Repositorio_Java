/*
 * PRÁCTICA CRUD
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DISEÑO DE INTERFACES
 * 
 */
package com.encodeup.idao;

import java.util.List;
import com.encodeup.model.Cliente;

public interface IClienteDao {

    public boolean registrar(Cliente cliente);

    public List<Cliente> obtener();

    public boolean actualizar(Cliente cliente);

    public boolean eliminar(Cliente cliente);

}
