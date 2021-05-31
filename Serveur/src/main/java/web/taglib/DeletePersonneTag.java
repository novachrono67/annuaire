package web.taglib;

import model.Personne;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DeletePersonneTag extends TagSupport
{
    @Override
    public int doStartTag() throws JspException
    {
        try {
            int id = Integer.parseInt(pageContext.getRequest().getParameter("id"));
            pageContext.getOut().print(Personne.deletePersonne(id));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }
}
