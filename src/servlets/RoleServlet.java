package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * В этом сервлете показано, как можно использовать "роли" пользователя!
 */
public class RoleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.isUserInRole("Great Murder")) {
            resp.getWriter().write("You are the most dangerous murder!");
        } else {
            resp.getWriter().write("Please Log in");
        }
        String remoteUser = req.getRemoteUser();
        System.out.println(remoteUser);
        Principal userPrincipal = req.getUserPrincipal();
        System.out.println(userPrincipal.getName());
    }
}
