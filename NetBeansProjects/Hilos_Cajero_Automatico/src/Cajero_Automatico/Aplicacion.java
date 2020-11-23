package Cajero_Automatico;

public class Aplicacion {

    public static void main(String[] args) {

        CajeroAutomatico cajero1 = new CajeroAutomatico();

        Thread pepito = new Thread(cajero1, "Juanito");
        Thread juanito = new Thread(cajero1, "Juanito");
        
        pepito.start();
        juanito.start();
    }

}
