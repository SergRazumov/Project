import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lists {

    private List<Integer> listValue1;
    private List<Integer> listValue2;
    private List<Integer> listComposition = new ArrayList<>();
    private int value;
    private int count;

    public Lists(List<Integer> listValue1, List<Integer> listValue2,int count) {
        this.listValue1 = listValue1;
        this.listValue2 = listValue2;
        this.count = count;
        generateValue(listValue1, listValue2, count);
    }

    public void writeValueList() {
        while (!listValue1.isEmpty() || !listValue2.isEmpty()) {
            Write p = new Write(listValue1.remove(0), listValue2.remove(0), listComposition);
            p.start();
        }
    }

    Thread reader = new Thread(() -> {
        int cnt = 0;
        while (cnt < count) {
            synchronized (listComposition) {
                try {
                    while (listComposition.isEmpty())
                        listComposition.wait();
                    value += listComposition.remove(0);
                    cnt++;
                    listComposition.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }, "read");

    public int getValue() {
        return value;
    }

    public void generateValue(List<Integer> listValue1, List<Integer> listValue2, int count) { // были вопросы с параметризацией
        Random rnd = new Random();
        for (int i = 0; i < count; i++) {
            listValue1.add(rnd.nextInt(10));
            listValue2.add(rnd.nextInt(10));
        }
    }
}
