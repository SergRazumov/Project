import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private static int[][] massive = new int[20][25];

    public static void main(String[] args) {
        writeFile();
        check();
        System.out.print("\nМинимальное число из выборки максимальных составляет " + searchMinMax());
    }

    private static void writeFile() {
        try (Scanner scan = new Scanner(new File("Matrix.txt"))) {
            while (scan.hasNext()) {
                for (int i = 0; i < 20; i++) {
                    for (int j = 0; j < 25; j++) {
                        Main.massive[i][j] = scan.nextInt();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

    private static void check() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
            for (int j = 0; j < 25; j++) {
                System.out.print(Main.massive[i][j] + " \t");
            }
        }
        System.out.println("\n");
    }

    private static int searchMinMax() {
        int[] maxLine = new int[20];
        for (int i = 0; i < 20; i++) {
            int max = Main.massive[i][0];
            for (int j = 0; j < 25; j++) {
                if (max < Main.massive[i][j]) {
                    max = Main.massive[i][j];
                }
            }
            maxLine[i] = max;
            System.out.print(maxLine[i] + " ");
        }

        int min = maxLine[0];
        for(int k =0; k<maxLine.length; k++) {
            if(min>maxLine[k]) {
                min = maxLine[k];
            }
        }
        return min;
    }
}
