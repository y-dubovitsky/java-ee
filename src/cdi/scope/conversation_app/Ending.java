package cdi.scope.conversation_app;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/end_conv")
public class Ending extends HttpServlet {

    @Inject
    Bean bean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ending " + bean.name);
        bean.endConversation();
        System.out.println("One more ending " + bean.name);
    }
}
