

import java.util.Scanner;
import java.util.Arrays;
import util.RandomData;

public class GestorArreglos {
    private final Scanner scanner = new Scanner(System.in);

    public void ejecutarEjercicio1(){
        System.out.println("1. Primeros 10 numero primos");
        int [] primos = {2,3,5,7,11,13,17,19,23,29};
        System.out.println("Primos:"+Arrays.toString(primos)); 
    }

    public void ejecutarEjercicio2() {
        System.out.println("2. 100 primeros números pares");
        int[] pares = new int[100];
            for (int i = 0; i < 100; i++) {
            pares[i] = (i + 1) * 2;
            }
        System.out.println("En una sola línea:");
        System.out.println(Arrays.toString(pares));

        System.out.println("\nEn 10 líneas:");
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) System.out.print("Línea " + (i / 10 + 1) + ": ");
            System.out.print(pares[i] + " ");
            if ((i + 1) % 10 == 0) System.out.println();
        }
    }

    public void ejecutarEjercicio3() {
        System.out.println("3. Factoriales de números aleatorios");
        System.out.print("Ingrese cantidad de números (n): ");
        int n = scanner.nextInt();
        int[] originales = RandomData.generateArray(n, 1, 10); 
        long[] factoriales = new long[n];

        for (int i = 0; i < n; i++) {
            factoriales[i] = calcularFactorial(originales[i]);
        }

        System.out.println("Originales:");
        System.out.println(Arrays.toString(originales));
        System.out.println("Factoriales:");
        System.out.println(Arrays.toString(factoriales)); 
    }

    private long calcularFactorial(int num) {
        long fact = 1;
        for (int i = 2; i <= num; i++) fact *= i;
        return fact;
    }
    
    
    private int[] convertLongToIntArray(long[] longs) {
        int[] ints = new int[longs.length];
        for(int i=0; i<longs.length; i++) ints[i] = (int) longs[i]; 
        return ints;
    }

    public void ejecutarEjercicio4() {
        System.out.println("4. Menor y Mayor (-50 a 50)");
        int[] numeros = RandomData.generateArray(25, -50, 50);
        System.out.println(Arrays.toString(numeros));
        
        int menor = numeros[0];
        int mayor = numeros[0];
        for (int num : numeros) {
            if (num < menor) menor = num;
            if (num > mayor) mayor = num;
        }
        System.out.println("Menor: " + menor);
        System.out.println("Mayor: " + mayor);
    }

    public void ejecutarEjercicio5() {
        System.out.println("5. Invertir dígitos de números");
        int[] originales = RandomData.generateArray(20, 10, 999);
        int[] invertidos = new int[originales.length];

        for (int i = 0; i < originales.length; i++) {
            invertidos[i] = invertirNumero(originales[i]);
        }

        System.out.println("Originales:");
        System.out.println(Arrays.toString(originales));
        System.out.println("Invertidos:");
        System.out.println(Arrays.toString(invertidos));
    }

    private int invertirNumero(int num) {
        int invertido = 0;
        int signo = num < 0 ? -1 : 1;
        num = Math.abs(num);
        while (num != 0) {
            invertido = invertido * 10 + num % 10;
            num /= 10;
        }
        return invertido * signo;
    }
}
