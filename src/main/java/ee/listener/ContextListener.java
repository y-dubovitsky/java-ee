package ee.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * При создании контекста запускается КОД
 */
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Enumeration<String> initParameterNames = sce.getServletContext().getInitParameterNames();
        Iterator<String> iterator = initParameterNames.asIterator();
        Stream.of(iterator).forEach(x -> {
            System.out.println("ContextListener : " + x);
        });
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
