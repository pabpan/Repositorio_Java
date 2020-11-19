package Cajero_Automatico;

public class CajeroAutomatico implements Runnable {

    CuentaBancaria nueva_cuenta = new CuentaBancaria();

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sacarDineroCuenta(10);
            if (nueva_cuenta.getSaldo_actual() < 0)
                System.out.println("La cuenta está en números rojos");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void sacarDineroCuenta(int valor){

        if (nueva_cuenta.getSaldo_actual() >= valor) {
            System.out.println("Su saldo actual es: " + nueva_cuenta.getSaldo_actual());
            System.out.println("El usuario " + Thread.currentThread().getName() + "está intentado sacar: " + valor + "€");
            nueva_cuenta.retiraDinero(valor);
            System.out.println("Perfecto!! El saldo restante es:" + nueva_cuenta.getSaldo_actual());
            System.out.println("");
        } else {
            System.out.println("Sr" + Thread.currentThread().getName() + ", no queda saldo para sacar dinero!!");
        }
       
    }
}
