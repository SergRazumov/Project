public class Main {
    public static void main(String[] args) {

        CircleList list = new CircleList();
        try {
            for (int i = 0; i < 4; i++) {
                list.add(i * 3);
            }
            System.out.println(list);
            list.reverse();
            System.out.println("Наоборот" + list);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
