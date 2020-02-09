package dev.tag.jsp1;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * What is the purpose of EVAL_BODY_AGAIN, SKIP_BODY and EVAL_BODY_INCLUDE
 *
 * https://stackoverflow.com/questions/42508175/what-is-the-purpose-of-eval-body-again-skip-body-and-eval-body-include/51186283
 */
public class DoStartTagUse extends TagSupport{
    public int doStartTag()    {
        return EVAL_BODY_INCLUDE;
//        return SKIP_BODY;
    }
}
