import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Этот класс показывает как работать с сессиями! Сессия - хранится на сервере.
 */
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getSessionParam(req.getSession());
        HttpSession session = req.getSession();
        session.setAttribute("Person", new User("Caner Show"));
        User user = (User) session.getAttribute("Person");
        System.out.println(user);
    }

    /**
     * Displays some session parameters;
     * @param session
     */
    private void getSessionParam(HttpSession session) {
        System.out.println(session.getId());
        System.out.println(session.getCreationTime());
        System.out.println(session.getMaxInactiveInterval());
        ServletContext context = session.getServletContext();
        Enumeration<String> attributeNames = context.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            System.out.println(attributeNames.nextElement());
        }
    }

    //TODO Не помню чем отличается от обычного.. ну там помню, типа имеет доступ к статик полям и т.д.
    static class User {
        private String name;

        public User(String string) {
            name = string;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
