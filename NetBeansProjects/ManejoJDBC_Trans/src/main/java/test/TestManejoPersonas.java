package test;

import datos.*;
import domain.*;
import java.sql.*;

public class TestManejoPersonas {

    public static void main(String[] args) throws SQLException {

        Connection conexion = null;
        conexion = Conexion.getConnection();
        if (conexion.getAutoCommit()) {
            conexion.setAutoCommit(false);
        }
        //Ahora proporcionamos el objeto conexión para poder aplicar el concepto de transacción
        personaDAO personaDao = new personaDAO(conexion);
        Persona cambioPersona = new Persona();
        cambioPersona.setNombre("Pedro");
        cambioPersona.setApellidos("Pablo");
        cambioPersona.setEmail("fsadfas@gmail.com");
        cambioPersona.setEdad(56);

        personaDao.insertar(cambioPersona);

//        cambioPersona.setNombre("Pefsadfasdfsdddddddddddddddgdfsgsddddddddddddddddddddddddddddddro");
//        cambioPersona.setApellidos("Pefsadfasdfsdddddddddddddddgdfsgsddddddddddddddddddddddddddddddro");
//        cambioPersona.setEmail("PefsadfasdfsdddddddddddddddgdfsgsddddddddddddddddddddddddddddddroPefsadfasdfsdddddddddddddddgdfsgsddddddddddddddddddddddddddddddro@gmail.com");
//        cambioPersona.setEdad(56);
//        personaDao.insertar(cambioPersona);
        conexion.rollback();

        Persona cambioPersona1 = new Persona();
        cambioPersona1.setNombre("Kevin");
        cambioPersona1.setApellidos("fdsafdsa");
        cambioPersona1.setEmail("fsadfas@gmail.com");
        cambioPersona1.setEdad(56);
        personaDao.insertar(cambioPersona1);
        conexion.commit();

//        //Aseguramos que autocommit es falso y adaptamos el código
//        try {
//            conexion = Conexion.getConnection();
//            if (conexion.getAutoCommit()) {
//                conexion.setAutoCommit(false);
//
//                //Ahora proporcionamos el objeto conexión para poder aplicar el concepto de transacción
//                personaDAO personaDao = new personaDAO(conexion);
//                Persona cambioPersona = new Persona();
//                cambioPersona.setNombre("Pedro");
//                cambioPersona.setApellidos("Pablo");
//                cambioPersona.setEmail("fsadfas@gmail.com");
//                cambioPersona.setEdad(56);
//                personaDao.insertar(cambioPersona);
//
//                cambioPersona.setNombre("Pefsadfasdfsdddddddddddddddgdfsgsddddddddddddddddddddddddddddddro");
//                cambioPersona.setApellidos("Pefsadfasdfsdddddddddddddddgdfsgsddddddddddddddddddddddddddddddro");
//                cambioPersona.setEmail("PefsadfasdfsdddddddddddddddgdfsgsddddddddddddddddddddddddddddddroPefsadfasdfsdddddddddddddddgdfsgsddddddddddddddddddddddddddddddro@gmail.com");
//                cambioPersona.setEdad(56);
//                personaDao.insertar(cambioPersona);
//
//                conexion.rollback();
////                cambioPersona.setNombre("Karla");
////                cambioPersona.setApellidos("Karly");
////                cambioPersona.setEmail("Karla@iesserpis.com");
////                cambioPersona.setEdad(26);
//                //UPDATE
//                //personaDao.update_ID(cambioPersona);
//
////                Persona nuevaPersona = new Persona();
////                nuevaPersona.setNombre("Carlos");
////                nuevaPersona.setApellidos("Ramirez");
//                //INSERTAR
////                Persona nueva_persona = new Persona("fasddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd", "fdsafsad", 4);
////                personaDao.insertar(nueva_persona);
////                personaDao.insertar(nuevaPersona);
//                //Ahora añadimos la parte de código para confirmar que se ejecuten los cambios
//                conexion.commit();
//                System.out.println("Se ha hecho commit de la transaccion");
//            }
//
//            //Ahora añadimos la parte de código para anular los cambios (rollback)
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//            System.out.println("Entramos al rollback");
//            try {
//                conexion.rollback();
//            } catch (SQLException ex1) {
//                ex1.printStackTrace(System.out);
//            }
//        }
    }
}
