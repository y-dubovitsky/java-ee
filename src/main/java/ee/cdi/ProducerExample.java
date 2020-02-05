package ee.cdi;

import javax.enterprise.inject.Produces;
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
 * Класс описывает как использовать @Produces
 */
@WebServlet("/producer")
public class ProducerExample extends HttpServlet {

    // Обрати внимание, на то как объявляется аннотация! Она определена во внутреннем классе
    @Inject
    @Producer.NamedInner
    private String name;

    @Inject
    String secondName;

    @Inject
    private double aDouble;

    @Inject
    private OuterClass outerClass;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(name);
        System.out.println(aDouble);
        System.out.println(secondName);
        outerClass.doAction();
    }
}

// Аннотация за пределеами класса
@Qualifier
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface OuterClazz {}

/**
 * Внешний класс который мы будем инжектить
 */
class OuterClass {

    String name;

    public OuterClass(String name) {
        this.name = name;
    }

    public void doAction() {
        System.out.println(this.getClass().getCanonicalName());
    }
}

class Producer {

    @Produces
    @NamedInner
    String secondName = "Second Name;";

    /**
     * Аннотация объявлена Внутри класса
     */
    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface NamedInner {}

    @Produces
    public double getDouble() {
        return 124.5;
    }

    @Produces
    OuterClass getOuterClass() {
        return new OuterClass("21-Nov-2019 18:22:12.355 INFO [Catalina-utility-1] org.apache.jasper.servlet.TldScanner.scanJars At least one JAR was scanned for TLDs yet contained no TLDs. Enable debug logging for this logger for a complete list of JARs that were scanned but no TLDs were found in them. Skipping unneeded JARs during scanning can improve startup time and JSP compilation time.\n");
    }

//    Не работает!
//    @Produces
//    private InnerProducer getInner() {
//        return new InnerProducer();
//    }

    /**
     * Внимание! Этот класс должен быть статическим! Потому что managed бины не могут быть не статическими!
     */
    static class InnerProducer {

        public InnerProducer() {}

        @Produces
        public String getInnerClassValue() {
            return this.getClass().getCanonicalName();
        }
    }
}
