import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("a(bc)d");
        Matcher m1 = p1.matcher("  abcd  ");
        if (m1.find()) {
            System.out.println("Matches 1 : [" + m1.group(0) + "] [" + m1.group(1) + "]");
            System.out.println(m1.end());
            System.out.println(m1.groupCount());
        } else {
            System.out.println("No match");
        }

        Pattern p2 = Pattern.compile(" *[2-5]+");
        Matcher m2 = p2.matcher("2 4 6   3 24 45621 ");
        int index = 0;
        while (m2.find(index)) {
            System.out.println("Found: [" + m2.group(0) + "]");
            index = m2.end();
        }
        System.out.println();

        Pattern p3 = Pattern.compile("(\\w{1,3})\\s*");
        Matcher m3 = p3.matcher(" 234 ghj 678 ui786hj8");
        index = 0;
        while (m3.find(index)) {
            System.out.println("Found: [" + m3.group(1) + "]");
            index = m3.end();
        }
        System.out.println();

        Pattern studLine = Pattern.compile("(?<name>(([а-яА-Я]+)\\s+){2,3})(?<group>\\d{3,4})\\s+(?<marks>(\\s*[2-5])+)");
        Matcher studMatch = studLine.matcher("Иванов  Иван  Иванович  234 2 5 4 4");
        if (studMatch.matches()) {
            System.out.println(studMatch.groupCount());
            System.out.println("Ура! [" + studMatch.group("name") + "] [" + studMatch.group("group") + "] [" + studMatch.group("marks") + "]");
        } else {
            System.out.println("Увы!");
        }
    }
}
