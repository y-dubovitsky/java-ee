package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Этот сервлет возвращает html страницу с формой для отправки с POST запросов
 */
@WebServlet("/param")
public class ParamServlet extends HttpServlet {

    private String XSS;
    private String html = "<html>" +
            "<head>" +
            "<titile>Servlet Parameters</title>" +
            "</head>" +
            "<body>" +
            "<form action=param method=POST>" +
            "<input type=text name=text>" +
            "<input type=submit name=submit>" +
            "</form>" +
            "</body>" +
            "</html>";

    //TODO УЗнать относительно чего указывается путь
    private File file = new File("C:\\Users\\user\\IdeaProjects\\java_ee\\web\\WEB-INF\\resources\\html.txt");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is a doGet method");
        //sendFileResponse(file, resp.getWriter());
        sendStringResponse(html, resp.getWriter());
        getParameters(req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is a doPost method");
        soutParameters(req);
        sendFileResponse(file, resp.getWriter()); // sending html form
        getParameters(req);
    }

    /**
     * This method return all HttpServletRequest req parameters
     * @param req
     */
    private void getParameters(HttpServletRequest req) {
        Map<String, String[]> parameterMap = req.getParameterMap();
        for(String s: parameterMap.keySet()) {
            System.out.println("Param name = " + s);
            Stream.of(parameterMap.get(s)).forEach(System.out::println);
        }
    }

    /**
     * Sending html response from File
     * @param file
     * @param writer
     */
    private void sendFileResponse(File file, Writer writer) {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = br.readLine()) != null) {
                writer.write(str);
            }
        }catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Sending response from string;
     */
    private void sendStringResponse(String str, Writer writer) {
        try{
            writer.write(str);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * This method outputs various parameters from req
     * @param req - HttpServletRequest
     */
    private void soutParameters(HttpServletRequest req) {
        List<String> list = new ArrayList<>();
        list.add(req.getAuthType());
        list.add(req.getScheme());
        list.add(req.getLocalName());
        list.add(req.getRemoteUser());
        list.add(req.getContextPath());
        list.add(req.getRequestURI());
        list.add(req.getServerName());
        list.add(req.getRemoteHost());
        list.stream().forEach(System.out::println);
    }
}
