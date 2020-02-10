package dev.tag.jsp2;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class HTag2 extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        StringWriter writer = new StringWriter();
        writer.write("public void doTag() throws JspException, IOException {"); //* Записали строку в поток
        getJspBody().invoke(writer); //!  в writer дописываем содержимое тела тэга
        getJspContext().getOut().println(writer.toString());
    }
}
