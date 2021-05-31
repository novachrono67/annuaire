package utils;

import javax.naming.ConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

/**
 * Accès aux variables d'environnement du programme.
 */
public abstract class EnvironmentVariablesUtils
{
  public static final String DB_URL = "DB_URL";
  public static final String DB_USER = "DB_USER";
  public static final String DB_PASSWORD = "DB_PASSWORD";

  private static final String ENVIRONMENT_VARIABLES_FILE = "ENVIRONMENT.properties";

  /**
   * Accès à une variable d'environnement de type {@link String} ou à sa valeur par défaut.
   *
   * @param variable     nom de la variable
   * @param defaultValue valeur par défaut
   * @return variable d'environnement ou variable par défaut
   */
  public static String getString(String variable, String defaultValue) {
    String var = get(variable);
    if (Objects.isNull(var)) {
      return defaultValue;
    } else {
      return var;
    }
  }

  /**
   * Accès à une variable d'environnement de type {@link String}.
   *
   * @param variable nom de la variable
   * @return variable d'environnement
   */
  public static String getString(String variable) {
    return getString(variable, null);
  }

  private static String get(String variable) {
    return Objects.nonNull(System.getenv(variable))
      ? System.getenv(variable)
      : getFromFile(variable);
  }

  private static String getFromFile(String variable) {
    try {
      try (InputStream inputStream = EnvironmentVariablesUtils.class.getResourceAsStream(ENVIRONMENT_VARIABLES_FILE)) {
        Properties prop = new Properties();
        prop.load(inputStream);
        return Optional.ofNullable(prop.getProperty(variable))
          .orElseThrow(ConfigurationException::new);
      }
    } catch (IOException | ConfigurationException | NullPointerException e) {
      return null;
    }
  }
}
