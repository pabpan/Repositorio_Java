/*
 * PRÁCTICA 1
 * PABLO SUÁREZ PANTALEÓN
 * 2º DAM - ACCESO A DATOS
 * 
 */
package Capa_Presentacion;

import Capa_Datos.Coches;
import Capa_Datos.Propietarios;
import Capa_Negocio.Consultas_Coches;
import Capa_Negocio.Consultas_Propietarios;
import java.sql.SQLException;
import java.util.*;

public class Principal {

    static int contador_lista_de_coches = 1;
    static int contador_lista_de_propietarios = 1;
    static int contador_lista_de_coches_usuario= 1 ;
    static Scanner teclado = new Scanner(System.in);
        /*Inicializamos las consultas*/
    static Consultas_Coches nueva_consulta_coches = new Consultas_Coches();
    static Consultas_Propietarios nueva_consulta_propietarios = new Consultas_Propietarios();
        /*Creamos una lista de usuarios vacía*/
    static List<Coches> lista_de_coches = null;
    static List<Propietarios> lista_de_propietarios = null;  
    
    
    public static void main(String[] args) throws SQLException{
        
        boolean repetir = true;
        int opcion_menu;
        
        while(repetir) {

            menu(); 
            opcion_menu = teclado.nextInt();

            switch (opcion_menu) {
                case 1:
                    Consultar_Propietario();
                break;
                case 2:
                    Insertar_Propietario();
                break;
                case 3:
                    Borrar_Propietario();
                break;
                case 4:
                    Modificar_propietario();
                break;
                case 5:
                    Listar_Datos_Propietario();
                break;
                case 6:
                    Borrar_Propietario_Y_Coches();
                break;
                case 7:
                    Consultar_coches();
                break;
                case 8:
                    Insertar_Coche();
                break;
                case 9:
                    Borar_Coche();
                break;
                case 10:
                    Modificar_coche();
                break; 
                case 11:
                    repetir = false;
                    System.out.println("¡ADIÓS!");
                break; 
                default:
                    System.out.println("¡Introduce una opción válida!");                    
                 break;
            }
        }
    }
    
    public static void menu() {
        
        System.out.println("************************************\n"
                + "*Bienvenido a nuestro concesionario*\n"
                + "************************************\n"
                + "Menu Propietarios\n"
                + "-----1.- Consultar la lista de propietarios\n"
                + "-----2.- Insertar propietario\n"
                + "-----3.- Borrar propietario\n"
                + "-----4.- Modificar propietario\n"
                + "-----5.- Listar datos y coches de un propietario (por DNI)\n"
                + "-----6.- Borrar un propietario y sus coches\n"
                + "Menu Coches\n"
                + "-----7.- Consultar la lista de coches\n"
                + "-----8.- Insertar coche\n"
                + "-----9.- Borrar coche\n"
                + "-----10.- Modificar coche\n"
                + "-----11.- SALIR\n"
                + "************************************\n"
                + "Introduce una opcion: ");
        
    }
    
