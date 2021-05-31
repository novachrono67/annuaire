package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Objects;

public class DatabaseManager
{
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/annuaire";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";

    private static SessionFactory sessionFactory;

    public static synchronized SessionFactory getSessionFactory() {
        Configuration configuration = HibernateConfiguration.getConfiguration();
        if (Objects.isNull(sessionFactory)) {
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
