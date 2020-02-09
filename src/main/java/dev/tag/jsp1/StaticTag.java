package dev.tag.jsp1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StaticTag extends TagSupport {

    private static Logger LOGGER = LoggerFactory.getLogger(StaticTag.class);

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            out.write("Current Date " + new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa").format(new Date()));
            LOGGER.info(Logger.ROOT_LOGGER_NAME + "out.write"); //! Почему не логируется?????!!!!
            return SKIP_PAGE;
        } catch (IOException i) {
            LOGGER.error(Logger.ROOT_LOGGER_NAME + i.getMessage()); //! Почему не логируется?????!!!!
            throw new JspException(i);
        }
    }
}
