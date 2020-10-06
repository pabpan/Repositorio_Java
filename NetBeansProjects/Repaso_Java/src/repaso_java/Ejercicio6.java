package repaso_java;

import java.util.*;

public class Ejercicio6 {

    static Scanner teclado = new Scanner(System.in);
    static int matriz[][] = new int[18][10];

    public static void main(String[] args) {
        int opcion = 0;
        boolean bucle = true;
        while (bucle) {
            System.out.println("Introduce una opcion:"
                    + "\n1.- Dar de alta en la matriz"
                    + "\n2.- Revisar una posición concreta"
                    + "\n3.- Sumatorio total de la matriz"
                    + "\nIntroduce una opción:");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    Almacenar();
                    break;
                case 2:
                    Revisar();
                    break;
                case 3:
                    Suma_total();
                case 4:
                    bucle = false;
                default:
                    // code block
                    break;
            }
        }

    }

    public static void Almacenar() {

        int columna, fila, valor;
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Introduce la columna:");
        columna = teclado.nextInt();
        System.out.println("Introduce la fila:");
        fila = teclado.nextInt();
        System.out.println("Introduce un valor:");
        valor = teclado.nextInt();
        System.out.println("--------------------------------------------------------------------");

        matriz[columna][fila] = valor;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public static void Revisar() {

        System.out.println("--------------------------------------------------------------------");
        System.out.println("¿Qué columna quieres ver?");
        int posicion_columna = teclado.nextInt();
        System.out.println("¿Qué fila quieres ver?");
        int posicion_fila = teclado.nextInt();
        int resultado = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                resultado = matriz[posicion_columna][posicion_fila];
            }
        }
        System.out.println("--------------------------------------------------------------------");
        System.out.println("El valor es: " + resultado);
    }

    public static void Suma_total() {

        int suma = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                suma = suma + matriz[i][j];
            }
        }

        System.out.println("El total de todos los productos es:" + suma);
    }

}
