package dev.tag.jsp1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Enumeration;

public class SetDefaultParamTag extends TagSupport {

    private int i = 0;
    private String attr;

    //* Constructors and setters
    public SetDefaultParamTag() {
        this.attr = "Default";
    }

    public SetDefaultParamTag(String fromJsp) {
        this.attr = fromJsp;
    }

    //! Через этот метод jsp сетает параметры
    public void setAttr(String attr) {
        this.attr = attr;
    }

    //! Overridden methods
    /**
     * Result:
     *
     * <java-tag:SetDefaultParamTag/> - 1
     * <java-tag:SetDefaultParamTag/> - 2
     * <java-tag:SetDefaultParamTag/> - 3
     * @return
     * @throws JspException
     */
    @Override
    public int doStartTag() throws JspException {
        i++; //! Обрати внимание если мы пишем так, то когда исппользуем этот тег в jsp, значение из предыдущего тега будет сохранено
        System.out.println(i);
        setValue(this.attr, this.attr);
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        //! release(); обнуляем int i.
        try {
            JspWriter out = pageContext.getOut();
            Enumeration<String> values = getValues();
            while (values.hasMoreElements()) {
                out.print(values.nextElement());
            }
            out.flush();
            return EVAL_PAGE;
        } catch (IOException e) {
            throw new JspException(e);
        }
    }

    @Override
    public void release() {
        this.i = 0;
    }
}
