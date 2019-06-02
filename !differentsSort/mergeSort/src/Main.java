import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int mass[] = generateValueMassive();
        mergeSort(mass, 0, mass.length);
        System.out.print("Отсортированный\n" + Arrays.toString(mass));
    }

    private static int[] generateValueMassive() {
        int mass[] = new int[10];
        Random rnd = new Random();
        for (int i = 0; i < mass.length; i++) {
            mass[i] = rnd.nextInt(10);
        }
        System.out.println(Arrays.toString(mass) + " ");
        return mass;
    }

    private static void mergeSort(int mass[], int i, int j) {
        if (j - i <= 1) return;
        int n = (j + i) / 2;
        mergeSort(mass, i, n);
        mergeSort(mass, n, j);
        merge(mass, i, n, j);
    }

    private static void merge(int mass[], int i, int n, int j) {
        int m[] = Arrays.copyOfRange(mass, i, n);
        int km = 0;
        while (km < m.length) {
            if (m[km] < mass[n]) {
                mass[i++] = m[km++];
            } else if (m[km] > mass[n]) {
                mass[i++] = mass[n++];
            } else if (m[km] == mass[n]) {
                mass[i++] = m[km++];
            }
            if (n == j && km != m.length) {
                while (i < j) {
                    mass[i++] = m[km++];
                }
            }
        }
    }
}
