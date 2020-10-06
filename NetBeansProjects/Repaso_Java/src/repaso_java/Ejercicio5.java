package repaso_java;

import java.util.*;

public class Ejercicio5 {

    public static void main(String[] args) {

        int vector[] = new int[15];
        int carton[][] = new int[5][3];
        int posicion = 0;
        Random aleatorio = new Random();

        for (int i = 0; i < vector.length; i++) {

            int num_aletorio = aleatorio.nextInt(99) + 1;

            for (int j = 0; j < vector.length; j++) {
                if (vector[j] == num_aletorio) {
                    num_aletorio = aleatorio.nextInt(99) + 1;
                } else {
                    num_aletorio = num_aletorio;
                }
            }
            vector[i] = num_aletorio;
        }

        System.out.println(" ------------------------------------------------");
        System.out.println("| BINGO PABLO - SU CARTÓN DE 15 NÚMERO AEATORIOS |");
        System.out.println(" ------------------------------------------------");

        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {

                carton[i][j] = vector[posicion];
                posicion++;

                if (carton[i][j] < 10) {
                    System.out.print("0" + carton[i][j] + "                      ");
                } else {
                    System.out.print(carton[i][j] + "                      ");
                }
            }
            System.out.println();
        }
    }

}
