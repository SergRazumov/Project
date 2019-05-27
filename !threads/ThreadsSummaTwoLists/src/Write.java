import java.util.List;

public class Write extends Thread {

    private int listValue1;
    private int listValue2;
    private List<Integer> listComposition;


    public Write(int valueList1, int valueList2, List<Integer> listComposition) {
        this.listValue1 = valueList1;
        this.listValue2 = valueList2;
        this.listComposition = listComposition;
    }

    @Override
    public void run() {
        synchronized (listComposition) {
            try {
                while (listComposition.size() >= 10) listComposition.wait();
            } catch (InterruptedException e) {}
            listComposition.add(listValue1 + listValue2);
            listComposition.notifyAll();
        }
    }

}
