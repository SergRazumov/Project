import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyServlet extends HttpServlet {

    private static Map<String, Student> map = new HashMap<>();


    //TODO: Организовать отправку в .html страницу номера группы

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo(); // получение and Dot
        System.out.println(path);
        resp.setStatus(HttpServletResponse.SC_OK);
        String result = processName(path);
        if (map.get(result)!= null) {
            System.out.println(map.get(result));
        } else {
            System.out.println("Имя ученика еще не создано ");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
//
//        // Формируем относительное имя файла (относительно текущего каталога проекта)
//        String fileName = "." + path;
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                writeString(response, line);
//            }
//            reader.close();
//        } catch (IOException e) {
//            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//            writeString(response, String.format(
//                    "<h2>404 - PAGE NOT FOUND</h2>\n" +
//                            "<p>Sorry, the requested page <code>%s</code> is not found</p>\n",
//                    path));
//        }

    //TODO: Проверить на работоспособность

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo(); //получил andDot
        System.out.println(path);
        String result = processName(path);
        Scanner scanner = new Scanner(req.getInputStream()); //получил объект
        while (scanner.hasNext()) {
            map.replace(result, new Student(Integer.parseInt(scanner.nextLine())));
            resp.setStatus(HttpServletResponse.SC_CONTINUE);
        }
    }

    //TODO: Проверить на работоспособность

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo(); //получил andDot
        System.out.println(path);
        String result = processName(path);
        Scanner scanner = new Scanner(req.getInputStream()); //получил объект
        while (scanner.hasNext()) {
            map.put(result, new Student(Integer.parseInt(scanner.nextLine())));
            resp.setStatus(HttpServletResponse.SC_CONTINUE);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo(); //получил andDot
        System.out.println(path);
        String result = processName(path);
        if(map.get(result)!=null) {
            map.remove(result);
            resp.setStatus(HttpServletResponse.SC_CONTINUE);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private String processName(String path) {
        Pattern p = Pattern.compile("[a-zA-Zа-яА-я]+");
        Matcher m = p.matcher(path);
        if(m.find()) {
            return  m.group(0);
        }
        return null;
    }
}
