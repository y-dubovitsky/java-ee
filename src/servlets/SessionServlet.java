package servlets;

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

    //TODO Я думаю, что так неправильно, потому что для каждого пользователя, запроса своя ссессия, а сервлет
    // один для всех. И получается что и сессия одна для всех!
    // Но мне просто для тестирования SessionListener_a
    private HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setSession(req); // set session!
        getSessionParam(req.getSession());
        HttpSession session = req.getSession();
        session.setAttribute("Person", new User("Caner Show"));
        User user = (User) session.getAttribute("servlets.Person");
        System.out.println(user);
    }

    /**
     * Displays some session parameters;
     * @param session
     */
    private void getSessionParam(HttpSession session) {
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            System.out.println("Session param " + name + " : " + session.getAttribute(name));
        }
    }

    /**
     * Get all context Parameters
     * @param context
     */
    private void getContextParam(ServletContext context) {
        Enumeration<String> attributeNames = context.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            System.out.println(attributeNames.nextElement());
        }
    }

    /**
     * This is just setter
     * @param req
     */
    public void setSession(HttpServletRequest req) {
        this.session = req.getSession();
    }

    /**
     * This method invokes when servlet stops to work;
     */
    @Override
    public void destroy() {
        session.invalidate();
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