    public static void Consultar_Propietario() throws SQLException {
        
        /*Asignamos a la lista la consulta*/
        lista_de_propietarios = nueva_consulta_propietarios.seleccionar();           
        System.out.println("*****************************************************************************");
        /*Recorremos las lista de propietarios e imprimimos por pantalla*/
        lista_de_propietarios.forEach(propietario_consultado -> {
            System.out.println("Propietario " + contador_lista_de_propietarios +" = " + propietario_consultado);
            contador_lista_de_propietarios++;
        });
        System.out.println("*****************************************************************************");            
        contador_lista_de_propietarios=1;
    }
    public static void Insertar_Propietario(){
        
        System.out.println("Introduce el DNI: ");
        String dni = teclado.nextLine();
        System.out.println("Introduce el nombre:");
        String nombre = teclado.nextLine();
        System.out.println("Introduce la edad:");
        int edad = teclado.nextInt();       
        teclado.nextLine();
        
        Propietarios propietario_nuevo = new Propietarios(dni, nombre, edad);
        nueva_consulta_propietarios.insertar(propietario_nuevo);
        System.out.println("\n**********************************");
        System.out.println("*¡Nuevo propietario dado de alta!*");
        System.out.println("**********************************\n");        
    }
    public static void Borrar_Propietario(){
        
        System.out.println("Introduce el DNI del propietario a borrar: ");
        String dni = teclado.nextLine();
        
        Propietarios borrar_propietario = new Propietarios(dni);
        nueva_consulta_propietarios.delete(borrar_propietario);
        System.out.println("\n*************************************");
        System.out.println("*¡Propietario borrado correctamente!*");
        System.out.println("*************************************1\n");          
    }
    public static void Modificar_propietario(){
        
        System.out.println("Introduce el DNI del propietario a modificar: ");
        String dni = teclado.nextLine();
        System.out.println("Introduce el nuevo nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Introduce la edad: ");
        int edad = teclado.nextInt();
        Propietarios modificar_propietario = new Propietarios(dni, nombre, edad);
        nueva_consulta_propietarios.update(modificar_propietario);
        System.out.println("\n************************************");
        System.out.println("*¡Usuario modificado correctamente!*");
        System.out.println("************************************\n");              
    
    }
    public static void Listar_Datos_Propietario() throws SQLException{
        
        System.out.println("Escribe el DNI para listar datos y coches asociados a un propietario: ");
        String  dni = teclado.nextLine();
        
        lista_de_coches = nueva_consulta_coches.seleccionar_por_usuario();
        /*Recorremos las lista de usuarios e imprimimos por pantalla*/
        lista_de_coches.forEach(coche_consultado -> {
            System.out.println("Coche" + contador_lista_de_coches_usuario +" = " + coche_consultado);
            contador_lista_de_coches_usuario++;
        });   
        
    }
    public static void Borrar_Propietario_Y_Coches(){
        
        System.out.println("Introduce el DNI del propietario a borrar junto con sus coches: ");
        String dni = teclado.nextLine();

        Coches borrar_coche = new Coches(dni);
        Propietarios borrar_propietario = new Propietarios(dni);
        nueva_consulta_coches.delete_coches_por_dni(borrar_coche);
        nueva_consulta_propietarios.delete(borrar_propietario);
        System.out.println("\n***********************************************");
        System.out.println("*¡Propietario y coches borrados correctamente!*");
        System.out.println("***********************************************\n");   
    }
    public static void Consultar_coches() throws SQLException {
        
        /*Asignamos a la lista la consulta*/
        lista_de_coches = nueva_consulta_coches.seleccionar();           
        /*Recorremos las lista de usuarios e imprimimos por pantalla*/
        lista_de_coches.forEach(coche_consultado -> {
            System.out.println("Coche " + contador_lista_de_coches +" = " + coche_consultado);
            contador_lista_de_coches++;
        });   
        contador_lista_de_coches=1;
    }
    public static void Insertar_Coche() {
               
        System.out.println("Introduce la matrícula: ");
        String matricula = teclado.nextLine();
        System.out.println("Introduce la Marca:");
        String marca = teclado.nextLine();
        System.out.println("Introduce el precio:");
        int precio = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Introduce el DNI del propietario:");
        String dni = teclado.nextLine();        
        Coches coche_nuevo = new Coches(matricula, marca, precio, dni);
        nueva_consulta_coches.insertar(coche_nuevo);  
        System.out.println("\n****************************");
        System.out.println("*¡Nuevo coche dado de alta!*");
        System.out.println("****************************\n");      
    }
    public static void Borar_Coche(){
        System.out.println("Introduce la matrícula del coche a borrar:");
        String matricula = teclado.nextLine();
        //recorrer coches a ver si existe
        Coches borrar_coche = new Coches(matricula);
        for (int i = 0; i < lista_de_coches.size(); i++) {
            if (lista_de_coches.get(i).getMatricula().equals(borrar_coche.getMatricula())) {
                nueva_consulta_coches.delete(borrar_coche);
                System.out.println("El coche ha sido borrado.");
            } else {
                System.out.println("El coche con matrícula" + matricula + " no existe.");
            }
        break;    
        }        
    }
    public static void Modificar_coche(){
        
        System.out.println("Introduce la matrícula del coche a modificar: ");
        String matricula = teclado.nextLine();
        System.out.println("Introduce la Marca:");
        String nueva_marca = teclado.nextLine();
        System.out.println("Introduce el precio:");
        int nuevo_precio = teclado.nextInt();        
        Coches modificar_coche = new Coches(matricula, nueva_marca, nuevo_precio);
        nueva_consulta_coches.update(modificar_coche);                
        System.out.println("\n********************************");
        System.out.println("*¡El coche ha sido actualizado!*");
        System.out.println("********************************7\n");
    }
}