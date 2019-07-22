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
        Map<MyKey, List<BigDecimal>> map = makeMap(trades);
        System.out.println(removeValue(map));

    }


    private static Map<MyKey, List<BigDecimal>> makeMap(List<Trade> trades) {
        Map<MyKey, List<BigDecimal>> map = new HashMap<>();
        for(Trade trade: trades) {
            MyKey myKey = new MyKey(trade.getParameter(), trade.getTradeID());
            if(map.containsKey(myKey)) {
                map.get(myKey).add(trade.getAmount());
            } else {
                map.put(myKey, myKey.addValue(trade.getAmount()));
            }
        }
        return map;
    }

    private static List<BigDecimal> removeValue(Map<MyKey, List<BigDecimal>> map) {
        List<BigDecimal> removedNotPairValue = new ArrayList<>();
        for(List<BigDecimal> list:map.values()) {
            Collections.sort(list);
            int i = 0;
            int j = list.size()-1;
            int current = 0;
            while(i<j) {
               current =  list.get(i).abs().compareTo(list.get(j).abs());
                if(current ==0) {
                    i++;
                    j--;
                } else if (current == -1) {
                    removedNotPairValue.add(list.get(j));
                    j--;
                } else {
                    removedNotPairValue.add(list.get(i));
                    i++;
                }
            }
            if(list.get(i).abs().equals(list.get(j).abs()) && list.get(i).equals(list.get(j))) {removedNotPairValue.add(list.get(i));}
        }

        return removedNotPairValue;
    }


}
