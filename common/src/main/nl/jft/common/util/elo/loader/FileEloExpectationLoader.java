package nl.jft.common.util.elo.loader;

import nl.jft.common.util.elo.EloExpectation;
import nl.jft.common.util.elo.EloExpectationLoader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The {@code FileEloExpectationLoader} class is an implementation of the {@link EloExpectationLoader} interface that
 * retrieves a list of {@link EloExpectation EloExpectations} from a given path.
 *
 * @author Oscar de Leeuw
 * @author Lesley
 */
public class FileEloExpectationLoader implements EloExpectationLoader {

    private static final Logger LOGGER = Logger.getLogger(FileEloExpectationLoader.class.getName());

    private final Path path;

    /**
     * Creates a new {@code FileEloExpectationLoader}.
     *
     * @param path The path to the {@code File} with the data, should not be {@code null}.
     */
    public FileEloExpectationLoader(Path path) {
        this.path = Objects.requireNonNull(path);
    }

    @Override
    public List<EloExpectation> load() {
        List<EloExpectation> list = new ArrayList<>();

        try (FileInputStream in = new FileInputStream(path.toFile());
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(new EloExpectation(line));
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to read file.", e);
        }

        return list;
    }

}
