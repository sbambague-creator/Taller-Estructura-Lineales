import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import util.RandomData;

public class GestorArrayList {
    private final Scanner scanner = new Scanner(System.in);

    public void ejecutarEjercicio6() {
        System.out.println("6. ArrayList hasta leer 10");
        ArrayList<Integer> numeros = new ArrayList<>();
        int suma = 0;
        System.out.println("Ingrese números (escriba 10 para terminar):");
        
        // Para el taller, generaremos aleatorios hasta que salga un 10
        while (true) {
            int val = RandomData.generateInt(-10, 10);
            System.out.print("Leído: " + val + " | ");
            if (val == 10) break;
            numeros.add(val);
            suma += val;
        }
        
        System.out.println("\nLista: " + numeros);
        System.out.println("Suma: " + suma);
        System.out.println("Media: " + (numeros.isEmpty() ? 0 : (double) suma / numeros.size()));
    }

    public void ejecutarEjercicio7() {
        System.out.println("7. ArrayList Pares (Insertar/Borrar)");
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 2; i <= 40; i += 2) lista.add(i);
        
        System.out.println("Inicial: " + lista);
        
        System.out.print("Ingrese número para insertar ordenadamente: ");
        int nuevo = scanner.nextInt();
        int pos = 0;
        while (pos < lista.size() && lista.get(pos) < nuevo) pos++;
        lista.add(pos, nuevo);
        System.out.println("Tras insertar: " + lista);
        
        System.out.print("Ingrese número para borrar: ");
        int borrar = scanner.nextInt();
        lista.remove(Integer.valueOf(borrar));
        System.out.println("Tras borrar: " + lista);
    }

    public void ejecutarEjercicio8() {
        System.out.println("8. Frecuencia de números (1-20)");
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 100; i++) lista.add(RandomData.generateInt(1, 20));
        
        Map<Integer, Integer> frecuencia = new HashMap<>();
        for (int num : lista) {
            frecuencia.put(num, frecuencia.getOrDefault(num, 0) + 1);
        }
        
        System.out.println("Tabla de Frecuencias:");
        int maxFreq = 0;
        int numMasRepetido = 0;
        
        for (Map.Entry<Integer, Integer> entry : frecuencia.entrySet()) {
            System.out.println("Número " + entry.getKey() + ": " + entry.getValue() + " veces");
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                numMasRepetido = entry.getKey();
            }
        }
        System.out.println("Más repetido: " + numMasRepetido + " (" + maxFreq + " veces)");
    }

    public void ejecutarEjercicio9() {
        System.out.println("9. Ordenar y Separar Pares/Impares");
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 20; i++) lista.add(RandomData.generateInt(1, 100));
        
        System.out.println("Original: " + lista);
        
        ArrayList<Integer> asc = new ArrayList<>(lista);
        Collections.sort(asc);
        System.out.println("Ascendente: " + asc);
        
        ArrayList<Integer> desc = new ArrayList<>(lista);
        Collections.sort(desc, Collections.reverseOrder());
        System.out.println("Descendente: " + desc);
        
        ArrayList<Integer> pares = new ArrayList<>();
        ArrayList<Integer> impares = new ArrayList<>();
        for (int n : lista) {
            if (n % 2 == 0) pares.add(n);
            else impares.add(n);
        }
        System.out.println("Pares: " + pares);
        System.out.println("Impares: " + impares);
    }

    public void ejecutarEjercicio10() {
        System.out.println("10. Gestión de Partidos");
        ArrayList<Partido> partidos = new ArrayList<>();
        // Datos de ejemplo
        partidos.add(new Partido("Barcelona", "Real Madrid", 3, 1));
        partidos.add(new Partido("Chelsea", "Barcelona", 2, 0));
        partidos.add(new Partido("Barcelona", "PSG", 1, 1));
        partidos.add(new Partido("Liverpool", "Milan", 0, 2));

        System.out.println("Partidos donde ganó el visitante:");
        for (Partido p : partidos) {
            if (p.ganoVisitante()) System.out.println(p);
        }

        long barçaWins = partidos.stream()
                .filter(p -> p.getLocal().equals("Barcelona") && p.ganoLocal() || 
                             p.getVisitante().equals("Barcelona") && p.ganoVisitante())
                .count();
        System.out.println("Victorias del Barcelona: " + barçaWins);

        System.out.println("Eliminando partidos que NO son empate...");
        // Iterar con índice para evitar ConcurrentModificationException
        for (int i = partidos.size() - 1; i >= 0; i--) {
            if (!partidos.get(i).esEmpate()) {
                partidos.remove(i);
            }
        }
        System.out.println("Partidos restantes (Empates): " + partidos);
        
        // Recargar para el último punto ya que los borramos arriba
        partidos.add(new Partido("A", "B", 2, 0)); 
        long localWins = partidos.stream().filter(Partido::ganoLocal).count();
        System.out.println("Victorias Locales (en lista actual): " + localWins);
    }
}
