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
                    Borrar_Producto();
                    break;                    
                case 6:
                    Consultar_Productos();
                    break;
                case 7:
                    Realizar_Compra();
                    break;
                case 8:
                    Consultar_Compras();
                    break;                    
                case 9:
                    Realizar_Devolucion();
                    break;  
                case 10:
                    Consultar_Devoluciones();
                    break; 
                case 11:
                    Canjear_Puntos();
                    break;                     
                case 12:
                    repetir = false;
                    System.out.println("¡SALIENDO DEL PROGRAMA... HASTA LA PRÓXIMA!");
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
                + "*** 5  Borrar producto              ***\n"                                
                + "*** 6  Consultar productos          ***\n"
                + "*** 7  Realizar compra              ***\n" 
                + "*** 8  Consultar compras            ***\n"                 
                + "*** 9  Realizar_Devolucion          ***\n"  
                + "*** 10  Consultar devoluciones       ***\n"
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
            System.out.println("Introduzca su fecha de nacimiento (FORMATO: 'yyyy-MM-dd'");
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
            System.out.println("Relizando commit... ¡Se ha creado una wallet nueva para el usuario " + nueva_wallet.getNombre() + " " + nueva_wallet.getApellidos());
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
                for (int i = 0; i < lista_wallets.size(); i++) {
                    System.out.println(lista_wallets.get(i));
                    System.out.println("---------------------------------------");
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
                System.out.println("LISTA DE WALLETS:");
                System.out.println("---------------------------------------");                
                for (int i = 0; i < lista_wallets.size(); i++) {
                    System.out.println(lista_wallets.get(i));
                    System.out.println("---------------------------------------");
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
    
    public static void Borrar_Producto() {

        Connection conexion = null;
            try {
                conexion = Conexion.getConexion();
                if (conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false);
                }
                //Ahora proporcionamos el objeto conexión para poder aplicar el concepto de transacción
                //INSTANCIO TAMBIÉN LAS COMPRAS POR SI HAY COMPRAS QUE TIENEN EL PRODUCTO A BORRAR
                ProductoDAO producto = new ProductoDAO(conexion);
                CompraDAO compra = new CompraDAO(conexion);
                List <Producto> lista_productos = producto.seleccionarProducto();
                List <Compra> lista_compras = compra.seleccionarCompra();
                
                //MOSTRAMOS LOS PRODUCTOS EXISTENTES
                System.out.println("LISTA DE PRODUCTOS:");
                System.out.println("---------------------------------------");                
                for (int i = 0; i < lista_productos.size(); i++) {
                    System.out.println(lista_productos.get(i));
                    System.out.println("---------------------------------------");
                }
                
                System.out.println("Introduce el ID del producto a borrar");
                int id_producto_borrar = teclado.nextInt();
                teclado.nextLine();
                
                //RECORRO LOS PRODUCTOS Y SACO EL PRODUCTO OQUE QUIEREN BORRAR
                Producto producto_aux=null;
                for (int i = 0; i < lista_productos.size(); i++) {
                    Producto get1 = lista_productos.get(i);
                    if (get1.getId_producto() == id_producto_borrar) {
                        producto_aux = lista_productos.get(i);
                    }
                }
                
                //RECORRO LAS COMPRAS Y COMPRUEBO QUE NO HAY NINGUNA QUE TENGA EL ID DEL PRODUCTO A BORRAR
                Compra compra_aux = null;
                for (int i = 0; i < lista_compras.size(); i++) {
                    Compra get1 = lista_compras.get(i);
                    if (get1.getId_producto() == id_producto_borrar) {
                        compra_aux = lista_compras.get(i);
                    }                    
                }
                if (compra_aux != null) {
                        System.out.println("***************************************");                                
                        System.out.println("El producto está asociado a otras cuentas y no se puede borrar");
                        System.out.println("***************************************");            
                        System.out.println("Ha habido un problema, se entra al 'ROLLBACK'");
                        System.out.println("***************************************"); 
                        try {
                                conexion.rollback();
                                return;
                            } catch (SQLException ex1) {
                                ex1.printStackTrace(System.out);
                        }                        
                    } else {
                        producto.borrarProducto(producto_aux);
                        conexion.commit();
                        System.out.println("***************************************");
                        System.out.println("Relizando commit... ¡Se ha borrado el producto " + producto_aux.getNombre()+ " de la lista de productos");
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
        
    }
    
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
                System.out.println("LISTA DE PRODUCTOS:");
                System.out.println("---------------------------------------");                
                for (int i = 0; i < lista_productos.size(); i++) {
                    System.out.println(lista_productos.get(i));
                    System.out.println("---------------------------------------");
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
                    System.out.println("---------------------------------------");
                }                 
                
                //SOLICTAMOS ID DE WALLET AL USUARIO Y SACAMOS EL USUARIO A UN AUXILIAR PARA RESTARLE EL DINERO Y AÑADIRLE LOS PUNTOS
                System.out.println("Introduce el ID de la wallet del cliente:");
                int id_wallet = teclado.nextInt();
                teclado.nextLine();
                Wallet wallet_aux=null;
                for (int i = 0; i < lista_wallets.size(); i++) {
                    Wallet get = lista_wallets.get(i);
                    if (get.getId_wallet() == id_wallet) {
                        wallet_aux = lista_wallets.get(i);
                    }
                }
                
                //IMPRIMIOS LOS PRODUCTOS PARA QUE EL USUARIO SEPA INTERACTUAR
                List <Producto> lista_productos = producto.seleccionarProducto();
                System.out.println("Estos son los Productos disponibles\n");
                for (int i = 0; i < lista_productos.size(); i++) {
                    System.out.println(lista_productos.get(i));
                    System.out.println("---------------------------------------");
                }
                //SOLICTAMOS ID DEL PRODUCTO AL USUARIO Y SACAMOS EL PRODUCTO A UN AUXILIAR PARA SABER CUANTOS PUNTOS VALE Y CUANTPO DINERO
                System.out.println("Introduce el ID del producto que quiere comprar");
                int id_producto = teclado.nextInt();
                teclado.nextLine();  
                Producto producto_aux=null;
                for (int i = 0; i < lista_productos.size(); i++) {
                    Producto get1 = lista_productos.get(i);
                    if (get1.getId_producto() == id_producto) {
                        producto_aux = lista_productos.get(i);
                    }
                }
                int puntos_producto_aux = producto_aux.getPuntos();
                int precio_producto_aux = producto_aux.getPrecio();
                
                System.out.println(producto_aux.toString());
                System.out.println(puntos_producto_aux);
                System.out.println(precio_producto_aux);
                
                //LA FECHA ACTUAL DE COMPRA LA LEEMOS CON JAVA.UTIL.DATE, HAY QUE TRANSFORMARLA A JAVA.SQL.DATE
                java.util.Date utilDate = new java.util.Date();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                //SI EL CLIENTE NO TIENE SALDO SUFICIENTE NO PODRÁ HACER LA COMPRA, SINO, REGISTRAMOS LA COMPRA Y REALIZAMOS LAS OPERACIONES
                if (wallet_aux.getSaldo_euros() < precio_producto_aux) {
                    System.out.println("***************************************");                    
                    System.out.println("Lo sentimos, no dispone de saldo suficiente para realizar la compra");
                    System.out.println("***************************************");                                        
                } else { //SI TIENE SALDO SUFIENTE ENTONCES LE RESTAMOS EL PRECIO, LE SUMMOS LOS PUNTOS Y REGISTRAMOS LA COMPRA
                    //DESCONTAR IMPORTE DE LA COMPRA DE SU SALDO EN EUROS
                    wallet_aux.setSaldo_euros(wallet_aux.getSaldo_euros() - precio_producto_aux);
                    //LE SUMAMOS LOS PUNTOS QUE VALE EL PRODUCTO COMPRADO
                    wallet_aux.setSaldo_puntos(wallet_aux.getSaldo_puntos()+ puntos_producto_aux);
                    //ACTUALIZAMOS LA WALLET DE CLIENTE
                    wallet.actualizarWallet(wallet_aux);
                    //REGISTRAMOS LA COMPRA
                    Compra nueva_compra = new Compra(id_wallet, id_producto, sqlDate);
                    compra.insertarCompra(nueva_compra);
                    
                    conexion.commit();
                    System.out.println("***************************************");
                    System.out.println("Relizando commit... La compra ha sido pagada correctamente por " + wallet_aux.getNombre()); 
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
    }  //FUNCIONA BIEN
        
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
                System.out.println("LISTA DE COMPRAS:");
                System.out.println("---------------------------------------");                
                for (int i = 0; i < lista_compras.size(); i++) {
                    System.out.println(lista_compras.get(i));
                    System.out.println("---------------------------------------");
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
                WalletDAO wallet = new WalletDAO(conexion);
                ProductoDAO producto = new ProductoDAO(conexion);
                DevolucionDAO devolucion = new DevolucionDAO(conexion);
                
                List <Compra> lista_compras = compra.seleccionarCompra();
                List <Wallet> lista_Wallets = wallet.seleccionarWallet();
                List <Producto> lista_productos = producto.seleccionarProducto();
                List <Devolucion> lista_devoluciones = devolucion.seleccionarDevolucion();
                //LE MUESTRO AL USUARIO LAS COMPRAS EXISTENTES
                for (int i = 0; i < lista_compras.size(); i++) {
                    System.out.println("Estas son las compras disponibles: ");
                    System.out.println("["+i+"] " + lista_compras.get(i));
                    System.out.println("---------------------------------------");
                } 
                //LE SOLICITO LA COMPRA A BORRAR
                System.out.println("¿Qué número de compra quiere devolver?");
                int id_introducido = teclado.nextInt();
                teclado.nextLine();

                //CREO UN AUXILIAR CON LA COMPRA DE LA POSICIÓN QUE ME INDICA EL USUARIO
                Compra compra_aux = lista_compras.get(id_introducido);
                System.out.println(compra_aux);
                
                //RECORRO LOS PRODUCTOS Y SACO LOS PUNTOS Y EL PRECIO DEL PRODUCTO ASOCIADO A LA COMPRA
                //VALOR DE LOS PUNTOS DEL PRODUCTO 
                Producto producto_aux=null;
                for (int i = 0; i < lista_productos.size(); i++) {
                    Producto get1 = lista_productos.get(i);
                    if (get1.getId_producto() == compra_aux.getId_producto()) {
                        producto_aux = lista_productos.get(i);
                    }
                }
                int puntos_producto_aux = producto_aux.getPuntos();
                int precio_producto_aux = producto_aux.getPrecio();
                System.out.println(producto_aux.toString()); 
                
                //RECORRO LAS WALLETS Y CREO UN WALLET AUXILIAR DEL USUARIO AL QUE LE VAMOS A RESTAR LOS PUNTOS Y SUMARLE EL PRECIO DEL PRODUCTO
                Wallet wallet_aux=null;
                for (int i = 0; i < lista_Wallets.size(); i++) {
                    Wallet get = lista_Wallets.get(i);
                    if (get.getId_wallet() == compra_aux.getId_wallet()) {
                        wallet_aux = lista_Wallets.get(i);
                    }
                }
                //LE SUMAMOS EL PRECIO DEL PRODUCTO
                wallet_aux.setSaldo_euros(wallet_aux.getSaldo_euros() + producto_aux.getPrecio());
                //LE RESTAMOS LOS PUNTOS POR DEVOLVERLO
                wallet_aux.setSaldo_puntos(wallet_aux.getSaldo_puntos() - producto_aux.getPuntos());
                //ACTUALIZAMOS LA WALLET DEL CLIENTE
                wallet.actualizarWallet(wallet_aux);
                //CREAMOS LA FECHA ACTUAL PARA REGISTRAR LA LA DEVOLUCIÓN
                java.util.Date utilDate = new java.util.Date();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                //BORRAMOS LA COMPRA DE LA LISTA DE LAS COMPRAS
                compra.borrarCompra(compra_aux);
                //AÑADIMOS A LA LISTA DE DEVOLUCIONES UNA NUEVA DEVOLUCIÓN
                Devolucion nueva_devolucion = new Devolucion (wallet_aux.getId_wallet(), producto_aux.getId_producto(), sqlDate);
                devolucion.insertarDevolucion(nueva_devolucion);
                //SI AL TERMINAR LA OPERACIÓN LA EWALLET TIENE UN SALDO MENOR A 5 NO SE PODRÁ DEVOLVER EL PRODUCTO
                if (wallet_aux.getSaldo_puntos() + producto_aux.getPuntos() < 5) {
                    System.out.println("No se puede devolver el producto, su saldo de puntos es inferior a 5");
                    try {
                        System.out.println("***************************************");                
                        System.out.println("Ha habido un problema, se entra al 'ROLLBACK'");
                        System.out.println("***************************************");
                    conexion.rollback();
                    return;
                } catch (SQLException ex1) {
                        ex1.printStackTrace(System.out);
            }
                } else {
                    conexion.commit();
                    System.out.println("***************************************");
                    System.out.println("Relizando commit... La devolución se ha realizado correctamente"); 
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
                System.out.println("LISTA DE DEVOLUCIONES:");
                System.out.println("---------------------------------------");               
                for (int i = 0; i < lista_devoluciones.size(); i++) {
                    System.out.println(lista_devoluciones.get(i));
                    System.out.println("---------------------------------------");
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

                //IMPRIMIMOS LAS WALLETS PARA QUE EL USUARIO SEPA INTERACTUAR
                List <Wallet> lista_wallets = wallet.seleccionarWallet();  
                System.out.println("Estos son los Walets disponibles:");
                for (int i = 0; i < lista_wallets.size(); i++) {
                    System.out.println(lista_wallets.get(i));
                    System.out.println("---------------------------------------");
                }                 
              
                //SOLICTAMOS ID DE WALLET AL USUARIO Y SACAMOS EL USUARIO A UN AUXILIAR PARA RESTARLE LOS PUNTOS
                System.out.println("Introduce el ID de la wallet del cliente que quiere canjear puntos por un producto:");
                int id_wallet = teclado.nextInt();
                teclado.nextLine();
                Wallet wallet_aux=null;
                for (int i = 0; i < lista_wallets.size(); i++) {
                    Wallet get = lista_wallets.get(i);
                    if (get.getId_wallet() == id_wallet) {
                        wallet_aux = lista_wallets.get(i);
                    }
                }

                //IMPRIMIOS LOS PRODUCTOS PARA QUE EL USUARIO SEPA INTERACTUAR
                List <Producto> lista_productos = producto.seleccionarProducto();
                System.out.println("Estos son los Productos disponibles:");
                for (int i = 0; i < lista_productos.size(); i++) {
                    System.out.println(lista_productos.get(i));
                    System.out.println("---------------------------------------");
                }                
                
                System.out.println("Introduce el ID del producto que quiere comprar con puntos");
                int id_producto = teclado.nextInt();
                teclado.nextLine();  

                //CREAMOS LA FECHA ACTUAL PARA REGISTRAR LA LA DEVOLUCIÓN
                java.util.Date utilDate = new java.util.Date();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                
                //SACAMOS EL PRODUCTO ELEGIDO A UN AUXILIAR PARA SABER CUANTOS PUNTOS VALE Y CUANTPO DINERO
                Producto producto_aux=null;
                for (int i = 0; i < lista_productos.size(); i++) {
                    Producto get1 = lista_productos.get(i);
                    if (get1.getId_producto() == id_producto) {
                        producto_aux = lista_productos.get(i);
                    }
                }
                int puntos_producto_aux = producto_aux.getPuntos();
                int precio_producto_aux = producto_aux.getPrecio();
                
                if (precio_producto_aux >= 5 && wallet_aux.getSaldo_puntos() > puntos_producto_aux) {
                    //SI LOS PUNTOS DEL PRODUCTO SON SUPERIOR A 5 Y EL CLIENTE TIENE PUNTOS
                    //DESCONTAR LOS PUNTOS DE SU SALDO DE PUNTOS
                    wallet_aux.setSaldo_puntos(wallet_aux.getSaldo_puntos() - puntos_producto_aux);
                    //ACTUALIZAMOS LA WALLET DE CLIENTE
                    wallet.actualizarWallet(wallet_aux);
                    //REGISTRAMOS LA COMPRA
                    Compra nueva_compra = new Compra(id_wallet, id_producto, sqlDate);
                    compra.insertarCompra(nueva_compra);
                    
                    conexion.commit();
                    System.out.println("***************************************");
                    System.out.println("Relizando commit... La compra ha sido pagada correctamente por " + wallet_aux.getNombre()); 
                    System.out.println("***************************************");                                                             
                } else {
                    if (wallet_aux.getSaldo_puntos() < puntos_producto_aux) {
                        System.out.println(wallet_aux.getNombre() + " no tiene puntos suficientes para canjear por productos");
                    } else {
                        System.out.println("No se pueden canjear " + puntos_producto_aux + " puntos porque el precio de " + producto_aux.getNombre()
                        + " es de "+ precio_producto_aux + "€ y ha de ser superior a 5€."); 
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
    } //FUNCIONA BIEN
}
