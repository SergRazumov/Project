import java.util.Arrays;
import java.util.Random;

public class QSort {
    public static void main(String[] args) {
        int[] items = new int[20];
        Random rnd = new Random();
        for (int i = 0; i < items.length; i++) items[i] = rnd.nextInt(50);
        System.out.println(Arrays.toString(items));
        qsort(items);
        System.out.println(Arrays.toString(items));
    }

    private static void qsort(int[] items) {
        qsort(items, 0, items.length);
    }

    private static void qsort(int[] items, int low, int high) {
        int e = items[low];
        int i = low, j = high;
        while (i < j) {
            while (i < j && items[--j] >= e) ;
            items[i] = items[j];
            while (i < j && items[++i] <= e) ;
            items[j] = items[i];
        }
        items[i] = e;
        if (low < i-1) qsort(items, low, i);
        if (j < high-1) qsort(items, j+1, high);
    }
}
