package web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Date;

public class DisplayDateTag extends TagSupport
{
    @Override
    public int doStartTag() throws JspException
    {
        try {
            pageContext.getOut().print(new Date());
        } catch (IOException e) {
            throw new JspException(e);
        }
        return super.doStartTag();
    }
}
