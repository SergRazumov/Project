import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.DAYS;

public class Main {

    private static String nameBirthday;

    public static void main(String[] args) {
        List<Birthday> list = new ArrayList<Birthday>();
        readFile(list);
        System.out.print("Дней до ближайшего дня рождения " + beforeBirthday(list) + " у " + whatName(nameBirthday));
    }

    private static void readFile(List<Birthday> list) {
        try {
            Scanner scanner = new Scanner(new File("src/Birthday.txt"));
            while (scanner.hasNext()) {
                String line = scanner.next();
                String line1 = scanner.next();
                int day = scanner.nextInt();
                Month month = converter(scanner.next().toUpperCase());
                int year = scanner.nextInt();
                list.add(new Birthday(line, line1, day,month,year));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Month converter(String month) {
        List<String> months = Arrays.asList("ЯНВАРЯ", "ФЕРВРАЛЯ", "МАРТА", "АПРЕЛЯ", "МАЯ", "ИЮНЯ", "ИЮЛЯ", "АВГУСТА", "СЕНТЯБРЯ", "ОКТЯБРЯ", "НОЯБРЯ", "ДЕКАБРЯ");
        int n = months.indexOf(month);
        if(n == -1) return null;
        return Month.of(n+1);
    }

    private static int beforeBirthday(List<Birthday> list) {
        int days = Integer.MAX_VALUE;
        int numberObject = -1;
        for(Birthday date: list) {
           LocalDate time = LocalDate.from(date.getLocalDate());
           time = time.withYear(LocalDate.now().getYear());
           int until = (int) LocalDate.now().until(time, DAYS);
           if(until < 0) { time = time.withYear(LocalDate.now().getYear()+1); until = (int) LocalDate.now().until(time, DAYS); }
           if(days > until) { days = until; }
           if(until == days)  nameBirthday = date.getName();
        }
        return days;
    }

    private static String whatName(String nameBirthday) {
        return nameBirthday;
    }
}
