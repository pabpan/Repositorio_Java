package test;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class ClienteEntidadPersona {

    static Logger log = LogManager.getFormatterLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Iniciamos la transacción
        tx.begin();
        Persona persona1 = new Persona("Kevin", "Rosales", "fdsafdsa@gmail.com", 45);
        log.debug("Objeto a persistit¡r: " + persona1);
        //Persistimos el objeto
        em.persist(persona1);
        //Terminamos la transaccion
        tx.commit();
        log.debug("Objeto persistido " + persona1);
        em.clear();
    }

}
