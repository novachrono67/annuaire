package utils;

import org.flywaydb.core.Flyway;

public class DatabaseMigration
{
    public static void main(String[] args)
    {
        migrate();
    }

    public static void migrate()
    {
        String DB_URL = EnvironmentVariablesUtils.getString(EnvironmentVariablesUtils.DB_URL);
        String DB_USER = EnvironmentVariablesUtils.getString(EnvironmentVariablesUtils.DB_USER);
        String DB_PASSWORD = EnvironmentVariablesUtils.getString(EnvironmentVariablesUtils.DB_PASSWORD);

        Flyway flyway = Flyway.configure().locations("migration").dataSource(DB_URL, DB_USER, DB_PASSWORD).load();
        flyway.clean();
        flyway.migrate();
    }
}
