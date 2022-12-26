package JuegoGato;

import java.util.Scanner;

public class main {
    public static char[][] tablero = new char[3][3];
    public static int posTablero = 0;
    public static Scanner scanner = new Scanner(System.in);
    public static char turno = 'X';
    public static boolean band = true;

    public static void main(String[] args) {
        verTablero();
    }

    public static void verTablero() {
        do {
            System.out.println("El juego va de la siguiente manera");
            inicializarTablero();
            System.out.println("Las casillas marcadas con X u O ya están ocupadas\nDiguite la posición: ");
            posTablero = scanner.nextInt();

            llenarTablero(posTablero);

        }
        while (band);
    }

    public static void inicializarTablero() {
        int pos = 1;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == 'X' || tablero[i][j] == 'O') {
                    System.out.print(" " + tablero[i][j]);
                } else {
                    System.out.print(" " + pos);
                }
                pos++;

            }
            System.out.println();
        }
    }

    public static void llenarTablero(int posTablero) {
        int pos = 1;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == 'X' || tablero[i][j] == 'O') {
                } else {
                    if (pos == posTablero) {
                        tablero[i][j] = turno;
                        checarGanador();
                        if (band) {
                            cambiarJugador();
                        }
                    } else {
                        System.out.print(" ");
                    }
                }
                pos++;
            }
        }
        System.out.println();
    }

    public static void cambiarJugador() {
        if (turno == 'X') {
            turno = 'O';
        } else {
            turno = 'X';
        }
    }

    public static void checarGanador() {
        if (ganadorDiagonal() || ganadorLinea() || ganadorColumna()) {
            System.out.println();
            System.out.println("Felicidades jugador: " + turno + " has ganado");
            inicializarTablero();
            band = false;
        }
    }

    public static boolean ganadorDiagonal() {
        if (tablero[0][0] == turno && tablero[1][1] == turno && tablero[2][2] == turno) {
            return true;
        }
        return tablero[0][2] == turno && tablero[1][1] == turno && tablero[2][0] == turno;
    }

    public static boolean ganadorLinea() {
        if (tablero[0][0] == turno && tablero[0][1] == turno && tablero[0][2] == turno) {
            return true;
        }
        if (tablero[1][0] == turno && tablero[1][1] == turno && tablero[1][2] == turno) {
            return true;
        }
        return tablero[2][0] == turno && tablero[2][1] == turno && tablero[2][2] == turno;
    }

    public static boolean ganadorColumna() {
        if (tablero[0][0] == turno && tablero[1][0] == turno && tablero[2][0] == turno) {
            return true;
        }
        if (tablero[0][1] == turno && tablero[1][1] == turno && tablero[2][1] == turno) {
            return true;
        }
        return tablero[0][2] == turno && tablero[1][2] == turno && tablero[2][2] == turno;
    }
}