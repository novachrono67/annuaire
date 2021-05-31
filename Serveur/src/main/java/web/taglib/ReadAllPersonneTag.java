package web.taglib;

import model.Personne;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Date;

public class ReadAllPersonneTag extends TagSupport
{
    @Override
    public int doStartTag() throws JspException
    {
        try {
            pageContext.getOut().print(Personne.readAll());
        } catch (IOException e) {
            throw new JspException(e);
        }
        return super.doStartTag();
    }
}
