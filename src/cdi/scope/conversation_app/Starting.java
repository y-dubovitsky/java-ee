package cdi.scope.conversation_app;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Чтобы работало нужно сделать:
 *
 * RequestDispatcher requestDispatcher = req.getRequestDispatcher("/end_conv");
 * requestDispatcher.forward(req, resp);
 */
@WebServlet("/start_conv")
public class Starting extends HttpServlet {

    @Inject
    Bean bean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(bean.name); // null
        bean.startConversation();
        System.out.println("FORWARD!");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/end_conv");
        requestDispatcher.forward(req, resp);
        System.out.println(bean.name); // null
    }
}
