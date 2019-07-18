import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyKey {

    private final String tradeID;
    private final String parameter;
    private List<BigDecimal> listAmount;


    public MyKey(String parameter, String tradeID) {
        this.tradeID = tradeID;
        this.parameter = parameter;
    }

    public List<BigDecimal> addValue(BigDecimal value) {
        listAmount = new ArrayList<>();
        listAmount.add(value);
        return listAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyKey myKey = (MyKey) o;
        return Objects.equals(tradeID, myKey.tradeID) &&
                Objects.equals(parameter, myKey.parameter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tradeID, parameter);
    }

    public List<BigDecimal> getListAmount() {
        return listAmount;
    }
}
