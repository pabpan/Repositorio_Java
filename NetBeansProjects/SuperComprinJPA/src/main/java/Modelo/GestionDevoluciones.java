package Modelo;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Devolucion;
import org.apache.logging.log4j.*;

public class GestionDevoluciones {

    static Logger log = LogManager.getFormatterLogger();

    public static void realizar_Devolucion(int id_wallet, int id_producto, Date fecha_devolucion) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia_SuperComprin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        Devolucion devolucion1 = new Devolucion(id_wallet, id_producto, fecha_devolucion);
        log.debug("Devolucion a insertar: " + devolucion1);
        //Persistimos el objeto
        em.persist(devolucion1);
        //Terminamos la transaccion
        tx.commit();
        log.debug("Devolución insertado " + devolucion1);
        em.close();
    }

    public void eliminar_Devolucion(int id_devolucion) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia_SuperComprin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        Devolucion devolucion1 = em.find(Devolucion.class, id_devolucion);
        log.debug("Devolucion a borrar: " + devolucion1);
        //Borramos el objeto
        em.remove(devolucion1);
        //Terminamos la transaccion
        tx.commit();
        log.debug("Devolucion borrado " + devolucion1);
        em.close();
    }

    public List<Devolucion> recuperar_Devoluciones() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia_SuperComprin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        String jpql = "Select d from Devolucion d";
        Query qr = em.createQuery(jpql);
        List<Devolucion> devoluciones = (List<Devolucion>) qr.getResultList();
        //Terminamos la transaccion
        tx.commit();
        for (int i = 0; i < devoluciones.size(); i++) {
            Devolucion aux = devoluciones.get(i);
            log.debug("Devolucion: " + devoluciones);
        }
        em.close();
        return devoluciones;
    }

    public Devolucion buscar_Devolucion(int id_devolucion) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia_SuperComprin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        String jpql = "Select d from Devolucion d where c.id_devolucion=:id_devolucion";
        TypedQuery <Devolucion> tq = em.createQuery(jpql, Devolucion.class);
        Devolucion devolucion1 = new Devolucion();
        devolucion1 = tq.getSingleResult();
        
        //Termicontactosnamos la transaccion
        tx.commit();
        em.close();

        return devolucion1;
    }
}
