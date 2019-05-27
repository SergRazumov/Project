import java.util.Iterator;

public class MainForIter {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.add(2*i);
        }

        int s = 0;
        for (Integer i : list) {
            s += i;
        }
        System.out.println(s);

        s = 0;
        for (Iterator<Integer> iter = list.iterator(); iter.hasNext(); ) {
            list.reverse();
            s += iter.next();
        }
        System.out.println(s);
    }
}
