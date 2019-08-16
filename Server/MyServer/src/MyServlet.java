import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyServlet extends HttpServlet {

    private final static Map<String, Student> map = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameStud = req.getPathInfo();
        String result = processName(req, resp);
        resp.setStatus(HttpServletResponse.SC_OK);
        if (result!=null && map.get(result)!=null) {
            resp.setContentType("text/html; charset=UTF-8");
            writeString(resp, "<table>");
            writeString(resp, String.format("<tr><td>%s</td><td>%d</td></tr>", result, map.get(result).getGroup()));
            writeString(resp, "</table>");
        } else if (result!=null && map.get(result)==null) {
            resp.setContentType("text/plain; charset=UTF-8");
            writeString(resp, "Информация о студенте " + nameStud.substring(1) + " не обнаружена");
        } else if(result == null && !map.isEmpty()) {
            resp.setContentType("text/html; charset=UTF-8");
            writeString(resp, "<table>");
            for(Map.Entry<String, Student> val:map.entrySet()) {
                writeString(resp, String.format("<tr><td>%s</td><td>%d</td></tr>", val.getKey(), val.getValue().getGroup()));
            }
            writeString(resp, "</table>");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = processName(req, resp);
        Scanner scanner = new Scanner(req.getInputStream()); //получил объект
        while (scanner.hasNext()) {
            map.put(result, new Student(Integer.parseInt(scanner.nextLine())));
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = processName(req, resp);
        Scanner scanner = new Scanner(req.getInputStream()); //получил объект
        while (scanner.hasNext()) {
            if(map.get(result)!=null) {
                map.put(result, new Student(Integer.parseInt(scanner.nextLine())));
                resp.setStatus(HttpServletResponse.SC_OK);
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = processName(req, resp);
        if(map.get(result)!=null) {
            map.remove(result);
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private String processName(HttpServletRequest req, HttpServletResponse resp) {
        String path = req.getPathInfo(); //получил andDot
        System.out.println(path);
        if(path==null) return null; // почему String имеет null адрес?
        Pattern p = Pattern.compile("[a-zA-Zа-яА-я]+");
        Matcher m = p.matcher(path);
        if(m.find()) {
            System.out.println(m.group(0));
            return  m.group(0);
        }
        return null;
    }

    private void writeString(HttpServletResponse response, String message) {
        try {
            response.getWriter().println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
