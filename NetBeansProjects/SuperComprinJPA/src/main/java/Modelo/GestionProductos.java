package Modelo;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Producto;
import org.apache.logging.log4j.*;

public class GestionProductos {

    static Logger log = LogManager.getFormatterLogger();

    public static void alta_Producto(String nombre, int precio, int puntos) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia_SuperComprin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        Producto producto1 = new Producto(nombre, precio, puntos);
        log.debug("Producto a insertar: " + producto1);
        //Persistimos el objeto
        em.persist(producto1);
        //Terminamos la transaccion
        tx.commit();
        log.debug("Producto insertado " + producto1);
        em.close();
    }

    public void eliminar_Producto(int id_producto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia_SuperComprin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        Producto producto1 = em.find(Producto.class, id_producto);
        log.debug("Producto a borrar: " + producto1);
        //Borramos el objeto
        em.remove(producto1);
        //Terminamos la transaccion
        tx.commit();
        log.debug("Producto borrado " + producto1);
        em.close();
    }

    public List<Producto> recuperar_Productos() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia_SuperComprin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        String jpql = "Select p from Producto p";
        Query qr = em.createQuery(jpql);
        List<Producto> productos = (List<Producto>) qr.getResultList();
        //Terminamos la transaccion
        tx.commit();
        for (int i = 0; i < productos.size(); i++) {
            Producto aux = productos.get(i);
            log.debug("Producto: " + productos);
        }
        em.close();
        return productos;
    }

    public Producto buscar_Producto(String email) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia_SuperComprin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        String jpql = "Select p from Producto p where p.email=:email";
        TypedQuery <Producto> tq = em.createQuery(jpql, Producto.class);
        Producto producto1 = new Producto();
        producto1 = tq.getSingleResult();
        
        //Termicontactosnamos la transaccion
        tx.commit();
        em.close();

        return producto1;
    }
}
