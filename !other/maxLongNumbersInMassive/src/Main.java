import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 2, 5, 8, 10, 7, 6, 10};
        System.out.println("Самая длинная строго возврастающая последовательность " );//+ Arrays.toString(findSequence(numbers)));
        findSequence(numbers);
    }


    private static void findSequence(int[] numbers) {
        int begin = 0;
        int end = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] < numbers[i]) end = i;
            else {
                if(end+1-begin<i-end+1) {begin=end+1; end = i-1;}
            }
        }
        System.out.println(begin+ " "+ end);
    }
}
