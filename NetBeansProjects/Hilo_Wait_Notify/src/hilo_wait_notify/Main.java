package hilo_wait_notify;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        List<String> lista_productos = new ArrayList<String>();
        Productor p = new Productor(lista_productos);
        Consumidor c = new Consumidor(lista_productos);
        
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(c);
        Thread t4 = new Thread(p);
        
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    
}
