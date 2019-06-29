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
        System.out.print(getErrors(trades));
    }



    private static Set<Integer> getErrors(List<Trade> trades) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for(Trade trade: trades) {
            if(trade.getAmount().intValue()<=0) {
                set.add(trade.getAmount().intValue());
            }
        }
        for(Trade trade: trades) {
            if(set.contains(Math.abs(trade.getAmount().intValue()))) {
                set.remove(trade.getAmount().intValue());
                trades.remove(trade);
            }
        }
        for(Trade trade: trades) {
            set.add(trade.getAmount().intValue());
        }
        return set;
    }
}
