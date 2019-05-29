public class MassiveViceVersa {
    public static void main(String args[]) {
        MassiveViceVersa o = new MassiveViceVersa();
        System.out.println(o.toString());
        int massive[] = {10, -3, 5, 9, 6};
        System.out.print("Массив наоборот " + java.util.Arrays.toString(sort(massive)));
    }

    private static int[] sort(int massive[]) {
        int number;
        for (int i = 0; i< massive.length / 2; i++) {
            number = massive[i];
            massive[i] = massive[massive.length-1-i];
            massive[massive.length-1-i] = number;
        }
        return massive;
    }
}
