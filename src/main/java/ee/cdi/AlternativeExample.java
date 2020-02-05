package ee.cdi;

import ee.cdi.beans.Humanable;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Используется альтернатива! Ну для внедрения зависимости.
 */
@WebServlet("/alternative")
public class AlternativeExample extends HttpServlet {

    @Inject
    Humanable humanable;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(humanable.getName());
    }
}
