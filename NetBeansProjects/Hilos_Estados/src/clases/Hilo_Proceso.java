package clases;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo_Proceso extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " ->" + this.getName());
            try {
                Hilo_Proceso.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println("Error dentro de la clase");
            }

        }
    }
}
