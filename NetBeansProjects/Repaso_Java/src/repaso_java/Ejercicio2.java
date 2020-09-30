package repaso_java;

import java.util.*;

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int lado1, lado2, lado3;

        System.out.println("Lado1:");
        lado1 = teclado.nextInt();
        System.out.println("Lado2:");
        lado2 = teclado.nextInt();
        System.out.println("Lado3:");
        lado3 = teclado.nextInt();

        if ((lado1 + lado2) > lado3) {
            System.out.println("Es un triángulo");
        } else {
            System.out.println("No es un triángulo");
        }
    }
}
