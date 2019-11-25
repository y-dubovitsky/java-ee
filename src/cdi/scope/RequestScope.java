package cdi.scope;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * !!! ATTENTION !!! Обрати внимание на @RequestScoped - тут это самое главное.
 * Если мы используем такую аннотацию, то у нас один бин на весь реквест, можно сказать что он СИНГЛЕТОН!
 *
 * @Dependent - если не указывать никакой скоуп, то @Dependent идет по умолчанию
 *
 * @RequestScoped Вывод:
 *
 * BeanClass i = 0
 * ChangeBeanClass i = 1
 * BeanClass i = 1
 */
@WebServlet("/request_scope")
public class RequestScope extends HttpServlet {

    @Inject
    BeanClass beanClass;

    @Inject
    ChangeBeanClass changeBeanClass;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        beanClass.i = 0;
        System.out.println("BeanClass i = " + beanClass.i);
        System.out.println("ChangeBeanClass i = " + changeBeanClass.changeBeanValue());
        System.out.println("BeanClass i = " + beanClass.i);
    }
}

/**
 * @RequestScoped - один бин на весь реквест
 */
@RequestScoped
class BeanClass {
    int i;
}

class ChangeBeanClass {

    /**
     * @RequestScoped - Сюда инжектится один и тот же бин, что и в класс - public class RequestScopedBean
     */
    @Inject
    BeanClass beanClass;

    public int changeBeanValue() {
        beanClass.i = 1;
        return beanClass.i;
    }
}
