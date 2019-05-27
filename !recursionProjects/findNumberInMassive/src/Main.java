public class Main {
    public static void main(String[] args) {
        int a[] = {0,4,5,3,2,5};
        System.out.print(findValue(a));
    }
    private static boolean findValue(int a[]) {
        return findValue(a, a.length, 3);
    }

    private static boolean findValue(int a[], int size, int number) {
        if(size==1) return number==a[0];
        if(a[size-1]==number) return true; else
        return findValue(a,size -1, number);

    }
}
