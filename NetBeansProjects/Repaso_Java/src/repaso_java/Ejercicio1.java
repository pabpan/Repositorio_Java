package repaso_java;

import java.util.*;

public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        double tasa;
        String usuario;

        System.out.println("Alcohol:");
        tasa = teclado.nextDouble();
        teclado.nextLine();
        System.out.println("¿Es usuario ciclista? SI|NO");
        usuario = teclado.nextLine();

        if (tasa >= 0.3 && usuario.equals("NO")) {
            System.out.println("Estás borracho, no puedes continuar");
        } else if (tasa < 0.5 && usuario.equals("SI")) {
            System.out.println("Puedes continuar");
        } else {
            System.out.println("Estás borracho, no puedes continuar");
        }

    }

}
