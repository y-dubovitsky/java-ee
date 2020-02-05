package ee.cdi;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Этот класс показывает как использовать dependencies injection;
 */
@WebServlet("/di")
public class DIExample extends HttpServlet {

    @Inject
    Injected injected;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(injected.getName());
    }
}

/**
 * класс, специально для инжекта
 */
class Injected {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


