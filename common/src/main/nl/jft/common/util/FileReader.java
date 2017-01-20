package nl.jft.common.util;

import nl.jft.common.InputStreamFactory;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The {@code FileReader} reads a given {@link java.io.File File} or path as {@code String} from the disk
 * and returns a {@link java.io.InputStream InputStream}.
 *
 * @author Oscar de Leeuw
 */
public class FileReader {
    private static final Logger LOGGER = Logger.getLogger(FileReader.class.getName());

    private InputStreamFactory factory;

    public FileReader(InputStreamFactory factory) {
        this.factory = factory;
    }

    /**
     * Fetches the {@code InputStream} of a {@code File} located at the given path.
     * Calls the {@link #readFile(File)} method.
     * Will return {@code null} when the {@code File} cannot be found.
     *
     * @param path A {@code String} that represents the path to the wanted {@code File}.
     * @return An {@code InputStream} of the given {@code File}.
     */
    public InputStream readFile(String path) {
        File file = new File(path);

        return readFile(file);
    }

    /**
     * Fetches the {@code InputStream} of a given {@code File}.
     * Will return {@code null} when the {@code File} cannot be found.
     *
     * @param file The {@code File} for which to open the {@code InputStream}.
     * @return An {@code InputStream} of the given {@code File}.
     */
    public InputStream readFile(File file) {
        try {
            return factory.createStream(file);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
            return null;
        }
    }
}
