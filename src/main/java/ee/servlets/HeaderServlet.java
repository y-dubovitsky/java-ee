package ee.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * In this class we output all req HEADERS and try to update some values;
 */
@WebServlet("/header")
public class HeaderServlet extends HttpServlet {

    //TODO Не работает!
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        outHeaders(req);
        setHeaders("user-agent", "000000000000000000000000000000000000000000", resp);
        setHeaders("dnt", "5", resp);
        setHeaders("sec-fetch-site", "1000", resp);
        setHeaders("sec-fetch-user", "15", resp);
        resp.addHeader("Location", "RUSSSSSSSSSSSSSSSSSSSSSSSSSIA");
    }

    /**
     * This method outputs all headers name and parameters;
     * @param req
     */
    private void outHeaders(HttpServletRequest req) {
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            System.out.println(name + " = " + req.getHeader(name));
        }
    }

    /**
     * In this method we change
     * @param resp
     */
    //TODO Почему HEADERs не обновляются?
    public void setHeaders(String before, String after, HttpServletResponse resp) {
        resp.setHeader(before, after);
    }
}
