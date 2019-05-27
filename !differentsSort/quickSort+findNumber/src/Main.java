import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 6, 8, 3, 2 ,1, 8};
        int[] copy;
        if (findNumber(numbers)) System.out.println("Были одинаковые");
        else System.out.println("Одинаковых нет");
        copy = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Проверить копию " + Arrays.toString(copy));
        System.out.println("Отсортированный массив " + Arrays.toString(quickSort(numbers, 0, numbers.length))); //не забыть обсудить Arrays
        Arrays.sort(numbers);
        System.out.println("Отсортированный массив с помощью Sort " + Arrays.toString(numbers));
        if (checkNearValue(numbers)) System.out.println("Были одинаковые");
        else System.out.println("Одинаковых нет");
    }

    private static boolean findNumber(int[] numbers) {
        for (int k = 0; k< numbers.length; k++) {
            for (int i = k + 1; i < numbers.length; i++) {

                if (numbers[i] == numbers[k]) {
                    System.out.println("Есть повторяющее число " + numbers[k]);
                    return true;
                }
            }
        }
        return false;
    }

    private static int[] quickSort (int [] numbers, int low, int high)  { //поговорить про быструю сортировку
        if(high-low<=1) return numbers;
        int e = numbers[low];
        int i = low;
        int j = high;
        while(j>i) {
            while (j>i && numbers[--j]>e); numbers[i] = numbers[j];
            while (j>i && numbers[++i]<=e); numbers[j] = numbers[i];
        } numbers[i] = e;

        quickSort(numbers,low,i);

        quickSort(numbers,i+1,high);

        return numbers;
    }

    private static boolean checkNearValue(int[] numbers) {
        for(int i = 1; i<numbers.length; i++) {
            if(numbers[i] == numbers[i-1]) {return true;}
        }
        return false;
    }



}
