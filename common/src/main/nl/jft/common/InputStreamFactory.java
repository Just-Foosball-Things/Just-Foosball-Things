package nl.jft.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Oscar de Leeuw
 */
public interface InputStreamFactory {
    /**
     * Creates a new {@code InputStream}.
     *
     * @param file The {@code File} on which an {@code InputStream} should be created.
     * @return An {@code InputStream}.
     * @throws IOException When an exception occurs during stream creation.
     */
    InputStream createStream(File file) throws IOException;
}
