

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//https://javarush.ru/groups/posts/305-sozdanie-prosteyshego-web-proekta-v-intellij-idea-enterprise-edition-poshagovo-s-kartinkami
//https://javarush.ru/groups/posts/328-sozdanie-prostogo-veb-prilozhenija-na-servletakh-i-jsp-chastjh-1
//https://habr.com/ru/post/333626/
public class TestServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

}


//aa=new TestServlet
//aa.doGet()