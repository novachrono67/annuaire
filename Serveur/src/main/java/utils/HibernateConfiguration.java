package utils;

import model.Personne;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration
{
    private HibernateConfiguration() {
    }

    public static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        setDatabaseConfiguration(configuration);
        registerEntities(configuration);
        return configuration;
    }

    private static void registerEntities(Configuration configuration) {
        configuration.addAnnotatedClass(Personne.class);
    }

    private static void setDatabaseConfiguration(Configuration configuration) {
        String DB_URL = EnvironmentVariablesUtils.getString(EnvironmentVariablesUtils.DB_URL);
        String DB_USER = EnvironmentVariablesUtils.getString(EnvironmentVariablesUtils.DB_USER);
        String DB_PASSWORD = EnvironmentVariablesUtils.getString(EnvironmentVariablesUtils.DB_PASSWORD);

        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", DB_URL);
        configuration.setProperty("hibernate.connection.username", DB_USER);
        configuration.setProperty("hibernate.connection.password", DB_PASSWORD);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
        configuration.setProperty("hibernate.enable_lazy_load_no_trans", "true");
    }
}
