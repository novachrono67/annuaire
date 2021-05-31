package web.taglib;

import model.Personne;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class ReadPersonneTag extends TagSupport
{
    @Override
    public int doStartTag() throws JspException
    {
        try {
            String login = pageContext.getRequest().getParameter("login");
            pageContext.getOut().print(Personne.readPersonne(login));
        } catch (IOException e) {
            throw new JspException(e);
        }
        return super.doStartTag();
    }
}
