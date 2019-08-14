import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(8080);
        System.out.println(System.getProperty("user.dir"));
        ServletHandler handler = new ServletHandler();
        System.out.println();
        handler.addServletWithMapping(MyServlet.class, "/stud/*");
        server.setHandler(handler);
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
