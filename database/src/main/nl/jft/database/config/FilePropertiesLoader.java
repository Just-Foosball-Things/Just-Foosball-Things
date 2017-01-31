package nl.jft.database.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The {@code FilePropertiesLoader} is an implementation of the {@code PropertiesLoader} interface
 * and loads the {@link Properties} from the file-system.
 *
 * @author Oscar de Leeuw
 */
public class FilePropertiesLoader implements PropertiesLoader {

    private final static Logger logger = Logger.getLogger(FilePropertiesLoader.class.getName());

    private final File file;

    /**
     * Creates a new {@code FilePropertiesLoader} that will load the {@link Properties} from the given {@code File}.
     *
     * @param file The {@code File} from which to load the {@code Properties}.
     */
    public FilePropertiesLoader(File file) {
        this.file = file;
    }

    /**
     * Creates a new {@code FilePropertiesLoader} that will use the default database.config file for loading the {@code Properties}.
     */
    public FilePropertiesLoader() {
        this(new File("/database.config"));
    }

    @Override
    public Properties load() {
        Properties properties = new Properties();

        try (InputStream is = new FileInputStream(file)) {
            properties.load(is);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Database properties could not be loaded from the given InputStream", e);
        }

        return properties;
    }
}
