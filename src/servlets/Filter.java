package servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Этот класс показывает, как пишутся фильтры для сервлетов
 *
 *     <filter>
 *         <filter-name>Filter</filter-name>
 *         <filter-class>servlets.Filter</filter-class>
 *         <init-param>
 *             <param-name>namespace</param-name>
 *             <!-- Это просто строка а не ссылка на Бин -->
 *             <param-value>servlets.mvc.beans.Person</param-value>
 *         </init-param>
 *     </filter>
 *     <filter-mapping>
 *         <filter-name>Filter</filter-name>
 *         <url-pattern>/filtered</url-pattern>
 *         <url-pattern>/param</url-pattern>
 *         <servlet-name>FirstServlet</servlet-name>
 *     </filter-mapping>
 */
@WebFilter(value = "/filtered", initParams = @WebInitParam(name = "first", value = "value"))
public class Filter implements javax.servlet.Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("We use init from servlets.Filter");
        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            System.out.println(name + " : " + filterConfig.getInitParameter(name));
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.getWriter().write("Before filterChain.doFilter(servletRequest, servletResponse);");
        filterChain.doFilter(servletRequest, new WrapperServletResponse((HttpServletResponse) servletResponse));
        servletResponse.getWriter().write("After filterChain.doFilter(servletRequest, servletResponse);");
    }

    @Override
    public void destroy() {
        System.out.println("We use destroy from servlets.Filter");
    }
}

/**
 * Just a wrapper
 */
class WrapperServletResponse extends HttpServletResponseWrapper {

    public WrapperServletResponse(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        System.out.println("We use WrapperServletResponse");
        return super.getWriter();
    }

    public void myMethod() {
        System.out.println("Trololol");
    }
}
