package dev.tag.jsp1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class AttrTag extends TagSupport {

    private boolean var;

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            if (var) {
                out.print("yeap");
            } else {
                out.print("nope");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new JspException(e);
        }
        return EVAL_BODY_INCLUDE;
    }

    public void setVar(boolean var) {
        this.var = var;
    }
}
