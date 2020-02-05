package ee.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

/**
 * В этом сервлете используется gzip для уменьшения объема пересылаемого ответа
 */
@WebServlet("/gzip")
public class GzipServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getHeader("Accept-Encoding").contains("gzip")) {
            PrintWriter writer = new PrintWriter(new GZIPOutputStream(resp.getOutputStream()));
            writer.write("<h1>Hello my Friend</h1>");
        }
    }
}
