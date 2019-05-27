import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static void readWords(String fileName, Dictionary d) {
        // TODO: реализовать чтение слов из файла и запись их в заданный словарь.
        try (Scanner scan = new Scanner(new File(fileName))) {
            while (scan.hasNext()) {
                d.add(scan.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Dictionary setDict = new SetDictionary();
        readWords("dictionary.txt", setDict);
        if (setDict.contains("дядя")) {
            setDict.remove("Мой");
            setDict.remove("дядя");
            setDict.remove("самых");
            setDict.remove("честных");
            setDict.remove("правил");
        }
        System.out.println("SetDictionary:\n--------------");
        for (String word : setDict) {
            System.out.println(word);
        }
        System.out.println();

        Dictionary sortedDict = new SortedDictionary();
        readWords("dictionary.txt", sortedDict);
        if (sortedDict.contains("дядя")) {
            sortedDict.remove("Мой");
            sortedDict.remove("дядя");
            sortedDict.remove("самых");
            sortedDict.remove("честных");
            sortedDict.remove("правил");
        }
        System.out.println("SortedDictionary:\n-----------------");
        for (String word : sortedDict) {
            System.out.println(word);
        }
        System.out.println();

        Dictionary hashDict = new HashDictionary();
        readWords("dictionary.txt", hashDict);
        if (hashDict.contains("дядя")) {
            hashDict.remove("Мой");
            hashDict.remove("дядя");
            hashDict.remove("самых");
            hashDict.remove("честных");
            hashDict.remove("правил");
        }
        System.out.println("HashDictionary:\n---------------");
        for (String word : hashDict) {
            System.out.println(word);
        }
        System.out.println();
    }
}
