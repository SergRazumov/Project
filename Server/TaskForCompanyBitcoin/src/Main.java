import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //TODO: 1. https://api.coindesk.com/v1/bpi/supported-currencies.json по данному пути, вытащить все трехбуквенные обозначения сформировав HashMap ключ код валюты, значение ключа прочая информация
        // 2. https://api.coindesk.com/v1/bpi/currentprice/<CODE>.json по данному пути, где <CODE> это введеный пользователем в консоли код валюты, выводим тело текущего курса Биткойн, в запрашиваемой валюте, если не существует "Sorry, your requested currency"
        // 3. Отработать запросы по ссылке https://www.coindesk.com/api максимум за последние 30 дней и минимум за последние 30 дней

        // https://ru.stackoverflow.com/questions/745094/%D0%9A%D0%B0%D0%BA-%D0%B8-%D1%87%D0%B5%D0%BC-%D0%BF%D0%B0%D1%80%D1%81%D0%B8%D1%82%D1%8C-json-%D0%BD%D0%B0-java
        try {
            URL url = new URL("https://api.coindesk.com/v1/bpi/supported-currencies.json");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            int status = connection.getResponseCode();
            System.out.println(status + " " + connection.getResponseMessage());
            for (Map.Entry<String, java.util.List<String>> entry : connection.getHeaderFields().entrySet()) {
                if (entry.getKey() != null ) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
            Object myCurrently = new JsonParser().parse(String.valueOf(url));

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
