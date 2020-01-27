package cdi.expression_language;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Этот сервлет просто перенаправляет бин в .jsp которая используя expression_language его использует
 */
@WebServlet("/expression_lang")
public class ExpressionLanguageBeans extends HttpServlet {

    @Inject
    NamedBean namedBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/get_named_bean");
        dispatcher.forward(req, resp);
    }
}