package ee.cdi.scope;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@WebServlet("/conversation")
public class ConversationScope extends HttpServlet {

    @Inject
    Bean bean;

    /**
     * Что получается,
     * один бин i = 0, 1, 1, 3, 3
     * второй бин i = 0, 1904, 1904
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(bean.i); // one i = 0
        bean.i = 1; // one i = 1
        bean.startConversation(); // two i = 0, i = 1904
        System.out.println(bean.i); // one i = 1
        System.out.println("various actions");
        bean.i = 3; // one i = 3
        bean.endConversation(); // two i = 1904
        System.out.println(bean.i); // one i = 3
    }
}

@ConversationScoped
class Bean implements Serializable {

    int i;

    @Inject
    Conversation conversation;

    public void startConversation() {
        System.out.println(i);
        System.out.println("startConversation");
        // тут в дело вступает уже другой бин, у которого мы меняем значение
        // т.е. мы начали разговор, задали одно значение и на протяжении всего conversation оно будет использоваться
        conversation.begin();
        i = 1904;
    }

    public void endConversation() {
        System.out.println(i);
        System.out.println("endConversation");
        conversation.end();
    }
}
