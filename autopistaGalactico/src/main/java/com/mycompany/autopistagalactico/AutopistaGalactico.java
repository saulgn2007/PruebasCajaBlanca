package com.mycompany.autopistagalactico;
import java.util.Scanner;
import java.util.Random;
public class AutopistaGalactico {
      
    public static void main(String[] args) {
        System.out.println("Bienvenido a LA GUIA DEL VIAJERO INTERGALACTICO");
        System.out.println("Pulsa cualquier tecla + Enter para lanzar los dados.");
        System.out.println("Teclea 0 + Enter para finalizar el juego manualmente.\n");
        jugar(1, 0);
    }

    public static void jugar(int casilla, int valorAnterior) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un caracter para lanzar los dados (0 para salir): ");
        String entrada = sc.nextLine();

        // Si el usuario teclea 0, se termina el juego
        if (entrada.equals("0")) {
            System.out.println("Juego finalizado por el usuario.");
            return;
        }

        if (casilla == 33) {
            mostrarTablero(casilla);
            System.out.println("Has caido en el agujero negro. Fin del juego!");
            return;
        }
        if (casilla == 42) {
            mostrarTablero(casilla);
            System.out.println("Has llegado a la casilla 42! Ganaste!");
            return;
        }

        // Tirada de dados
        Random r = new Random();
        int d1 = r.nextInt(9);
        int d2 = r.nextInt(9);
        int d3 = r.nextInt(9);

        int galaxia = d1 * 100 + d2 * 10 + d3;
        int valor = reducirSuma(d1 + d2 + d3);

        System.out.println("\nTirada: " + d1 + d2 + d3 + " → Galaxia " + galaxia + " → Valor " + valor);

        int diferencia = Math.abs(valor - valorAnterior);

        if (diferencia <= 4) {
            casilla += diferencia;
            System.out.println("Avanzas " + diferencia + " casillas. Ahora estas en la casilla " + casilla);
        } else {
            System.out.println("Las galaxias no son cercanas. Te quedas en la casilla " + casilla);
        }

        if (casilla == 31) {
            System.out.println("Extraterrestres peligrosos! Retrocedes a la casilla 13");
            casilla = 13;
        }
        if (casilla > 42) {
            System.out.println("Has sobrepasado la casilla 42. Vuelves a la casilla 1");
            casilla = 1;
        }
        mostrarTablero(casilla);




        (casilla, valor);
    }

    public static int reducirSuma(int n) {
        if (n < 10) return n;
        int suma = 0;
        while (n > 0) {
            suma += n % 10;
            n /= 10;
        }
        return reducirSuma(suma);
    }

    // Funcion para imprimir el tablero
    public static void mostrarTablero(int posicion) {
        for (int i = 1; i <= 42; i++) {
            if (i == posicion) {
                System.out.print("[P]"); 
            } else if (i == 31) {
                System.out.print("[E]"); 
            } else if (i == 33) {
                System.out.print("[H]"); 
            } else if (i == 42) {
                System.out.print("[F]"); 
            } else {
                System.out.print("[" + i + "]");
            }
        }
        System.out.println(); 
    }
}
