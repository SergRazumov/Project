public class Massive {
    public static void main(String args[]) {

        double number[] = {5,3,16,30.5,11,-6,30};
        int iMax = 0;
        double max = number[0];
        double max2 = number[0];
        for(int i=1; i<number.length;i++) {
            if(max < number [i]) { iMax = i; max = number[i]; }
        }
        System.out.println("Первый найденный элемент: " + max);
        for(int i=1; i<number.length;i++) {
            if (max2 < number[i] && iMax != i) max2 = number[i];
        }
        System.out.print("Второй найденный элемент " + max2);
    }
}
