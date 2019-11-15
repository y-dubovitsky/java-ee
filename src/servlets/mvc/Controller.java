package servlets.mvc;

import servlets.mvc.beans.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {

    /**
     * Model from pattern MVC
     */
    Model model;

    public Controller() {
        this.model = new Model();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = model.getPerson();
        Person person1 = model.getPerson();
        Person person3 = model.getPerson();
        // Имя Параметра(Бина) должно быть таким же как и в view.jsp
        req.getSession().setAttribute("person", person);
        req.getServletContext().setAttribute("person1", person1);
        // Как я понимаю области видимости только эта страница scope="page"
        req.setAttribute("person3", person3);
        RequestDispatcher rd = req.getRequestDispatcher("/servlets/mvc/view.jsp");
        rd.forward(req, resp);
    }
}
