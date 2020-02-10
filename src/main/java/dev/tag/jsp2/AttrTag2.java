package dev.tag.jsp2;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class AttrTag2 extends SimpleTagSupport {

    int attr;

    public AttrTag2() {
        super();
    }

    public void setAttr(int attr) {
        this.attr = attr;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (attr > 0) {
            JspFragment jspBody = getJspBody(); //! Когда вызывается этот метод, то jspBody еще null!
//!            Не работает почему то... getJspBody().getJspContext().getOut().println("attr = " + attr);
            getJspContext().getOut().println("attr = " + attr);
        } else {
            getJspContext().getOut().println("sorry attr < 0");
        }
    }

    private void validationAttr(int attr) {
        if (attr%2 != 0) {
            System.out.println("Sorry!");
        }
    }
}
