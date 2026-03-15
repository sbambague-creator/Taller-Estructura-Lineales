import java.util.Arrays;
import java.util.Scanner;

import util.RandomData;

public class GestorMatrices {
    private final Scanner scanner = new Scanner(System.in);

    public void ejecutarEjercicio11() {
        System.out.println("11. Buscar número en Matriz");
        System.out.print("Filas (m): "); int m = scanner.nextInt();
        System.out.print("Columnas (n): "); int n = scanner.nextInt();
        int[][] matriz = RandomData.generateMatrix(m, n, 0, 100);
        System.out.println(Arrays.deepToString(matriz));
        
        System.out.print("Número a buscar: ");
        int busqueda = scanner.nextInt();
        boolean encontrado = false;
        
        outer: for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] == busqueda) {
                    System.out.println("Encontrado en posición: [" + i + "][" + j + "]");
                    encontrado = true;
                    break outer;
                }
            }
        }
        if (!encontrado) System.out.println("Número no encontrado.");
    }

    public void ejecutarEjercicio12() {
        System.out.println("12. Suma Diagonal Opuesta");
        System.out.print("Tamaño (n x n): ");
        int n = scanner.nextInt();
        int[][] matriz = RandomData.generateMatrix(n, n, -50, 50);
        System.out.println(Arrays.deepToString(matriz));
        
        int suma = 0;
        for (int i = 0; i < n; i++) {
            suma += matriz[i][n - 1 - i];
        }
        System.out.println("Suma diagonal opuesta: " + suma);
    }

    public void ejecutarEjercicio13() {
        System.out.println("13. Matriz Simétrica");
        System.out.print("Tamaño (n x n): ");
        int n = scanner.nextInt();
        // Para asegurar simetría en prueba, la llenamos específicamente o aleatoria
        int[][] matriz = RandomData.generateMatrix(n, n, 1, 10);
        // Forzar simetría para prueba (opcional, aquí dejo aleatoria pura)
        for(int i=0; i<n; i++) for(int j=i+1; j<n; j++) matriz[j][i] = matriz[i][j];
        
        System.out.println(Arrays.deepToString(matriz));
        boolean esSimetrica = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] != matriz[j][i]) esSimetrica = false;
            }
        }
        System.out.println("¿Es simétrica? " + esSimetrica);
        System.out.println("Esquinas: " + matriz[0][0] + ", " + matriz[0][n-1] + 
                           ", " + matriz[n-1][0] + ", " + matriz[n-1][n-1]);
    }

    public void ejecutarEjercicio14() {
        System.out.println("14. Matriz Transpuesta");
        int m = 3, n = 4; // Predeterminado
        int[][] original = RandomData.generateMatrix(m, n, 1, 20);
        int[][] transpuesta = new int[n][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transpuesta[j][i] = original[i][j];
            }
        }
        
        System.out.println("Original:");
        System.out.println(Arrays.deepToString(original));
        System.out.println("Transpuesta:");
        System.out.println(Arrays.deepToString(transpuesta));
    }

    public void ejecutarEjercicio15() {
        System.out.println("15. Intercambiar Filas");
        System.out.print("Filas (m): "); int m = scanner.nextInt();
        System.out.print("Columnas (n): "); int n = scanner.nextInt();
        int[][] matriz = RandomData.generateMatrix(m, n, 1, 50);
        
        System.out.println("Antes:");
        System.out.println(Arrays.deepToString(matriz));
        
        if (m >= 2) {
            int[] temp = matriz[0];
            matriz[0] = matriz[1];
            matriz[1] = temp;
            System.out.println("Después (Fila 1 y 2 intercambiadas):");
            System.out.println(Arrays.deepToString(matriz));
        } else {
            System.out.println("No hay suficientes filas para intercambiar.");
        }
    }
}
