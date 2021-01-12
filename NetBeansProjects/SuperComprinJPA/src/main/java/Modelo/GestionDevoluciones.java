//package Modelo;
//
//import java.util.List;
//import javax.persistence.*;
//import mx.com.gm.sga.domain.Contacto;
//import org.apache.logging.log4j.*;
//
//public class GestionDevoluciones {
//
//    static Logger log = LogManager.getFormatterLogger();
//
//    public static void altaContacto(String nombre, String email, int telefono) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactoPU");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//
//        //Iniciamos la transacción
//        tx.begin();
//        Contacto contacto1 = new Contacto(nombre, email, telefono);
//        log.debug("Objeto a insertar: " + contacto1);
//        //Persistimos el objeto
//        em.persist(contacto1);
//        //Terminamos la transaccion
//        tx.commit();
//        log.debug("Objeto insertado " + contacto1);
//        em.close();
//    }
//
//    public void eliminarContacto(int idcontacto) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactoPU");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//
//        //Iniciamos la transacción
//        tx.begin();
//        Contacto contacto1 = em.find(Contacto.class, idcontacto);
//        log.debug("Objeto a borrar: " + contacto1);
//        //Borramos el objeto
//        em.remove(contacto1);
//        //Terminamos la transaccion
//        tx.commit();
//        log.debug("Objeto borrado " + contacto1);
//        em.close();
//    }
//
//    public List<Contacto> recuperarContactos() {
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactoPU");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//
//        //Iniciamos la transacción
//        tx.begin();
//        String jpql = "Select c from Contacto c";
//        Query qr = em.createQuery(jpql);
//        List<Contacto> contactos = (List<Contacto>) qr.getResultList();
//        //Terminamos la transaccion
//        tx.commit();
//        for (int i = 0; i < contactos.size(); i++) {
//            Contacto aux = contactos.get(i);
//            log.debug("Contacto: " + contactos);
//        }
//        em.close();
//        return contactos;
//    }
//
//    public Contacto buscarContacto2(String email) {
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactoPU");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//
//        //Iniciamos la transacción
//        tx.begin();
//        String jpql = "Select c from Contacto c where email='" + email + "'";
//        TypedQuery <Contacto> tq = em.createQuery(jpql, Contacto.class);
//        Contacto contacto1 = new Contacto();
//        contacto1 = tq.getSingleResult();
//        
//        //Termicontactosnamos la transaccion
//        tx.commit();
//        em.close();
//
//        return contacto1;
//    }
//}
