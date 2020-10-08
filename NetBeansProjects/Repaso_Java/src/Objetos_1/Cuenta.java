package Objetos_1;

public class Cuenta {

    private String titular;
    private double saldo;

    public Cuenta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public Cuenta(String titular) {
        this.titular = titular;
        saldo = 0;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String toString() {
        return "Cuenta{" + "Titular=" + titular + ", Saldo=" + saldo + "}";
    }

    public void Ingresar_Dinero(double cantidad) {

        this.saldo = saldo + cantidad;
        
        if (cantidad <= 0) {
            this.saldo = saldo;
        }
    }

    public void Retirar_Dinero(double cantidad) {

        this.saldo = saldo - cantidad;
        
        if (saldo - cantidad <= 0) {
            this.saldo = 0;
        }       
    }
}
