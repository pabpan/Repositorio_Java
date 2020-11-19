package clases;

public class Principal {

    public static void main(String[] args) {

        Hilo_Proceso hilo1 = new Hilo_Proceso(); //ESTADO -> NUEVO
        Hilo_Proceso hilo2 = new Hilo_Proceso();

        hilo1.start(); ////ESTADO -> EN EJECUCIÓN

        try {
            hilo1.sleep(2000); //ESTADO -> BLOQUEADO
        } catch (InterruptedException ex) {
            System.out.println("Error en el hilo 1 " + ex);
        }

        hilo2.start();
        
        hilo2.stop(); //ESTADO -> ACABADO

        try { 
            hilo2.sleep(2000); //ESTADO -> BLOQUEADO
        } catch (InterruptedException ex) {
            System.out.println("Error en el hilo 2 " + ex);
        }
        
        
    }

}
