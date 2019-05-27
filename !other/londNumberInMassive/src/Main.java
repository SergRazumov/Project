import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {5,1,2,1,2,3,1};
        System.out.print(Arrays.toString(findLongNumber(numbers)));
    }

    private static int[] findLongNumber(int[] numbers) {

        int start =0;
        int end = 0;
        for(int i=1; i<numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) {
                if (end - start < (i - 1) - (end + 1)) {
                    start = end + 1;
                    end = i - 1;
                }
            }
        }
        System.out.print(start + " " + end);
        return null;
    }

}
