package ee.cdi.scope;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Dependent - идет по умолчанию для всех Бинов. Эта аннотация означает, что при каждом инжекте,
 * внедряется новый Бин.
 */
@WebServlet("/dependet_scope")
public class DependentScope extends HttpServlet {

    @Inject
    DependetBean dependetBean;

    @Inject
    InjectedDependetBean injectedDependetBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dependetBean.setI(5);
        System.out.println(dependetBean.getI());
        injectedDependetBean.changeInjectedBean(124214);
        System.out.println(dependetBean.getI());
        System.out.println(injectedDependetBean.dependetBean.getI());
        System.out.println(dependetBean.getI());
    }
}

@Dependent
class DependetBean {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

class InjectedDependetBean {

    @Inject
    DependetBean dependetBean;

    public void changeInjectedBean(int i) {
        dependetBean.setI(i);
    }

    public DependetBean getDependetBean() {
        return dependetBean;
    }

    public void setDependetBean(DependetBean dependetBean) {
        this.dependetBean = dependetBean;
    }
}