package ee.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Этот сервлет показывает как использовать инит параметры и очередь загрузки при старте!
 *
 *     <servlet>
 *         <servlet-name>Index</servlet-name>
 *         <servlet-class>ee.servlets.Index</servlet-class>
 *         <init-param>
 *             <param-name>init</param-name>
 *             <param-value>initialization</param-value>
 *         </init-param>
 *         <init-param>
 *             <param-name>first</param-name>
 *             <param-value>first</param-value>
 *         </init-param>
 *         <load-on-startup>0</load-on-startup>
 *     </servlet>
 *     <servlet-mapping>
 *         <servlet-name>Index</servlet-name>
 *         <url-pattern>index</url-pattern>
 *     </servlet-mapping>
 */
public class Index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        outInitParam();
    }

    private void outInitParam() {
        Enumeration<String> initParameterNames = getServletConfig().getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            System.out.println(name + " : " + getServletConfig().getInitParameter(name));
        }
    }
}
