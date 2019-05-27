public class Fraction {
    private final int num, denom;

    public final static Fraction UNIT = new Fraction(1,1);

    public Fraction(int num, int denom) {
        int g = gcd(num, denom);
        //num /= g;
        //denom /= g;
        this.num = num / g;
        this.denom = denom / g;
    }

    public int getNum() {
        return num;
    }

    public int getDenom() {
        return denom;
    }

    public Fraction add(Fraction f) {
        int num1 = num*f.denom + denom*f.num;
        int denom1 = denom*f.denom;
        return (new Fraction(num1, denom1));
    }

    public String toString() {
        return num + "/" + denom;
    }

    private static int gcd(int n1, int n2) {
        int q;
        do {
            q = n1 % n2;
            n1 = n2;
            n2 = q;
        } while (q != 0);
        return n1;
    }
}
