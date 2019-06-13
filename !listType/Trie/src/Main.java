import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Trie<Translation> trie = new Trie<>();
        trie.add("bit", new Translation("бит", 3));
        trie.add("byte", new Translation("байт", 4));
        trie.add("big", new Translation("большой", 7));
        trie.add("site", new Translation("сайт", 4));
        trie.add("sit", new Translation("сидеть", 6));
        trie.add("sign", new Translation("подпись", 7));
        trie.viewRoot();

        Scanner scan = new Scanner(System.in);
        String key, command;
        do {
            System.out.print("Введите команду (g[et], r[emove]), q[uit] ");
            command = scan.next();
            if (command.trim().charAt(0) == 'q') break;
            System.out.print("Введите ключ ");
            key = scan.next();
            switch (command.trim().charAt(0)) {
                case 'g' :
                    System.out.println("Результат поиска: [" + trie.get(key) + "]");
                    break;
                case 'r':
                    System.out.println("Удалено: [" + trie.remove(key) + "]");
                    break;
                default:
                    System.out.println("Неизвестная команда: " + command);
            }
        } while (true);
    }
}
