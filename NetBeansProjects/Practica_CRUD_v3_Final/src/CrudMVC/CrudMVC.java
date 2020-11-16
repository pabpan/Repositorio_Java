/*
 * PRÁCTICA CRUD
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - DISEÑO DE INTERFACES
 * 
 */
package CrudMVC;

import Modelo.*;
import Vista.*;
import Controlador.*;

public class CrudMVC {
    
    public static void main(String[] args) {
        
        VistaClientes vista = new VistaClientes();
        DAOCliente modelo = new DAOCliente();
        ControladorCRUD controlador = new ControladorCRUD(vista, modelo);
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
    
}
