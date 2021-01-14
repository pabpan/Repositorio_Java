package Modelo;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Compra;
import org.apache.logging.log4j.*;

public class GestionCompras {

    static Logger log = LogManager.getFormatterLogger();

    public static void alta_Compra(int id_wallet, int id_producto, Date fecha_compra) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia_SuperComprin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        Compra compra1 = new Compra(id_wallet, id_producto, fecha_compra);
        log.debug("Compra a insertar: " + compra1);
        //Persistimos el objeto
        em.persist(compra1);
        //Terminamos la transaccion
        tx.commit();
        log.debug("Compra insertada " + compra1);
        em.close();
    }

    public void eliminar_Compra(int id_compra) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia_SuperComprin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        Compra compra1 = em.find(Compra.class, id_compra);
        log.debug("Compra a borrar: " + compra1);
        //Borramos el objeto
        em.remove(compra1);
        //Terminamos la transaccion
        tx.commit();
        log.debug("Compra borrada " + compra1);
        em.close();
    }

    public List<Compra> recuperar_Compras() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia_SuperComprin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        String jpql = "Select c from Compra c";
        Query qr = em.createQuery(jpql);
        List<Compra> compras = (List<Compra>) qr.getResultList();
        //Terminamos la transaccion
        tx.commit();
        for (int i = 0; i < compras.size(); i++) {
            Compra aux = compras.get(i);
            log.debug("Compra: " + compras);
        }
        em.close();
        return compras;
    }

    public Compra buscar_Compra(int id_compra) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia_SuperComprin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        String jpql = "Select c from Compra c where c.id_compra=:id_compra";
        TypedQuery <Compra> tq = em.createQuery(jpql, Compra.class);
        Compra compra1 = new Compra();
        compra1 = tq.getSingleResult();
        
        //Termicontactosnamos la transaccion
        tx.commit();
        em.close();

        return compra1;
    }
}
