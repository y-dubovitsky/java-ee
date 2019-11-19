package servlets.context;

import jsp.beans.Person;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Тут демонстрируется что такое контекст и как с ним взаимодействовать в разных сервлетах
 */
@WebServlet("/setContext")
public class SetContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleBean s1 = new SimpleBean();
        SimpleBean s2 = new SimpleBean();
        contextEquals(req); // invoke private method
        s1.setName("One");
        s2.setName("Two");
        getServletContext().setAttribute("first", s1);
        req.getServletContext().setAttribute("second", s2);
        contextAttribute(req.getServletContext());
        contextAttribute(getServletContext());
    }

    /**
     * Let_s see changes!
     * //TODO Я не помню в чем разнца, ну точнее помню, но посмотри еще раз
     * @param req
     */
    private void contextEquals(HttpServletRequest req) {
        if (req.getServletContext() == getServletContext()) {
            System.out.println("==");
        }
        if (req.getServletContext().equals(getServletContext())) {
            System.out.println("equals");
        }
    }

    private void contextAttribute(ServletContext sc) {
        Enumeration<String> attributeNames = sc.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            System.out.println(name + " : " + sc.getAttribute(name));
        }
    }
}
