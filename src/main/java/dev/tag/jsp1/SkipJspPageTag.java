package dev.tag.jsp1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Этот тег после того как завершит выполнение дает команду прекратить обработку jsp страницы с котороый вызван
 */
public class SkipJspPageTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        return SKIP_PAGE; //! прекратить обработку
    }
}
