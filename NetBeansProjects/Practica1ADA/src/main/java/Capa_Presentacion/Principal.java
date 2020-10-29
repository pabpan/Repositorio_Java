/*
 * PRÁCTICA 1
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - ACCESO A DATOS
 * 
 */
package Capa_Presentacion;

import Capa_Datos.Usuario;
import Capa_Negocio.Consultas;
import java.sql.*;
import java.util.*;

public class Principal {

    static int contador_lista_de_usuarios = 1;
    
    public static void main(String[] args) throws SQLException {

        /*Inicializamos las consultas*/
        Consultas nueva_consulta = new Consultas();
        /*Creamos una lista de usuarios vacía*/
        List<Usuario> lista_de_usuarios = null;
               
        /************************************/
        /************* INSERTAR *************/
        /************************************/
    
        /*Agregamos nuevo usuario a la base de datos*/
//        Usuario nuevo_usuario = new Usuario(6, "carhid", "123456");
//        nueva_consulta.insertar(nuevo_usuario);   
        
        /************************************/
        /************ ACTUALIZAR ***********/
        /************************************/
        
//        Usuario modificar_usuario = new Usuario(6, "carhid", "000000");
//        nueva_consulta.update(modificar_usuario);
        
        /************************************/
        /************** BORRAR **************/
        /************************************/
        
        Usuario borrar_usuario = new Usuario(6);
        nueva_consulta.delete(borrar_usuario);
        
        /************************************/
        /************ SELECCIONAR ***********/
        /************************************/
                
        /*Asignamos a la lista la consulta*/
        lista_de_usuarios = nueva_consulta.seleccionar();
        
        
        /*Recorremos las lista de usuarios e imprimimos por pantalla*/
        lista_de_usuarios.forEach(usuario_consultado -> {
            System.out.println("Usuario" + contador_lista_de_usuarios +" = " + usuario_consultado);
            contador_lista_de_usuarios++;
        });
    }
}
