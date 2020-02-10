package dev.tag.jsp2;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StaticTag2 extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().println("StaticTag2 : " + new SimpleDateFormat("yyMMddHHmmssZ").format(new Date()));
    }
}
