package cdi.scope.conversation_app;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//TODO Доделай, не понятно как ConversationBean должен шариться между сервлетами! Не работает!
@WebServlet("/start_conv")
public class Starting extends HttpServlet {

    @Inject
    Bean bean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(bean.name); // null
        bean.startConversation();
        System.out.println(bean.name); // null
    }
}
