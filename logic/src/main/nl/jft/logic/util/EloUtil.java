package nl.jft.logic.util;

import nl.jft.logic.LogicConstants;
import nl.jft.logic.participant.Elo;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * This class provides various utility methods regarding {@link Elo elos}.
 *
 * @author Lesley
 */
public final class EloUtil {

    private EloUtil() {
        throw new UnsupportedOperationException("Should not be called.");
    }

    /**
     * Calculates the average {@link Elo} of two given {@code Elos}.
     *
     * @param firstElo  The first {@code Elo} to calculate the average of, should not be {@code null}.
     * @param secondElo The second {@code Elo} to calculate the average of, should not be {@code null}.
     * @return An {@code Elo} containing the calculated average of the two given {@code Elos}.
     * @throws NullPointerException If {@code firstElo} is {@code null}.
     * @throws NullPointerException If {@code secondElo} is {@code null}.
     */
    public static Elo calculateCombinedElo(Elo firstElo, Elo secondElo) {
        Objects.requireNonNull(firstElo);
        Objects.requireNonNull(secondElo);

        double firstRating = firstElo.getRating();
        double secondRating = secondElo.getRating();

        double averageRating = (firstRating + secondRating) / 2d;
        return new Elo(LogicConstants.INTERNAL_ID, averageRating, LocalDateTime.MIN);
    }

}
