import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private static Boat[] allBoats = new Boat[10];
    private static int shot;

    public static Boat[] getAllBoats() {
        return allBoats;
    }

    /**
     * Создаем корабли и распологаем их на поле, с учетом их характеристик и не пересякаемости
     */
    private static void addBoat() {
        Random rnd = new Random();

        int k = 0;
        for (int leng = 4; leng >= 1; leng--) {
            for (int count = 0; count < 5 - leng; count++) {
                Boat testBoat;
                do {
                    Direction dir = rnd.nextBoolean() ? Direction.HOR : Direction.VERT;
                    int a = rnd.nextInt(dir == Direction.HOR ? 11 - leng : 10);
                    int b = rnd.nextInt(dir == Direction.VERT ? 11 - leng : 10);
                    testBoat = new Boat(a, b, dir, leng);
                    if (allBoats[0] == null) {
                        testBoat.cross();
                        break;
                    }
                } while (testBoat.cross());
                allBoats[k] = testBoat;
                k++;
            }
        }
    }

    /**
     * Стрельба в ячейки и проверка на ошибки или не соответствие условию буква-цифра
     * @return
     */
    private static boolean fire() {
        Scanner scan = new Scanner(System.in);
        String result;
        int a, b;
        while (true) {
            result = scan.nextLine().toUpperCase();
            if (result.length() != 2 && result.length() != 3) {
                System.out.println("Неверный ввод попробуйте еще раз: ");
                continue;
            }
            b = result.charAt(0) - 'A';
            a = result.charAt(1) - '1';
            if (result.length() == 3) {
                if (result.charAt(2) == '0') a = 9;
            }
            if (a >= 0 && a < 10 && b >= 0 && b < 10) break;
            else System.out.println("Неверный ввод попробуйте еще раз: ");
        }
        // Чтобы не писать каждый раз Space.SPACE.cells[a][b]:
        Cell cell = Space.SPACE.cells[a][b];
        if (cell.getState().equals(State.BOAT)) {
            cell.setState(State.HIT);
            if (cell.getBoat() != null && cell.getBoat().destroyed()) { //если cell.setState(State.HIT) то уже точно cell.getBoat() != null, лишнее условие
                cell.getBoat().destroy();
            }
        } else {
            cell.setState(State.SHOT);
        }
        shot++;

        return false;
    }

    /**
     * Отрисовывает поле с учетом промахов и пораженных кораблей
     */

    private static void view() {
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                if (Space.SPACE.cells[i][j].getState().equals(State.SHOT))
                    System.out.print(". \t");
                else if (Space.SPACE.cells[i][j].getState().equals(State.HIT))
                    System.out.print("* \t");
                else if (Space.SPACE.cells[i][j].getState().equals(State.DESTROYED))
                    System.out.print("# \t");
                else
                    System.out.print(Space.SPACE.cells[i][j] + " \t");
            }
            System.out.println();
        }
    }

    /**
     * Проверка остались ли ячейки со статусом корабль
     * @return true  если остались,  false если нет
     */

    private static boolean check() {
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                if (Space.SPACE.cells[i][j].getState().equals(State.BOAT)) return true;
            }
        }
        return false;
    }

    /**
     * отсюда запуск
     * @param args параметр для приема
     */
    public static void main(String[] args) {
        addBoat();
        /**
         * check() проверяет есть ли ячейки со статусом корабль на поле
         * view() отрисовывает поле с учетом статусов ячеек
         * fire() выстрел в ячейку на поле
         */
        while (check()) {
            view();
            System.out.println("Введите координаты куда стрелять ");
            fire();
        }
        System.out.println("Игра окончена, вам удалось потопить все корабли за " + shot + " ходов");
    }
}
