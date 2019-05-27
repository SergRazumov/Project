package collecting;

import java.util.Arrays;
import java.util.stream.Stream;

public class ToArray {
    private static boolean isPrime(int n) {
        if (n < 2 || (n & 1) == 0) return false;
        if (n < 4) return true;
        for (int d = 3; d*d <= n; d += 2) {
            if (n % d == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] primes = Stream.iterate(2, x -> x+1).limit(99).filter(ToArray::isPrime).toArray(Integer[]::new);
        System.out.println(Arrays.toString(primes));
    }
}
