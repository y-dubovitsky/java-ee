package dev.tag.jsp2;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

//! Поставь брейк поинты и посмотри в каком порядке вызываются методы и как переменным значения присваиваются
public class LoopTag2 extends SimpleTagSupport {

    private int iterate;

    public LoopTag2() {
        setDefaultIterate();
    }

    @Override
    public void doTag() throws JspException, IOException {
        while (iterate > 0) {
            StringWriter writer = new StringWriter();
            getJspBody().invoke(writer);
            getJspContext().getOut().println(writer.toString() + " iterate " + iterate + "</br>"); //* Записывае содержимое body
            iterate--;
        }
    }

    public void setDefaultIterate() {
        this.iterate = 5;
    }

    public void setIterate(int iterate) {
        this.iterate = iterate;
    }
}
