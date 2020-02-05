package ee.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Это сервлет, который первоначально фильтруется
 */
@WebServlet("/filtered")
public class FilterServlet extends HttpServlet {
    /**
     * Standard doGet method
     * @param req
     * @param resp - WrapperServletResponse from package ee.servlets.FilterServlet;
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("\n<h1>" + this.getClass().getCanonicalName() +"</h1>\n");
        // Wrapper
        WrapperServletResponse resp1 = (WrapperServletResponse) resp;
        resp1.myMethod();
    }
}
