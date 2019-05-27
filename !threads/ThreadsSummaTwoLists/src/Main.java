import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> listValue1 = new ArrayList<>();
        List<Integer> listValue2 = new ArrayList<>();
        Lists list = new Lists(listValue1, listValue2,20);
        list.writeValueList();
        list.reader.start();
        try {
            list.reader.join();
        } catch (InterruptedException e) {
            System.out.print(list.getValue());
        }
        System.out.println("Сумма значений нового списка; " +list.getValue());

    }
}
