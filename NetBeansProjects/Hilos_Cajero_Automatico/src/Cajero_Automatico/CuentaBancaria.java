package Cajero_Automatico;

public class CuentaBancaria {

    private int saldo_actual = 50;

    public int getSaldo_actual() {
        return saldo_actual;
    }

    public void retiraDinero(int valor) {
        saldo_actual -= valor;
    }
}
