package ee.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Enumeration;

/**
 * Запускается при СОЗДАНИИ! сессии и удалении сессии
 */
@WebListener
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("public void sessionCreated(HttpSessionEvent se) {");
        HttpSession session = se.getSession();
        // Добавил новый атрибут в сессиию
        session.setAttribute("SessionListener", new String("SessionListener"));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("public void sessionDestroyed(HttpSessionEvent se) {");
        Enumeration<String> attributeNames = se.getSession().getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            System.out.println(name + " : " + se.getSession().getAttribute(name));
        }
    }
}
