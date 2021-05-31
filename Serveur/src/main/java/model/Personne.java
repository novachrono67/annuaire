package model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import utils.DatabaseManager;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "personne")
public class Personne
{
    @Id
    @Generated(GenerationTime.INSERT)
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "id")
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "login")
    private String login;

    @Column(name = "mot_de_passe")
    private String motDePasse;

    @Column(name = "adresse_mail")
    private String mail;

    @Column(name = "date_arrivee_entreprise")
    private Date dateArrivee;

    private Personne(int id, String nom, String prenom, String login, String motDePasse, String mail, Date dateArrivee)
    {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.motDePasse = motDePasse;
        this.mail = mail;
        this.dateArrivee = dateArrivee;
    }

    public Personne()
    {

    }

    public Personne(String nom, String prenom, String login, String motDePasse, String mail, Date dateArrivee)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.motDePasse = motDePasse;
        this.mail = mail;
        this.dateArrivee = dateArrivee;
    }

    public static boolean login(String login, String motDePasse)
    {
        Personne personne = readPersonne(login);
        return personne != null && personne.motDePasse == motDePasse;
    }

    public static Personne readPersonne(String login)
    {
        try {
            Session session = DatabaseManager.getSessionFactory().openSession();
            Query query = session.createQuery("from Personne where login=:login");
            query.setParameter("login", login);
            return (Personne) query.getSingleResult();
        }catch(NoResultException exception)
        {
            System.out.println("Exception : " + exception.getMessage());
        }
        return null;
    }

    public static List<Personne> readAll() {
        try {
            Session session = DatabaseManager.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Personne> criteria = builder.createQuery(Personne.class);
            criteria.from(Personne.class);
            List<Personne> list = session.createQuery(criteria).getResultList();
            session.close();
            list.sort(Comparator.comparing(Personne::getNom));
            return list;
        }catch(NoResultException exception)
        {
            System.out.println("Exception : " + exception.getMessage());
        }
        return null;
    }

    public static boolean createPersonne(String nom, String prenom, String login, String motDePasse, String mail, Date dateArrivee)
    {
        Personne personne = new Personne(nom, prenom, login, motDePasse, mail, dateArrivee);
        Session session = DatabaseManager.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(personne);
        session.getTransaction().commit();
        session.close();

        Personne personneMaj = readPersonne(login);
        if(personneMaj != null && personneMaj == personne)
        {
            return true;
        }
        return false;
    }

    public static boolean deletePersonne(int id)
    {
        try{
            Session session = DatabaseManager.getSessionFactory().openSession();
            Query query = session.createQuery("delete Personne where Personne.id = :id");
            query.setParameter("id", id);
            return query.executeUpdate() == 0;
        }catch(NoResultException exception)
        {
            System.out.println("Exception : " + exception.getMessage());
        }
        return false;
    }

    public static boolean updatePersonne(int id, String nom, String prenom, String login, String motDePasse, String mail, Date dateArrivee)
    {
        Personne personne = new Personne(id, nom, prenom, login, motDePasse, mail, dateArrivee);
        Session session = DatabaseManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(personne);
        transaction.commit();
        session.close();

        Personne personneMaj = readPersonne(login);
        if(personneMaj != null && personneMaj == personne)
        {
            return true;
        }
        return false;
    }

    public int getId()
    {
        return id;
    }

    public String getNom()
    {
        return nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public String getLogin()
    {
        return login;
    }

    public String getMotDePasse()
    {
        return motDePasse;
    }

    public String getMail()
    {
        return mail;
    }

    public Date getDateArrivee()
    {
        return dateArrivee;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setMotDePasse(String motDePasse)
    {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString()
    {
        return "ID = " + id + "\n" +
                "Nom = " + nom + "\n" +
                "Prenom = " + prenom + "\n" +
                "Login = " + login + "\n" +
                "Mot de passe = " + motDePasse + "\n" +
                "Adresse mail = " + mail + "\n" +
                "Date d'arrivée dans l'entreprise = " + dateArrivee + "\n";

    }
}
