package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Этот сервлет показывает как устроени жизненный цикл сервлета!
 */
public class ServletLiveCycle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is a doGet method");
        String html =
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "<meta charset=\"utf-8\">" +
                "<title>LiveCycleServlet</title>" +
                "</head>" +
                "<body>" +
                "<h1>Hello from html page</h1>" +
                "<form>\n" +
                "   <p><input value=\"Please input a text\"></p>\n" +
                "   <p><input type=\"submit\" value=\"submit\">\n" +
                "   <input type=\"text\" value=\"text\"></p>\n" +
                "  </form>" +
                "</body>" +
                "</html>";
        PrintWriter writer = resp.getWriter();
        writer.write(html);
    }

    // TODO Почему то не вызывается!
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is a doPost method");
        Enumeration<String> attributeNames = req.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            System.out.println(attributeNames.nextElement());
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is a service method which invoke doGet ao doPos or doPut and etc methods");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy!");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        System.out.println("this method invoke when servlet starting!");
    }
}

