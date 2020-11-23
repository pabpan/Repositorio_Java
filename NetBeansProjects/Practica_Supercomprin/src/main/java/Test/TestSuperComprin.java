/**
 * @autor ---------> Pablo Suárez
 * @curso ---------> 2DAM
 * @descripción ---> SUPERCOMPRÍN
 */
package Test;

import Conexion.Conexion;
import Datos.*;
import Domain.*;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TestSuperComprin {
    
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws SQLException, ParseException {  
        
        boolean repetir = true;
        int opcion_menu;

        while (repetir) {

            menu();
            opcion_menu = teclado.nextInt();
            teclado.nextLine();

            switch (opcion_menu) {
                case 1:
                    Fidelizar_Cliente();
                    break;
                case 2:
                    Recargar_Saldo_en_Wallet();
                    break;
                case 3:
                    Consultar_Wallets();
                    break;                    
                case 4:
                    Insertar_Productos();
                    break;
                case 5:
                    Consultar_Productos();
                    break;
                case 6:
                    Realizar_Compra();
                    break;
                case 7:
                    Consultar_Compras();
                    break;                    
                case 8:
                    Pagar_Compra();
                    break;
                case 9:
                    Realizar_Devolucion();
                    break;  
                case 10:
                    Consultar_Devoluciones();
                    break; 
                case 11:
                    Consultar_Devoluciones();
                    break;                     
                case 12:
                    repetir = false;
                    System.out.println("¡SALIENDO DEL PROGRAMA!");
                    break;
                default:
                    System.out.println("¡INTRODUCE UNA OPCIÓN VÁLIDA!");
                    break;
            }
        }
    }
    
    ///////////////
    ////MÉTODOS////
    ///////////////

    public static void menu() {

        System.out.println("\n"
                + "***************************************\n"
                + "********** MENÚ SUPERCOMPRÍN **********\n"
                + "***************************************\n"
                + "********** ¿Qué desea hacer? **********\n"
                + "***************************************\n"                
                + "*** 1  Fidelizar un cliente         ***\n"
                + "*** 2  Recargar saldo en Wallet     ***\n"
                + "*** 3  Consultar Wallets            ***\n"
                + "*** 4  Insertar productos           ***\n"                
                + "*** 5  Consultar productos          ***\n"
                + "*** 6  Realizar compra              ***\n" 
                + "*** 7  Consultar compras            ***\n"                 
                + "*** 8  Pagar una compra             ***\n"  
                + "*** 9  Realizar_Devolucion          ***\n"  
                + "*** 10 Consultar devoluciones       ***\n"
                + "*** 11 Canjear puntos por productos ***\n" 
                + "*** 12 Salir del programa           ***\n"
                + "***************************************\n"                
                + "Introduce una opcion: ");
    } //FUNCIONA BIEN
    
    public static void Fidelizar_Cliente() throws SQLException, ParseException, MysqlDataTruncation {
        
        Connection conexion = null;
        try {
            conexion = Conexion.getConexion();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            //Ahora proporcionamos el objeto conexión para poder aplicar el concepto de transacción
            WalletDAO wallet = new WalletDAO(conexion);
            System.out.println("Introduzca su nombre: ");
            String nombre = teclado.nextLine();
            System.out.println("Introduzca sus apellidos: ");
            String apellidos = teclado.nextLine();
            System.out.println("Introduzca su DNI: ");
            String DNI = teclado.nextLine();

            //CUANDO PEDIMOS LA FECHA DE NACIMIENTO LA LEEMOS CON JAVA.UTIL.DATE, HAY QUE TRANSFORMARLA A JAVA.SQL.DATE
            System.out.println("Introduzca su fecha_nacimiento (FORMATO: 'yyyy-MM-dd'");
            String fecha_nacimiento_s = teclado.nextLine();
            
            //COMPROBAMOS QUE LA EDAD ES MAYOR A 18 AÑOS
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaNac = LocalDate.parse(fecha_nacimiento_s, fmt);
            LocalDate ahora = LocalDate.now();
            Period periodo = Period.between(fechaNac, ahora);
            if (periodo.getYears() < 18) {
                System.out.println("***************************************");
                System.out.printf("Tu edad es: %s años, %s meses y %s días\n", periodo.getYears(), periodo.getMonths(), periodo.getDays());
                System.out.println("Lo siento, NO eres mayor de edad y NO puedes registrarte en Supercomprín");
                System.out.println("***************************************");
                return;
            } 
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha_nacimiento = sdf.parse(fecha_nacimiento_s);
            java.sql.Date fecha_sql = new java.sql.Date (fecha_nacimiento.getDay(),fecha_nacimiento.getMonth(),fecha_nacimiento.getYear());

            //CONTINUAMOS SOLICITANDO DATOS
            System.out.println("Introduzca su email: ");
            String email = teclado.nextLine();
            Wallet nueva_wallet = new Wallet(nombre, apellidos, DNI, fecha_sql, email, 0, 0);
            wallet.insertarWallet(nueva_wallet);
            conexion.commit();
            System.out.println("***************************************");
            System.out.println("Relizando commit... ¡Se ha creado una wallet nueva para el usuario " + nueva_wallet.getNombre() + nueva_wallet.getApellidos());
            System.out.println("***************************************");
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("***************************************");            
            System.out.println("Ha habido un problema, se entra al 'ROLLBACK'");
            System.out.println("***************************************");            
            try {
                conexion.rollback();
                return;
            } catch (SQLException ex1) {
                    ex1.printStackTrace(System.out);
            }
        }
    } //FUNCIONA BIEN
    
    public static void Recargar_Saldo_en_Wallet() {
       
        int recargas=0;
        java.util.Date fecha_actual = new java.util.Date();
        if (fecha_actual.getDate() > 1 && fecha_actual.getDate() < 5) {
            
            Connection conexion = null;
            try {
                conexion = Conexion.getConexion();
                if (conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false);
                }
                //Ahora proporcionamos el objeto conexión para poder aplicar el concepto de transacción
                WalletDAO wallet = new WalletDAO(conexion);
                List <Wallet> lista_wallets = wallet.seleccionarWallet();  
                System.out.println("Estos son los Walets disponibles");
                System.out.println("***************************************");                
                for (int i = 0; i < lista_wallets.size(); i++) {
                    System.out.println(lista_wallets.get(i));
                    System.out.println("***************************************");
                }  
                System.out.println("¿En qué Wallet quieres recargar saldo?");
                int id_recarga = teclado.nextInt();
                teclado.nextLine();
                System.out.println("¿Qué cantidad quiere recargar?");
                int cantidad = teclado.nextInt();
                teclado.nextLine();
                Wallet aux = lista_wallets.get(id_recarga);
                aux.setSaldo_euros(cantidad);
                wallet.actualizarWallet(aux);            
                conexion.commit();
                System.out.println("***************************************");
                System.out.println("Relizando commit... ¡Se han ingresado " + cantidad + "€ en la wallet de" +aux.getNombre());
                System.out.println("***************************************");

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                System.out.println("***************************************");            
                System.out.println("Ha habido un problema, se entra al 'ROLLBACK'");
                System.out.println("***************************************"); 
            try {
                    conexion.rollback();
                    return;
                } catch (SQLException ex1) {
                        ex1.printStackTrace(System.out);
                }
            }
            recargas++;
        } else {
            System.out.println("***************************************"); 
            System.out.println("Lo siento, los días de recarga son entre el 1 y el 5 de cada mes");
            System.out.println("***************************************"); 

        }       
    } //FUNCIONA BIEN
    
    public static void Consultar_Wallets() {
       
        Connection conexion = null;
            try {
                conexion = Conexion.getConexion();
                if (conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false);
                }
                //Ahora proporcionamos el objeto conexión para poder aplicar el concepto de transacción
                WalletDAO wallet = new WalletDAO(conexion);
                List <Wallet> lista_wallets = wallet.seleccionarWallet();
                for (int i = 0; i < lista_wallets.size(); i++) {
                    System.out.println(lista_wallets.get(i));
                    System.out.println("***************************************");
                }          
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                System.out.println("***************************************");                
                System.out.println("Ha habido un problema, se entra al 'ROLLBACK'");
                System.out.println("***************************************");
                
                try {
                    conexion.rollback();
                    return;
                } catch (SQLException ex1) {
                        ex1.printStackTrace(System.out);
            }
        }                 
    } //FUNCIONA BIEN
       
    public static void Insertar_Productos() {
       
        Connection conexion = null;
            try {
                conexion = Conexion.getConexion();
                if (conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false);
                }
                //Ahora proporcionamos el objeto conexión para poder aplicar el concepto de transacción
                ProductoDAO producto = new ProductoDAO(conexion);
                List <Producto> lista_productos = producto.seleccionarProducto();
                
                System.out.println("Introduce el nombre del producto");
                String nombre = teclado.nextLine();
                System.out.println("Introduce el precio del producto");
                int precio = teclado.nextInt();
                System.out.println("¿Cuántos puntos vale?");
                int puntos = teclado.nextInt();
                Producto aux = new Producto(nombre, precio, puntos);
                lista_productos.add(aux);
                producto.insertarProducto(aux);
                conexion.commit();
                System.out.println("***************************************");
                System.out.println("Relizando commit... ¡Se ha añadido " + nombre+ " a la lista de productos");
                System.out.println("***************************************");
                for (int i = 0; i < lista_productos.size(); i++) {
                    System.out.println("La lista de productos ha quedado así: \n");
                    System.out.println(lista_productos.get(i));
                    System.out.println("***************************************");
                } 
                
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                System.out.println("Ha habido un problema, se entra al 'ROLLBACK'");
                try {
                    conexion.rollback();
                    return;
                } catch (SQLException ex1) {
                        ex1.printStackTrace(System.out);
            }
        }                 
    } //FUNCIONA BIEN
    
    public static void Consultar_Productos() {
       
        Connection conexion = null;
            try {
                conexion = Conexion.getConexion();
                if (conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false);
                }
                //Ahora proporcionamos el objeto conexión para poder aplicar el concepto de transacción
                ProductoDAO producto = new ProductoDAO(conexion);
                List <Producto> lista_productos = producto.seleccionarProducto();
                for (int i = 0; i < lista_productos.size(); i++) {
                    System.out.println(lista_productos.get(i));
                    System.out.println("*************************");
                }
                //System.out.println(lista_productos.toString());                     
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                System.out.println("***************************************");                
                System.out.println("Ha habido un problema, se entra al 'ROLLBACK'");
                System.out.println("***************************************");
                try {
                    conexion.rollback();
                    return;
                } catch (SQLException ex1) {
                        ex1.printStackTrace(System.out);
            }
        }                 
    } //FUNCIONA BIEN
 
    public static void Realizar_Compra() throws ParseException {
       
        Connection conexion = null;
            try {
                conexion = Conexion.getConexion();
                if (conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false);
                }
                //Ahora proporcionamos el objeto conexión para poder aplicar el concepto de transacción
                CompraDAO compra = new CompraDAO(conexion);
                ProductoDAO producto = new ProductoDAO(conexion);
                WalletDAO wallet = new WalletDAO(conexion);

                //IMPRIMIMOS LAS WALLETS PARA QUE EL USUARIO SEPA INTERACTUAR
                List <Wallet> lista_wallets = wallet.seleccionarWallet();  
                System.out.println("Estos son los Walets disponibles\n");
                for (int i = 0; i < lista_wallets.size(); i++) {
                    System.out.println(lista_wallets.get(i));
                    System.out.println("***************************************");
                }                 
                //IMPRIMIOS LOS PRODUCTOS PARA QUE EL USUARIO SEPA INTERACTUAR
                List <Producto> lista_productos = producto.seleccionarProducto();
                System.out.println("Estos son los Productos disponibles\n");
                for (int i = 0; i < lista_productos.size(); i++) {
                    System.out.println(lista_productos.get(i));
                    System.out.println("*************************");
                }
                
                //SOLICTAMOS ID'S AL USUARIO
                System.out.println("\nIntroduce el ID de la wallet");
                int id_wallet = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Introduce el ID del producto que quiere comprar");
                int id_producto = teclado.nextInt();
                teclado.nextLine();                  
                System.out.println("Introduzca la fecha de la compra (FORMATO: 'yyyy-MM-dd')");
                String fecha_compra = teclado.nextLine();

                //CUANDO PEDIMOS LA FECHA DE COMPRA LA LEEMOS CON JAVA.UTIL.DATE, HAY QUE TRANSFORMARLA A JAVA.SQL.DATE
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha_sql_1 = sdf.parse(fecha_compra);
                java.sql.Date fecha_sql_parse = new java.sql.Date (fecha_sql_1.getDay(),fecha_sql_1.getMonth(),fecha_sql_1.getYear());

                
                Compra nueva_compra = new Compra(id_wallet, id_producto, fecha_sql_parse);
                compra.insertarCompra(nueva_compra);
                conexion.commit();                
                System.out.println("***************************************");
                System.out.println("La compra ha sido realizada correctamente, pase por caja a pagar"); 
                System.out.println("***************************************");
                System.out.println("***************************************");
                System.out.println("Relizando commit... La compra ha sido realizada correctamente, pase por caja a pagar"); 
                System.out.println("***************************************");                               
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                System.out.println("***************************************");                
                System.out.println("Ha habido un problema, se entra al 'ROLLBACK'");
                System.out.println("***************************************");
                try {
                    conexion.rollback();
                    return;
                } catch (SQLException ex1) {
                        ex1.printStackTrace(System.out);
            }
        }                 
    } 

    public static void Pagar_Compra() {
       
        Connection conexion = null;
            try {
                conexion = Conexion.getConexion();
                if (conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false);
                }
                //Ahora proporcionamos el objeto conexión para poder aplicar el concepto de transacción
                CompraDAO compra = new CompraDAO(conexion);
                WalletDAO wallet = new WalletDAO(conexion);
                ProductoDAO producto = new ProductoDAO(conexion);
                
                List <Compra> lista_compras = compra.seleccionarCompra();
                List <Wallet> lista_Wallets = wallet.seleccionarWallet();
                List <Producto> lista_productos = producto.seleccionarProducto();
                
                for (int i = 0; i < lista_compras.size(); i++) {
                    System.out.println("Estas son las compras disponibles: ");
                    System.out.println("["+i+"]" + lista_compras.get(i));
                    System.out.println("***************************************");
                } 
                
                System.out.println("¿Qué número de compra quiere pagar?");
                int id_introducido = teclado.nextInt();
                teclado.nextLine();

                //CREO UNA COMPRA AUXILIAR Y GUARDO LOS DATOS QUE ME DICE EL USUARIO
                Compra aux = lista_compras.get(id_introducido);
                System.out.println(aux);
//                int id_producto_aux = aux.getId_producto();
//                int id_wallet_aux = aux.getId_wallet();
//                System.out.println(id_producto_aux);
//                System.out.println(id_wallet_aux);
                //BORRO LA CUENTA QUE ME INDICA EL USUARIO
                //compra.borrarCompra(aux);
                
                //CREO UN PRODUCTO AUXILIAR Y LE PASO LOS DATOS DEL PRODUCTO ASOCIADO A LA COMPRA
                Producto aux1 = lista_productos.get(aux.getId_producto()-1);
                System.out.println(aux1);

                
                //CREO UNA WALLET AUXILIAR Y LE PASO LOS DATOS DE LA WALLET ASOCIADO A LA COMPRA            
                Wallet aux2 = lista_Wallets.get(aux.getId_producto()-1);
                System.out.println(aux2.toString());

                //SUMAR PUNTOS A SU EWALLET
                
                //VALOR DEL DE LOS PUNTOS DEL PRODUCTO
                
                //DESCONTAR IMPORTE DE LA COMPRA DE SU SALDO EN EUROS
                
                //SI EL CLIENTE NO TIENE DINERO SUFICIENTE EN SU EWALLET NO PUEDE LLEVARSE LA COMPRA

//                if (aux.getId_wallet() == lista_compras.get(id_compra).getId_wallet()) {   
                    
//                    //SI NO DISPONE DE SALDO SUFICIENTE N OPUEDE LLEVARSE EL PRODUCTO
//                    if (aux.getSaldo_euros() < aux1.getPrecio()){
//                        System.out.println("No dispone de saldo para poder comprar el producto");
//                      //SINO SE LE RESTARÁ EL IMPORTE DEL PRODUCTO Y SE LE SUMARÁN LOS PUNTOS DEL PRODUCTO
//                    } else {
//                        aux.setSaldo_euros(aux.getSaldo_euros()- aux1.getPrecio());
//                        aux.setSaldo_puntos(aux.getSaldo_puntos() + aux1.getPuntos());
//                        wallet.actualizarWallet(aux);   
//                    }
//                }                
                
//                System.out.println("Se ha actualizado correctamente el saldo"); 
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                System.out.println("Ha habido un problema, se entra al 'ROLLBACK'");
                try {
                    conexion.rollback();
                    return;
                } catch (SQLException ex1) {
                        ex1.printStackTrace(System.out);
            }
        }                 
    } //NO FUNCIONA BIEN
    
    public static void Consultar_Compras() {
       
        Connection conexion = null;
            try {
                conexion = Conexion.getConexion();
                if (conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false);
                }
                //Ahora proporcionamos el objeto conexión para poder aplicar el concepto de transacción
                CompraDAO compra = new CompraDAO(conexion);
                List <Compra> lista_compras = compra.seleccionarCompra();
                for (int i = 0; i < lista_compras.size(); i++) {
                    System.out.println(lista_compras.get(i));
                    System.out.println("*************************");
                }            } 
            catch (SQLException ex) {
                ex.printStackTrace(System.out);
                System.out.println("***************************************");                
                System.out.println("Ha habido un problema, se entra al 'ROLLBACK'");
                System.out.println("***************************************");
                try {
                    conexion.rollback();
                    return;
                } catch (SQLException ex1) {
                        ex1.printStackTrace(System.out);
            }
        }                 
    } //FUNCIONA BIEN
    
    public static void Realizar_Devolucion() throws ParseException {
       
        Connection conexion = null;
            try {
                conexion = Conexion.getConexion();
                if (conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false);
                }
                //Ahora proporcionamos el objeto conexión para poder aplicar el concepto de transacción
                CompraDAO compra = new CompraDAO(conexion);
                ProductoDAO producto = new ProductoDAO(conexion);
                WalletDAO wallet = new WalletDAO(conexion);
                DevolucionDAO devolucion = new DevolucionDAO(conexion);

                //IMPRIMIOS LOS PRODUCTOS
                List <Producto> lista_productos = producto.seleccionarProducto();
                System.out.println("Estos son los Productos disponibles");
                System.out.println(lista_productos.toString()); 
                
                //IMPRIMIMOS LAS WALLETS
                List <Wallet> lista_wallets = wallet.seleccionarWallet();  
                System.out.println("Estos son los Walets disponibles");
                System.out.println(lista_wallets.toString());
                
                //IMPRIMIMOS LAS COMPRAS
                List <Compra> lista_compras = compra.seleccionarCompra();  
                System.out.println("Estos son las Compras disponibles");
                System.out.println(lista_compras.toString());                
                
                //SOLICTAMOS ID'S AL USUARIO
                System.out.println("¿Qué compra desea devolver?");
                int id_devolucion = teclado.nextInt();
                teclado.nextLine();                
        
                //PROCEDEMOS A DEVOLVER LA COMPRA
                Compra aux = lista_compras.get(id_devolucion);
                Producto aux1 = lista_productos.get(aux.getId_producto()-1);
                Wallet aux2 = lista_wallets.get(aux1.getId_producto()-1);
    
                if (aux.getId_producto() == lista_productos.get(aux.getId_producto()-1).getId_producto()) {   

                    //SE DEVUELVE EL PRECIO DEL PRODUCTO Y LOS PUNTOS A LA CARTERA DEL USUARIO
                    aux2.setSaldo_euros(aux2.getSaldo_euros() + aux1.getPrecio());
                    aux2.setSaldo_puntos(aux2.getSaldo_puntos() + aux1.getPuntos());
                    //SI NO DISPONE DE SALDO MAYOR A 5 EUROS TRAS ESA DEVOLUCIÓN SE INFORMA, SINO SE GRABA LA OPERACIÓN Y SE ACTUALIZA LA WALLET Y S ELIMINA LA COMPRA
                    if (aux2.getSaldo_euros() < 5) {
                        System.out.println("SU SALDO ES INFERIOR A 5 EUROS, NO SE PUEDE DEVOLVER");
                    } else {
                        wallet.actualizarWallet(aux2);
                        compra.borrarCompra(aux);
                        
                        //PROBLEMA DE LA FECHA ACTUAL EN JAVA Y SQL                        
                        java.sql.Date fecha_sql = new java.sql.Date(1980/25/02);
                        
                        Devolucion aux3 = new Devolucion(aux2.getId_wallet(), aux1.getId_producto(), fecha_sql);
                        devolucion.insertarDevolucion(aux3);
                    }
                }  
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                System.out.println("Ha habido un problema, se entra al 'ROLLBACK'");
                try {
                    conexion.rollback();
                    return;
                } catch (SQLException ex1) {
                        ex1.printStackTrace(System.out);
            }
        }                 
    } //NO FUNCIONA BIEN   
    
    public static void Consultar_Devoluciones() {
       
        Connection conexion = null;
            try {
                conexion = Conexion.getConexion();
                if (conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false);
                }
                //Ahora proporcionamos el objeto conexión para poder aplicar el concepto de transacción
                DevolucionDAO devolucion = new DevolucionDAO(conexion);
                List <Devolucion> lista_devoluciones = devolucion.seleccionarDevolucion();
                for (int i = 0; i < lista_devoluciones.size(); i++) {
                    System.out.println(lista_devoluciones.get(i));
                System.out.println("***************************************");                
                }                 
                if (lista_devoluciones.isEmpty()) {
                    System.out.println("***************************************");                                    
                    System.out.println("NO HAY DEVOLUCIONES REGISTRADAS EN LA BASE DE DATOS");
                    System.out.println("***************************************");                
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                System.out.println("***************************************");                
                System.out.println("Ha habido un problema, se entra al 'ROLLBACK'");
                System.out.println("***************************************");                try {
                    conexion.rollback();
                    return;
                } catch (SQLException ex1) {
                        ex1.printStackTrace(System.out);
            }
        }                 
    } //FUNCIONA BIEN  

    public static void Canjear_Puntos() throws ParseException {
       
        Connection conexion = null;
            try {
                conexion = Conexion.getConexion();
                if (conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false);
                }
                //Ahora proporcionamos el objeto conexión para poder aplicar el concepto de transacción
                CompraDAO compra = new CompraDAO(conexion);
                ProductoDAO producto = new ProductoDAO(conexion);
                WalletDAO wallet = new WalletDAO(conexion);

                //IMPRIMIOS LOS PRODUCTOS
                List <Producto> lista_productos = producto.seleccionarProducto();
                System.out.println("Estos son los Productos disponibles");
                System.out.println(lista_productos.toString()); 
                
                //IMPRIMIMOS LAS WALLETS
                List <Wallet> lista_wallets = wallet.seleccionarWallet();  
                System.out.println("Estos son los Walets disponibles");
                System.out.println(lista_wallets.toString());
                
                //SOLICTAMOS ID'S AL USUARIO
                System.out.println("Introduce el ID de la Wallet que va a comprar");
                int id_wallet = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Introduce el ID del producto que va a comprar");
                int id_producto = teclado.nextInt();
                teclado.nextLine();
                  
                System.out.println("Introduzca la fecha de la compra (IMPORTANTE: 'AÑO/MES/DÍA'");
                String fecha_introducida = teclado.nextLine();
                
                
                //PROBLEMA DE LA FECHA ACTUAL EN JAVA Y SQL
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date fecha_java = sdf.parse(fecha_introducida);
                java.sql.Date fecha_sql = new java.sql.Date(fecha_java.getTime());
                
                //COMPROBAMOMS QUE EL CLIENTE TENGA SUFICIENTES PUNTOS
                if (lista_wallets.get(id_wallet).getSaldo_puntos() >= lista_productos.get(id_producto).getPuntos()) {
                    System.out.println("Tiene puntos suficientes para pagar el producto con puntos");
                    System.out.println("¿Quiere pagar con puntos el producto? SI|NO");
                    String respuesta = teclado.nextLine();
                    //SI QUIER PAGAR CON PUNTOS CREAMOS LA COMPRA Y A LA WALLET USUARIO LE RESTAMOS LOS PUNTOS QUE VALE PRODUCTO
                    if (respuesta.equals("SI")) {
                        Compra nueva_compra = new Compra(id_wallet, id_producto, fecha_sql);
                        compra.insertarCompra(nueva_compra);
                        lista_wallets.get(id_wallet).setSaldo_puntos(lista_wallets.get(id_wallet).getSaldo_puntos() - lista_productos.get(id_producto).getPuntos());
                    } else {
                        Compra nueva_compra = new Compra(id_wallet, id_producto, fecha_sql);
                        compra.insertarCompra(nueva_compra);
                        System.out.println("La compra ha sido realizada correctamente, pase por caja a pagar"); 
                    }
                }                

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                System.out.println("Ha habido un problema, se entra al 'ROLLBACK'");
                try {
                    conexion.rollback();
                    return;
                } catch (SQLException ex1) {
                        ex1.printStackTrace(System.out);
            }
        }                 
    } //NO FUNCIONA BIEN  
}
