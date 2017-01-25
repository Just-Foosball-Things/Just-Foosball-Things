package nl.jft.common.glicko;

import java.util.List;

/**
 * The {@code GlickoCalculator} calculates new {@link GlickoRating GlickoRatings} based on a {@link GlickoResult}.
 * This interface describes the basic methods that such a calculator requires, but the implementation of these is trivial.
 *
 * For more information about the Glicko-2 rating system please consult www.glicko.net/glicko/glicko2.pdf.
 * The Glicko-2 rating system is public domain and was invented by Mark Glickman.
 *
 * @author Oscar de Leeuw
 */
public interface GlickoCalculator {

    /**
     * Calculates the new {@link GlickoRating GlickoRatings} for the two players from a {@code GlickoResult}.
     *
     * @param result The new {@code GlickoRatings} of the two players.
     * @return A {@code GlickoCalculationResult}.
     */
    GlickoCalculationResult calculateNewRating(GlickoResult result);

    /**
     * Processes a {@code List} of {@code GlickoResults} and calculates the new {@link GlickoRating GlickoRatings}
     *
     * @param results A {@code List} of {@code GlickoCalculationResults} with the new {@code GlickoRatings}.
     * @return A {@code List} of {@code GlickoCalculationResults}.
     */
    List<GlickoCalculationResult> calculateNewRatings(List<GlickoResult> results);
}
