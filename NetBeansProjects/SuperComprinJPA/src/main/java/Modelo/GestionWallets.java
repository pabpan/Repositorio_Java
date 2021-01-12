package Modelo;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Wallet;
import org.apache.logging.log4j.*;

public class GestionWallets {

    static Logger log = LogManager.getFormatterLogger();

    public static void alta_Wallet(String nombre, String apellidos, String DNI, Date fecha_nacimiento, String email, int saldo_puntos, int saldo_euros) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia_SuperComprin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        Wallet wallet = new Wallet(nombre, apellidos, DNI, fecha_nacimiento, email, saldo_puntos, saldo_euros);
        log.debug("Wallet a insertar: " + wallet);
        //Persistimos el objeto
        em.persist(wallet);
        //Terminamos la transaccion
        tx.commit();
        log.debug("Wallet insertada: " + wallet);
        em.close();
    }

    public void eliminar_Wallet(int id_wallet) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia_SuperComprin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        Wallet wallet = em.find(Wallet.class, id_wallet);
        log.debug("Wallet a borrar: " + wallet);
        //Borramos el objeto
        em.remove(wallet);
        //Terminamos la transaccion
        tx.commit();
        log.debug("Wallet borrada: " + wallet);
        em.close();
    }

    public List<Wallet> recuperar_Wallets() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia_SuperComprin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        String jpql = "Select w from Wallet w";
        Query qr = em.createQuery(jpql);
        List<Wallet> lista_wallets = (List<Wallet>) qr.getResultList();
        //Terminamos la transaccion
        tx.commit();
        for (int i = 0; i < lista_wallets.size(); i++) {
            Wallet aux = lista_wallets.get(i);
            log.debug("Wallet: " + lista_wallets);
        }
        em.close();
        return lista_wallets;
    }

    public Wallet buscar_Wallet(String email) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia_SuperComprin");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        String jpql = "Select w from Wallet w where w.email=:email";
        TypedQuery <Wallet> tq = em.createQuery(jpql, Wallet.class);
        Wallet wallet = new Wallet();
        wallet = tq.getSingleResult();
        
        //Termicontactosnamos la transaccion
        tx.commit();
        em.close();

        return wallet;
    }
}
