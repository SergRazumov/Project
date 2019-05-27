public class Factional {
    private static int hnumber1, lnumber1, hnumber2, lnumber2;

    Factional(int h, int l, int h1, int l1) {
        hnumber1 = h;
        lnumber1 = l;
        hnumber2 = h1;
        lnumber2 = l1;
    }

    public static void sum() {


    }

    public static int difference() {
        return 0;
    }

    public static int particular() {
        return 0;
    }

    public static void composition() {
        hnumber1 *= hnumber2;
        lnumber1 *= lnumber2;
    }

    public String toString() {
        return hnumber1 + "/" + lnumber1;
    }

}
