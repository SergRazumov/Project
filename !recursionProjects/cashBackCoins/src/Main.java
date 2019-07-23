import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int coins[] = {1, 2, 5, 10};
        int current = coins.length-1;
        int valueCoins = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Какое значение проверяем ");
        int value = scan.nextInt();
        System.out.println(countCoins(coins, value, current, valueCoins));
    }

    private static int countCoins(int coins[], int value, int current, int valueCoins) {

        if(value/coins[current]<1) {countCoins(coins, value, current-1, valueCoins);}

        return valueCoins+1;
    }
}
