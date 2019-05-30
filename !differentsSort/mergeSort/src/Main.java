import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int mass[] = generateValueMassive();
        mergeSort(mass, 0, mass.length);
    }

    private static int[] generateValueMassive() {
        int mass[] = new int[10];
        Random rnd = new Random();
        for(int i =0; i< mass.length; i++) {
            mass[i] = rnd.nextInt(10);
        }
        System.out.print(Arrays.toString(mass) + " ");
        return mass;
    }

    private static void mergeSort(int mass[], int i, int j) {
        if(j-i<=1) return;
        int m = (j+i)/2;
        mergeSort(mass, i, m);
        mergeSort(mass, m, j);
        merge(mass, i, m, j);
    }

    private static void merge(int mass[], int i, int m, int j) {

    }
}
