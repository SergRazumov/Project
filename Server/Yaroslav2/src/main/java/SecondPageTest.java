import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecondPageTest extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Initional of SecondPageContext");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("I am in get method");
        String varTextA = "i add this text to jsp!";
        req.setAttribute("textA", varTextA);
        req.getRequestDispatcher("secondPage.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy of SecondPageContext");
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("we try to find which method was called");
        super.service(req, resp);
    }
}
