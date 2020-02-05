package ee.cdi;

import ee.cdi.annotations.PersonAnnotation;
import ee.cdi.beans.Humanable;

import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This class describes how we can use @Qualifier and own annotations;
 */
@WebServlet("/qualifier")
public class QualifierExample extends HttpServlet {

    @Inject
    @PersonAnnotation
    Humanable person;

    @Inject
    @WorkerAnnotation
    Humanable worker;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Person: " + person.getName());
        System.out.println("Worker: " + worker.getName());
    }
}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@interface WorkerAnnotation{}

@WorkerAnnotation
class Worker implements Humanable {
    @Override
    public String getName() {
        return "Worker";
    }
}
