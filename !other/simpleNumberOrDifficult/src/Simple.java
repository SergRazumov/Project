import org.jetbrains.annotations.Contract;

import java.util.Scanner;

public class Simple {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число ");
        int number = in.nextInt();
        if ((number>3 && number%2 == 0) || count(number) ) System.out.println("Число " + number + " составное");
        else System.out.println("Число " + number + " простое");
    }

    public static boolean count(int numbers) {
    for (int i=3; i<=(int)Math.sqrt(numbers); i++)
        if (numbers%i==0) return true;

        return false;
    }
}
