package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This servlet show us, how to set cookie
 * Посмотреть cookie вы можете в GoogleChrome нажам F12
 */
@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    /**
     * html form
     */
    private String action = "<!DOCTYPE HTML>\n" +
            "<html>\n" +
            " <head>\n" +
            "  <meta charset=\"utf-8\">\n" +
            "  <title>Тег INPUT</title>\n" +
            " </head>\n" +
            " <body>\n" +
            "\n" +
            " <form name=\"test\" method=\"post\" action=\"cookie\">\n" +
            "  <p><b>Ваше имя:</b><br>\n" +
            "   <input type=\"text\" size=\"40\">\n" +
            "  </p>\n" +
            "  <p><b>Каким браузером в основном пользуетесь:</b><Br>\n" +
            "   <input type=\"radio\" name=\"browser\" value=\"ie\"> Internet Explorer<Br>\n" +
            "   <input type=\"radio\" name=\"browser\" value=\"opera\"> Opera<Br>\n" +
            "   <input type=\"radio\" name=\"browser\" value=\"firefox\"> Firefox<Br>\n" +
            "  </p>\n" +
            "  <p>Комментарий<Br>\n" +
            "   <textarea name=\"comment\" cols=\"40\" rows=\"3\"></textarea></p>\n" +
            "  <p><input type=\"submit\" value=\"Отправить\">\n" +
            "   <input type=\"reset\" value=\"Очистить\"></p>\n" +
            " </form>\n" +
            "\n" +
            " </body>\n" +
            "</html>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setCookie(resp); // setCookies
        getCookie(req);
        System.out.println(req.getQueryString()); // return query string from URL address
        // Пришлось добавить кодировку, так как без нее выводил абра-кадабру
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(resp.getOutputStream(), StandardCharsets.UTF_8));
        writer.write(action);
        writer.flush();
    }

    /**
     * Gets Post request and output him like a string;
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("browser"));
    }

    /**
     * Get all client_s cookies and output on the console
     * @param req
     */
    private void getCookie(HttpServletRequest req) {
        Cookie[] cookie = req.getCookies();
        for (int i = 0; i < cookie.length; i++) {
            System.out.println(cookie[i].getName() + " " + cookie[i].getValue());
        }
    }

    /**
     * Отправляет все куки пользователю(клиенту)
     * @param resp
     */
    private void setCookie(HttpServletResponse resp) {
        Iterator<Cookie> cookieIterator = getPersonCookies(new Person("Matthey", 45)).iterator();
        while (cookieIterator.hasNext()) {
            resp.addCookie(cookieIterator.next());
        }
    }

    /**
     * Get some param from servlets.Person and add to the Cookie;
     * @param person
     * @return
     */
    private List<Cookie> getPersonCookies(Person person) {
        List<Cookie> cookieList = new ArrayList<>();
        cookieList.add(new Cookie("name", person.getName()));
        cookieList.add(new Cookie("age", String.valueOf(person.getAge())));
        return cookieList;
    }
}

/**
 * Simple User_s class;
 */
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
