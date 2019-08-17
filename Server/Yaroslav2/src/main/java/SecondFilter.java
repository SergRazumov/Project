import javax.servlet.*;
import java.io.IOException;

public class SecondFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("I am second filter");
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
