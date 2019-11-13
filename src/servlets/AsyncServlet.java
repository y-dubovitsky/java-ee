package servlets;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//TODO Не работает
@WebServlet(value = "/sync", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Before " + req.getQueryString());
        AsyncContext context = req.getAsyncContext();
        context.start(() -> {
            for (int i = 0; i < 100_000; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException a) {
                    a.printStackTrace();
                }
            }
        });
        context.complete();
        System.out.println("After " + req.getQueryString());
    }
}
