import java.util.function.Function;

public class Integral {
    public static double integral(Function<Double, Double> f, double a, double b, int n) {
        double dx = (b-a)/n;
        double sum = 0;
        for (double x = a; x < b-dx/2; x += dx) {
            sum += dx * f.apply(x);
        }
        return sum;
    }

    private static class Sinus implements Function<Double, Double> {
        @Override
        public Double apply(Double x) {
            return Math.sin(x);
        }
    }

    public static void main(String[] args) {
        System.out.println(integral(new Sinus(), 0, Math.PI, 100));
        System.out.println(integral(new Function<Double, Double>() {
            public Double apply(Double x) {
                return Math.sin(x);
            }
        }, 0, Math.PI, 100));
        System.out.println(integral(x -> Math.sin(x), 0, Math.PI, 100));
        System.out.println(integral(Math::sin, 0, Math.PI, 100));
        System.out.println(integral(new Sinus()::apply, 0, Math.PI, 100));
    }
}
