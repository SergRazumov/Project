import com.google.gson.*;

import javax.swing.text.html.HTMLDocument;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Connection;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class WorkWithCurrency {

    final static WorkWithCurrency work = new WorkWithCurrency();

    protected void run() {
        System.out.println("For exit press q:\nВведите запрос для получения текущего курса биткойнов в запрашиваемой валюте https://api.coindesk.com/v1/bpi/currentprice/<CODE>.json где <CODE> это код валюты или ...");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String myRequestLine = scanner.next();
           // if (myRequestLine.equals("q")) {connection.disconnect(); break;}
            try {
                URL url = new URL(myRequestLine);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                int status = connection.getResponseCode();
                if (status < 300) {
                    for (Map.Entry<String, java.util.List<String>> entry : connection.getHeaderFields().entrySet()) {
                        if (entry.getKey() != null) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
                    }
                    StringBuilder resultJson = new StringBuilder();
                    //Обработка запроса
                    //System.out.println(connection.getContentType());
                    scanner = new Scanner(connection.getInputStream());
                    while (scanner.hasNext()) {
                        resultJson.append(scanner.nextLine());
                    }
                    System.out.println(resultJson);
                    if(connection.getContentLength()==508) {
                    bitcoinRateInCurrentCurrency(resultJson, myRequestLine);
                    } else if(connection.getContentLength()==300) {
                    bitcoinMaxAndMinLast30day(resultJson);
                    }
                } else {
                    incorrectInput(connection, scanner);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void bitcoinMaxAndMinLast30day(StringBuilder resultJson) {

    }

    private void bitcoinRateInCurrentCurrency(StringBuilder resultJson, String myRequestLine) {
        String currency = myRequestLine.substring(myRequestLine.length()-8,myRequestLine.length()-5).toUpperCase();
        Object myCurrently = new JsonParser().parse(resultJson.toString());
        JsonObject jo = (JsonObject) myCurrently;
        JsonObject fieldBpi = (JsonObject) jo.get("bpi");
        JsonObject fieldCurrency = (JsonObject) fieldBpi.get(currency);
        System.out.println(currency + ": " + fieldCurrency.get("rate_float"));
    }

    private void incorrectInput(HttpURLConnection connection, Scanner scanner) {
        InputStream is = connection.getErrorStream();
        scanner = new Scanner(is);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }


//    //TODO:
//    // 2. https://api.coindesk.com/v1/bpi/currentprice/<CODE>.json по данному пути, где <CODE> это введеный пользователем в консоли код валюты, выводим тело текущего курса Биткойн, в запрашиваемой валюте, если не существует "Sorry, your requested currency"
//    // 3. Отработать запросы по ссылке https://www.coindesk.com/api максимум за последние 30 дней и минимум за последние 30 дней
//
//    // https://ru.stackoverflow.com/questions/745094/%D0%9A%D0%B0%D0%BA-%D0%B8-%D1%87%D0%B5%D0%BC-%D0%BF%D0%B0%D1%80%D1%81%D0%B8%D1%82%D1%8C-json-%D0%BD%D0%B0-java
//        try {
//        URL url = new URL("https://api.coindesk.com/v1/bpi/supported-currencies.json");
//        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
//        connection.setRequestMethod("GET");
//        int status = connection.getResponseCode();
//
//        System.out.println(status + " " + connection.getResponseMessage());
//        for (Map.Entry<String, java.util.List<String>> entry : connection.getHeaderFields().entrySet()) {
//            if (entry.getKey() != null ) {
//                System.out.println(entry.getKey() + ": " + entry.getValue());
//            }
//        }
//        //   Object myCurrently = new JsonParser().parse(String.valueOf(url));
//        System.out.println(connection.getContentType());
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
}





