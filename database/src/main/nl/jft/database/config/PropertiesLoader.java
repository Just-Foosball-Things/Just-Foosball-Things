package nl.jft.database.config;

import java.util.Properties;

/**
 * The {@code PropertiesLoader} interface is an interface for injecting the loading of {@code Properties} into classes.
 *
 * @author Oscar de Leeuw
 */
@FunctionalInterface
public interface PropertiesLoader {
    /**
     * Loads a {@code Properties} object.
     *
     * @return a {@code Properties} object.
     */
    Properties load();
}
