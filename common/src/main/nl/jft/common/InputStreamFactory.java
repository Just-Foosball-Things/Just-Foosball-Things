package nl.jft.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Oscar de Leeuw
 */
public interface InputStreamFactory {
    InputStream createStream(File file) throws IOException;
}
