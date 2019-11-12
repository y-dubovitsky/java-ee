import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * В этом сервлете мы посылаем статус ответа и еще JavaScript код.
 */
@WebServlet("/stat")
public class StatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = (int) (Math.random() * 10);
        System.out.println(i);
        switch (i) {
            case 0 : resp.setStatus(HttpServletResponse.SC_OK);
            break;
            case 1 : resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            break;
            case 2 : resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            break;
            case 3 : resp.setStatus(HttpServletResponse.SC_REQUEST_URI_TOO_LONG);
            break;
            case 4: {
                PrintWriter writer = resp.getWriter();
                writer.write("<script>alert(\"Hello\");</script>");
            }
            break;
            case 5 : {
                resp.sendError(HttpServletResponse.SC_BAD_GATEWAY, "HttpServletResponse.SC_BAD_GATEWAY");
            }
            break;
            case 6 : {
                resp.sendRedirect("https://github.com/");
            }
            break;
            default : resp.setHeader("Refresh", "5,URL=https://google.com");
        }
    }
}
