public class Induction {
    public static void main(String[] args) {
        int a[] = {5,6,3,3,6,4};
        System.out.println(compare1(a,3));
    }

    private static boolean compare(int a[]) {
        return compare(a,a.length, 8);
    }

    private static boolean compare(int a[],int length, int number) {
        if(length ==1) return a[0] == number;
       return a[length-1] == number || compare(a,length-1,number);

    }

    private static boolean compare1(int[] a, int number) { return compare1(a, 0, a.length, number); }

    private static boolean compare1(int[] a, int low, int high, int number) {
        if (high-low == 1) return a[low] == number;
        int m = (low + high) / 2;
        return compare1(a, low, m, number) || compare1(a, m, high, number);
    }
}
