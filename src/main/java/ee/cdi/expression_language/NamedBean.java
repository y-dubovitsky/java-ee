package ee.cdi.expression_language;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named(value = "name")
public class NamedBean {

    private String value = "25-Nov-2019 17:31:27.495 INFO [Catalina-utility-2]";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
