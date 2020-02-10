package dev.tag.jsp1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Последовательность работы сервлета с циклом!
 *
 * doStartTag() - 1
 * Loop Tag - tag body
 * doAfterBody()
 * Loop Tag
 * doAfterBody()
 * Loop Tag
 * doAfterBody()
 * Loop Tag
 * doAfterBody()
 * Loop Tag
 * doAfterBody()
 * doEndTag() - 3
 */
public class LoopTag extends TagSupport {

    private int loop;

    //! Этот тег использует то ли контейнер то ли jsp для установки параметра из этой строки
    //! <java-tag:LoopTag loop="5"></java-tag:LoopTag>
    public void setLoop(int loop) {
        this.loop = loop;
    }

    public int getLoop() {
        return loop;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            int result;
            if (this.loop > 0) {
                result = EVAL_BODY_INCLUDE;
            } else {
                result = SKIP_BODY;
            }
            pageContext.getOut().println("doStartTag()");
            return result;
        } catch (Exception e) {
            throw new JspException(e);
        }
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().println("doEndTag()");
            return EVAL_PAGE;
        } catch (IOException e) {
            throw new JspException(e);
        }
    }

    @Override
    public int doAfterBody() throws JspException {
        try {
            this.loop--;
            int result;
            if (this.loop > 0) {
                result = EVAL_BODY_AGAIN; //! Обработать теле тега еще раз, а это значит просто вывести содержимое(ТЕЛО) тега на jsp страницу, т.е. напечатать "LoopTag"
            } else {
                result = SKIP_BODY;
            }
            pageContext.getOut().println("doAfterBody()");
            return result;
        } catch (Exception e) {
            throw new JspException(e);
        }
    }
}
