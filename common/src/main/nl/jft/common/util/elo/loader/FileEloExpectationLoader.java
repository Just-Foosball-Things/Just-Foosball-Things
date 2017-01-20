package nl.jft.common.util.elo.loader;

import nl.jft.common.util.elo.EloExpectation;
import nl.jft.common.util.elo.EloExpectationLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The {@code FileEloExpectationLoader} class is an implementation of the {@code EloExpectationLoader} interface that
 * retrieves a list of {@link EloExpectation EloExpectations} from the given path.
 *
 * @author Oscar de Leeuw
 */
public class FileEloExpectationLoader implements EloExpectationLoader {
    private static final Logger LOGGER = Logger.getLogger(FileEloExpectationLoader.class.getName());

    private String path;

    /**
     * Creates a new {@code FileEloExpectationLoader}.
     *
     * @param path The path to the {@code File} with the data.
     */
    public FileEloExpectationLoader(String path) {
        this.path = path;
    }

    @Override
    public List<EloExpectation> load() {
        File file = new File(path);

        List<EloExpectation> ret = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            while (scanner.hasNextLine()) {
                ret.add(new EloExpectation(scanner.nextLine()));
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }

        return ret;
    }
}
