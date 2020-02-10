package dev.tag.jsp1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

//! Поставь брейкпоинты и посмотри в каком порядке вызываются методы
public class ChangeBodyContentTag extends BodyTagSupport {

    public ChangeBodyContentTag() {
        super();
    }

    @Override
    public int doEndTag() throws JspException {
        BodyContent body = getBodyContent();
        try {
            pageContext.getOut().print(body.getString().toUpperCase());
        } catch (IOException e) {
            throw new JspException(e);
        }
        return EVAL_PAGE;
    }

    //! На этом этапе, getBodyContent(); == null!
    @Override
    public int doStartTag() throws JspException {
        BodyContent bodyContent = getBodyContent();
        try {
            if (bodyContent == null) {
                pageContext.getOut().println("In method public int doStartTag() throws JspException : getBodyContent() == null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    //! апускается после выполнения метода doStartTag() и тут уже объект BodyContent есть!
    @Override
    public void setBodyContent(BodyContent b) { //* BodyContent получается при обработке jsp страницы (поставь там брейк-пойнт) и сетается через этот метод!
        try {
            b.println("public void setBodyContent(BodyContent b) {");
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.setBodyContent(b);
    }

    @Override
    public void doInitBody() throws JspException {
        super.doInitBody();
    }

    @Override
    public int doAfterBody() throws JspException {
        return super.doAfterBody();
    }

    @Override
    public void release() {
        super.release();
    }

    @Override
    public BodyContent getBodyContent() {
        return super.getBodyContent();
    }

    @Override
    public JspWriter getPreviousOut() {
        return super.getPreviousOut();
    }
}
