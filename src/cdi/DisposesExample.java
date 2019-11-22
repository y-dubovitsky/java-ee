package cdi;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Disposes! Смотри как помечаются аргументы в методе. Этой аннотацией помечаются
 * те аргументы, которые нужно удалить при вызове.
 */
@WebServlet("/disposes")
public class DisposesExample extends HttpServlet {

    @Inject
    private PC pc;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(pc);
    }
}

class Producerr {

    @Produces
    public PC getPC() {
        return new PC("Mazda");
    }

    //TODO Обрати внимание!
    public void removePC(@Disposes PC pc) {
        pc.remove();
    }
}

class PC {

    String name;

    //TODO Странно, но без объявления именно такого консруктора, пример не будет скомпилирован!
    public PC(String name) {
        this.name = name;
    }

    void remove() {
        System.out.println(PC.class.getCanonicalName() + " removed");
        name = null;
    }
}