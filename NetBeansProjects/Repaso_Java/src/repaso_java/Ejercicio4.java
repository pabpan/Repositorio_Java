package repaso_java;

import java.util.*;

public class Ejercicio4 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        int a;
        
        System.out.print("Número: ");
        a = teclado.nextInt();
        System.out.println("");
        
        for (int i = 1; i <= a; i++) {
            
            System.out.println(i + "\t" + i*2 + "\t" + i*3);
            
        }
        System.out.println("");
    }
}
