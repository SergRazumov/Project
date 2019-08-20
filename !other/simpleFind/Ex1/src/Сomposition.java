public class Сomposition {
    public static int sumDigits(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String args[]) {
        int n = Integer.parseInt(args[0]);

        System.out.println("Сумма значений " + sumDigits(n));
        System.out.println(Integer.parseInt("12"));
        }
    }
