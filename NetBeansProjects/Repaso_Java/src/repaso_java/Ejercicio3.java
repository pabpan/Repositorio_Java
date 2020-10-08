package repaso_java;

import java.util.*;

public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int numero;
        
        do {
        System.out.println("---------------------"
                + "\nIntroduce un número"
                + "\n---------------------");
        numero = teclado.nextInt();
        } while (numero < 1);
        
        System.out.println("---------------------"
                + "\nSus divisores son: "
                + "\n---------------------");

        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                System.out.println(i);
            }
        }
    }
}
