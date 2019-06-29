import java.math.BigDecimal;

public class Trade {
    private final String tradeID;
    private final String parameter;
    private final BigDecimal amount;

    public Trade(String tradeID, String parameter, BigDecimal amount) {
        this.tradeID = tradeID;
        this.parameter = parameter;
        this.amount = amount;
    }

    public String getTradeID() {
        return tradeID;
    }

    public String getParameter() {
        return parameter;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
