import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] attempts = {120, 150, 160, 201, 203, 180, 202
        };
        int j =0;
        while(j<attempts.length) {
            for (int i = 0; i < attempts.length - 1; i++) {
                if (attempts[i] < attempts[i + 1]) {
                    int n = attempts[i];
                    attempts[i] = attempts[i + 1];
                    attempts[i + 1] = n;
                }
            }
            j++;
        }
       System.out.println(Arrays.toString(attempts));
    }
}
