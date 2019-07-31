package org.ifmo.technologies;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestRequest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/Jetty01/index.html");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            int status = connection.getResponseCode();
            System.out.println(status + " " + connection.getResponseMessage());
            for (var entry : connection.getHeaderFields().entrySet()) {
                if (entry.getKey() != null ) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
            System.out.println();
            InputStream is = null;
            is = (status < 300 ? connection.getInputStream() : connection.getErrorStream());
            Scanner scanner = new Scanner(is);
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
