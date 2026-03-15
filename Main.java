import java.util.Scanner;
public class Main {
    
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        GestorArreglos gestorArreglos = new GestorArreglos();
        GestorArrayList gestorArrayList = new GestorArrayList();
        GestorMatrices gestorMatrices = new GestorMatrices();
        
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("\n=== TALLER ESTRUCTURAS DE DATOS ===");
            System.out.println("1. Arreglos (Ej 1-5)");
            System.out.println("2. ArrayList (Ej 6-10)");
            System.out.println("3. Matrices (Ej 11-15)");
            System.out.println("4. Ejecutar Todo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    gestorArreglos.ejecutarEjercicio1();
                    gestorArreglos.ejecutarEjercicio2();
                    gestorArreglos.ejecutarEjercicio3();
                    gestorArreglos.ejecutarEjercicio4();
                    gestorArreglos.ejecutarEjercicio5();
                    break;
                case 2:
                    gestorArrayList.ejecutarEjercicio6();
                    gestorArrayList.ejecutarEjercicio7();
                    gestorArrayList.ejecutarEjercicio8();
                    gestorArrayList.ejecutarEjercicio9();
                    gestorArrayList.ejecutarEjercicio10();
                    break;
                case 3:
                    gestorMatrices.ejecutarEjercicio11();
                    gestorMatrices.ejecutarEjercicio12();
                    gestorMatrices.ejecutarEjercicio13();
                    gestorMatrices.ejecutarEjercicio14();
                    gestorMatrices.ejecutarEjercicio15();
                    break;
                case 4:
                    // Ejecución secuencial de todo
                    System.out.println("Ejecutando todos los ejercicios...");
                    // ... Llamar a todos los métodos ...
                    break;
                case 0:
                    continuar = false;
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    
    }
}
