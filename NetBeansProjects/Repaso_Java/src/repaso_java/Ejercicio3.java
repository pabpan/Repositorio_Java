package repaso_java;

import java.util.*;

public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int numero;

        System.out.println("Introduce un número");
        numero = teclado.nextInt();

        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                System.out.println(i);
            }
        }
    }
}
