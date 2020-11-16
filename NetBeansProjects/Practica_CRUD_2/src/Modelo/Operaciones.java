/*
 * PRÁCTICA CRUD
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DISEÑO DE INTERFACES
 * 
 */
package Modelo;

import java.util.ArrayList;

public interface Operaciones {

    public boolean insertar(Object objeto);

    public boolean eliminar(Object objeto);

    public boolean actualizar(Object objeto);

    public ArrayList<Object[]> consultar();
}
