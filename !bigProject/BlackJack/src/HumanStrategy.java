import java.util.Scanner;

public class HumanStrategy implements Strategy {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод который спрашивает брать ли еще и выдает ответ
     * @return true если брать еще карту, false если карт больше брать не нужно
     */
    @Override
    public boolean toGet() {
        System.out.println("Еще? (Да/Нет)");
        while (true) {
            String answer = scanner.nextLine();
            switch (answer.toUpperCase()) {
                case "ДА": case "Д": return true;
                case "НЕТ": case "Н" : return false;
                default:
                    System.out.println("Чего?");
            }
        }
    }
}
