import java.math.BigDecimal;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<Trade> trades = new ArrayList<>();
        trades.add(new Trade("White", "c", new BigDecimal(-100)));
        trades.add(new Trade("White", "c", new BigDecimal(120)));
        trades.add(new Trade("White", "c", new BigDecimal(100)));
        trades.add(new Trade("Black", "b", new BigDecimal(-90)));
        trades.add(new Trade("Grey", "a", new BigDecimal(-310)));
        trades.add(new Trade("Grey", "a", new BigDecimal(310)));
        trades.add(new Trade("Grey", "a", new BigDecimal(-310)));
        trades.add(new Trade("White", "c", new BigDecimal(-50)));
        getErrors(trades);
    }



    private static void getErrors(List<Trade> trades) {
        Map<MyKey, List<BigDecimal>> map = new HashMap<>();
        for(Trade trade: trades) {
            MyKey myKey = new MyKey(trade.getParameter(), trade.getTradeID());
            map.put(myKey, myKey.addValue(trade.getAmount()));

//            map.get(myKey).add(trade.getAmount());
        }
    }
}
