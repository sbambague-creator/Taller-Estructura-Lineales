package util;
import java.util.Random;

public class RandomData {
    private static final Random random = new Random();

    public static int generateInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public static int[] generateArray(int size, int min, int max) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = generateInt(min, max);
        }
        return arr;
    }

    public static int[][] generateMatrix(int rows, int cols, int min, int max) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = generateInt(min, max);
            }
        }
        return matrix;
    }
}
