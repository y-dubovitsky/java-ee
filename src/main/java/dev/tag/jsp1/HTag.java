package dev.tag.jsp1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Arrays;


public class HTag extends TagSupport {

    private String type;

    public HTag() {
        setTypeDefault();
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().println("<" + type + ">");
            return EVAL_BODY_INCLUDE;
        } catch (IOException i) {
            throw new JspException(i);
        }
    }

    @Override
    public int doEndTag() throws JspException {
        try {
             pageContext.getOut().println("</" + type + ">"); //! создать переменную и попробовать write flush
            return EVAL_PAGE;
        } catch (IOException e) {
            throw new JspException(e);
        }
    }

    public void setTypeDefault() {
        this.type = "h5";
    }

    public void setType(String type) {
        if (type != null) { //! Добавить если не contain а например фпфупуцп придет
            if (Arrays.asList("h1","h2","h3","h4","h5").contains(type.toLowerCase())) {
                this.type = type;
            }
        }
    }
}
