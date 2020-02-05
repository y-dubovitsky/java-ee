package ee.cdi.injection_point;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.logging.*;

@WebServlet("/injpoint")
public class InjectionPointExample extends HttpServlet {

    //TODO ????
    private File file = new File("E:\\log.txt");

    @Inject
    Logger logger;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Работает!
        //ConsoleHandler consoleHandler = new ConsoleHandler();
        //logger.addHandler(consoleHandler);

        //FIXME Не работает! Не пишет в лог файл
        logger.addHandler(new StreamHandler(new FileOutputStream(file), new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getMessage() + " : " + record.getLevel();
            }
        }));
        logger.log(Level.ALL, () -> "This is logger");
        logger.info("hello");
    }

    /**
     * Возвращает обработчик связаный со стримом I/O
     * @param file
     * @return
     */
    private StreamHandler getStreamHandler(File file) {
        StreamHandler streamHandler = null;
            Formatter formatter = new Formatter() {
                @Override
                public String format(LogRecord record) {
                    return record.getMessage() + " : " + record.getLevel();
                }
            };
            // TODO Тут все ОК! Но если ставлю например FileOutputStream то в файл ничего не выводится, хотя файл используется
            streamHandler = new StreamHandler(System.out, formatter);
        return streamHandler;
    }
}
