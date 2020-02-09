package ee.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This is a simple servlet with web.xml configuration
 */
public class HelloServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger("Example App");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("HelloServlet logger");
        PrintWriter writer = resp.getWriter();
        writer.write("Hello from " + this.getClass().getName());
    }
}
