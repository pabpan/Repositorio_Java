package hilo_wait_notify;

import java.util.List;

public class Productor implements Runnable {

    private List<String> productos;

    public Productor(List<String> productos) {
        this.productos = productos;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(4000);

                synchronized (productos) {
                    productos.add("Producto");
                    System.out.println("Producto agregado a la lista");
                    productos.notify();
                }
            } catch (Exception e) {
            }
        }
    }
}
