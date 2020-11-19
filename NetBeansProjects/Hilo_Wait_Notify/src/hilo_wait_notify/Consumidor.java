/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilo_wait_notify;

import java.util.List;

public class Consumidor implements Runnable {

    private List<String> productos;

    public Consumidor(List<String> productos) {
        this.productos = productos;
    }

    @Override
    public void run() {

        try {
            synchronized (productos) {
                if (productos.size() == 0) {
                    System.out.println("Ne quedo en espera a que hayan productos");
                    productos.wait();
                }
                productos.remove(0);
                System.out.println("Consumo un producto");

            }
        } catch (Exception e) {
        }
    }
}
