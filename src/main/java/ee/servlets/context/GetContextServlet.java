package ee.servlets.context;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/getContext")
public class GetContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleBean sm1 = (SimpleBean) getServletContext().getAttribute("first");
        SimpleBean sm2 = (SimpleBean)req.getServletContext().getAttribute("second");
        System.out.println(sm1.getName());
        System.out.println(sm2.getName());
        // get context from another servlet url "/another"
        System.out.println((String)getServletContext().getAttribute("another"));
        contextAttribute(req.getServletContext());
        contextAttribute(getServletContext());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ee/servlets/context/ViewContext.ee.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void contextAttribute(ServletContext sc) {
        Enumeration<String> attributeNames = sc.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            System.out.println(name + " : " + sc.getAttribute(name));
        }
    }
}
