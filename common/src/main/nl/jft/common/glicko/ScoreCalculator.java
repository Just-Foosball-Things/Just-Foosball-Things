package nl.jft.common.glicko;

/**
 * The {@code ScoreCalculator} maps the outcome of a {@link GlickoResult} to a value between 0 and 1.
 *
 * @author Oscar de Leeuw
 */
public interface ScoreCalculator {
    double getActualScore(int goalDifference);
}
