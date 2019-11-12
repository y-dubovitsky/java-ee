import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Тут демонстрируется как использовать синхронизацию в сервлете и как посылать запросы.
 * Объект сервлет - один, и только он один обрабатывает все входящие запросы, поэтому
 * если он работает с общими ресурсами, то нужна синхронизация
 */
@WebServlet("/multi")
public class MultithreadServlet extends HttpServlet {

    /**
     * Общий ресур
     */
    static String str = "null";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(Thread.currentThread().getName());
        Writer writer = resp.getWriter();
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                str = str + Math.random();
            }
        }
        System.out.println(str);
        writer.write(str);
    }
}

/**
 * Этот класс посылает запросы нашему сервлету в разных потоках,
 * и получает от него ответ
 */
class SendRequest {

    public Runnable runnable() {
        Runnable runnable = () -> {
            try {
                URLConnection connection = new URL("http://localhost:8080/java_ee_war_exploded/multi").openConnection();
                // Получаем ответ от сервера
                InputStreamReader reader = new InputStreamReader(connection.getInputStream());
                int i;
                while ((i = reader.read()) != -1) {
                    System.out.print((char) i);
                }
            } catch (IOException i) {
                i.printStackTrace();
            }
        };
        return runnable;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new SendRequest().runnable()).start();
        }
    }
}
