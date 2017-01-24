package nl.jft.common;

import nl.jft.common.util.elo.EloExpectationCalculator;
import nl.jft.common.util.elo.EloExpectationResult;
import nl.jft.common.util.elo.loader.FileEloExpectationLoader;
import nl.jft.common.util.elo.strategy.LinearAlphaStrategy;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Oscar de Leeuw
 */
public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        //InputStream is = Main.class.getResourceAsStream("resources/estimates.txt");

        Path path = null;

        try {
            path = Paths.get(ClassLoader.getSystemResource("estimates.txt").toURI());
        } catch (URISyntaxException e) {
            LOGGER.log(Level.SEVERE, "Cannot parse resource", e);
        }

        EloExpectationCalculator calculator = new EloExpectationCalculator(new FileEloExpectationLoader(path), new LinearAlphaStrategy());
        List<EloExpectationResult> result = calculator.calculate();

        result.forEach(System.out::println);
    }
}
