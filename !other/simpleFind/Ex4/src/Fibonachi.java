public class Fibonachi {
    public static void main(String args[]) {
        int a = 0;
        int b = 1;
        int f, sum = 0;
        for(int i=0; i<46;i++) {
            f = a+ b;
            a = b;
            b = f;
            sum += f;
        }
        System.out.println(sum);
    }
}
