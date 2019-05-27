import java.util.Random;

public class Matrix {

    private static int n = 20;
    private static int[][] matrix1 = new int[n][n];
    private static int[][] matrix2 = new int[n][n];
    private static int[][] matrix3 = new int[n][n];
    private static int[][] matrix4 = new int[n][n];

    public static int[][] getMatrix1() { return matrix1; }

    public static int[][] getMatrix2() {
        return matrix2;
    }

    public static int[][] getMatrix3() {
        return matrix3;
    }

    public static int[][] getMatrix4() { return matrix4; }

    public static void generateRandomValue() {
        Random rnd = new Random();
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = rnd.nextInt(10) - 5;
            }
        }
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = rnd.nextInt(10) - 5;
            }
        }
    }

    public static void viewMatrix ( int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void createMatrix(int [][] matrix1, int [][] matrix2) {
        for(int i =0; i<matrix3.length; i++) {
            for(int j =0; j< matrix3[i].length; j++) {
                matrix3[i][j] = cell(j,i);
            }
        }
    }


    public static int cell(int k, int p) {
        int value =0;
            for (int j = 0; j < matrix3[p].length; j++) {
                value += matrix1[p][j] * matrix2[j][k];
            }
        return value;
    }
}
