import java.time.LocalDate;
import java.time.Month;

public class Birthday {

    private final String name;
    private final LocalDate localDate;

    public Birthday(String line, String line1, int day, Month month, int year) {
        name = line + " " + line1;
        localDate = LocalDate.of(year, month, day);
    }


    public String getName() {
        return name;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

}
