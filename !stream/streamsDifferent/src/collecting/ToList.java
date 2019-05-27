package collecting;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToList {
    private static boolean isPrime(int n) {
        if (n < 2 || (n & 1) == 0) return false;
        if (n < 4) return true;
        for (int d = 3; d*d <= n; d += 2) {
            if (n % d == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> primes = Stream.iterate(2, x -> x+1).limit(99).filter(ToList::isPrime).collect(Collectors.toList());
        System.out.println(primes);
    }
}
