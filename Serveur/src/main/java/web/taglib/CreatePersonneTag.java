package web.taglib;

import model.Personne;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreatePersonneTag extends TagSupport
{
    @Override
    public int doStartTag() throws JspException
    {
        try {
            String nom = pageContext.getRequest().getParameter("nom");
            String prenom = pageContext.getRequest().getParameter("prenom");
            String login = pageContext.getRequest().getParameter("login");
            String motDePasse = pageContext.getRequest().getParameter("motDePasse");
            String mail = pageContext.getRequest().getParameter("mail");
            Date dateArrivee = new SimpleDateFormat("yyyy/MM/dd").parse((pageContext.getRequest().getParameter("dateArrivee")));
            pageContext.getOut().print(Personne.createPersonne(nom, prenom, login, motDePasse, mail, dateArrivee));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }
}
