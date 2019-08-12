package org.ifmo.technologies;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MyHandler extends AbstractHandler {
    private final String root;

    public MyHandler(String root) {
        this.root = root;
    }

    @Override
    public void handle(
            String target,            // request URI
            Request baseRequest,    // базовый (необработанный) request
            HttpServletRequest request,    // запрос, "завернутый" в сервлетную оболочку
            HttpServletResponse response) throws IOException, ServletException {

        System.out.println("Handling request: " + target);
        baseRequest.setHandled(true);
        response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        switch(request.getMethod()) { // возвращает строчку каким методом послан request
            case "GET":
                String fileName = root + target;
                try {
                    File file = new File(fileName);
                    System.out.println(file.getAbsolutePath());
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.getWriter().println(line);
                    }
                    reader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().println("<h2>404 - PAGE NOT FOUND</h2>");
                    response.getWriter().format(
                            "<p>Sorry, the requested page <code>%s</code> is not found</p>\n", target);
                }
                break;
            default:
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println("Bad request");
        }
    }
}
