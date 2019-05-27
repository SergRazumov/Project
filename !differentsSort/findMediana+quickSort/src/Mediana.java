public class Mediana {
    public static void main(String args[]) {
        int items[] = {10,-3,5,9,6};
       System.out.println(qs(items, 0, items.length-1));
    }

    private static int qs(int items[], int left, int right) {
        int i,j, x, y, med;
        i = left; j = right;
        x = items[(left+right)/2];
    do {
        while ((items[i] <x) && (i<right)) i++;
        while ((x < items[j]) && (j > left)) j--;

        if (i <= j) {
            y=items[i];
            items[i] = items[j];
            items[j] = y;
            i++; j--;
        }

    } while (i<=j);
        if(left<j) qs(items, left,j);
        if(i<right) qs(items,i,right);

        return med =items[(left+right)/2];
    }
}
