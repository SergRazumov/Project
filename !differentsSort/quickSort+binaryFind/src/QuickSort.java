import java.util.Arrays;

public class QuickSort {
    public static void main(String args[]) {
        int a[] = {4,5,7,2,1,8,6,3};
        System.out.println(Arrays.toString(sort(a,0,a.length)));
        System.out.println(findNumber(1, a));
    }

    private static int findNumber(int num, int a[]) {
        int i = 0;
        int j = a.length;
        int p = a.length/2;
        while (j!=i) {
            if (num > a[p]) {i = p;}
            else if(num < a[p]) {j = p-1;}
            else return p;
            p = (j+i)/2+1;
        }
        if(a[i] == num) return i; else return 0;
    }



    public static int[] sort(int a[], int l, int h) {
        if(h-l<=1) return a;
        int e = a[l];
        int i = l;
        int j = h;
        while(j>i) {
            while (j>i && a[--j]>=e); a[i] = a[j];
            while (j>i && a[++i]<=e); a[j] = a[i];
        } a[i] = e;
        sort(a,l,i);
        sort(a,i+1, h);

        return a;
    }
}
