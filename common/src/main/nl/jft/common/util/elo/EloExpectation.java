package nl.jft.common.util.elo;

import nl.jft.common.util.Arguments;

/**
 * An {@code EloExpectation} represents a hypothetical match and the expected Elo-rating difference
 * resulting from a certain game. This class is used in order to test Elo-rating systems.
 *
 * @author Lesley
 * @author Oscar de Leeuw
 */
public class EloExpectation {

    private final double firstElo;
    private final double secondElo;

    private final int firstGoalsScored;
    private final int secondGoalsScored;

    private final int maxGoals;

    private final double firstDelta;
    private final double secondDelta;

    /**
     * Creates a new {@code EloExpectation} from a given {@link String}.
     * The {@code String} will require the following format: firstElo,secondElo,firstGoalsScored,secondGoalsScored,maxGoals,firstDelta,secondDelta
     *
     * @param expectation A {@code String} of the proper format.
     * @throws IllegalArgumentException when the provided {@code String} is not of the proper format.
     * @throws NumberFormatException    when a number could not be parsed to a {@code double}.
     */
    public EloExpectation(String expectation) {
        String[] arguments = Arguments.requireNotEmpty(expectation).split(",");
        if (arguments.length != 7) {
            throw new IllegalArgumentException("Invalid String format.");
        }

        firstElo = Double.parseDouble(arguments[0]);
        secondElo = Double.parseDouble(arguments[1]);
        firstGoalsScored = Integer.parseInt(arguments[2]);
        secondGoalsScored = Integer.parseInt(arguments[3]);
        maxGoals = Integer.parseInt(arguments[4]);
        firstDelta = Double.parseDouble(arguments[5]);
        secondDelta = Double.parseDouble(arguments[6]);
    }

    /**
     * Gets the Elo-rating of player one.
     *
     * @return A {@code double} that represents the Elo rating of the first player.
     */
    public double getFirstElo() {
        return firstElo;
    }

    /**
     * Gets the Elo-rating of player two.
     *
     * @return A {@ocde double} that represents the Elo-rating of the second player.
     */
    public double getSecondElo() {
        return secondElo;
    }

    /**
     * Gets the amount of goals made by the first player.
     *
     * @return An {@code int} that represents the amount goals made by the first player.
     */
    public int getFirstGoalsScored() {
        return firstGoalsScored;
    }

    /**
     * Gets the amount of goals made the second player.
     *
     * @return An {@code int} that represents the amount goals made by the second player.
     */
    public int getSecondGoalsScored() {
        return secondGoalsScored;
    }

    /**
     * Gets the amount of goals that leads to a win of a game.
     *
     * @return An {@code int} that represents the amount of goals that leads to a win of a game.
     */
    public int getMaxGoals() {
        return maxGoals;
    }

    /**
     * Gets the difference in Elo-rating for the first player.
     *
     * @return A {@code double} that represents the difference in Elo-rating for the first player.
     */
    public double getFirstDelta() {
        return firstDelta;
    }

    /**
     * Gets the difference in Elo-rating for player two.
     *
     * @return A {@code double} that represents the difference in Elo-rating for the second player.
     */
    public double getSecondDelta() {
        return secondDelta;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(firstElo);
        result = 31 * result + Double.hashCode(secondElo);
        result = 31 * result + firstGoalsScored;
        result = 31 * result + secondGoalsScored;
        result = 31 * result + maxGoals;
        result = 31 * result + Double.hashCode(firstDelta);
        result = 31 * result + Double.hashCode(secondDelta);

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EloExpectation)) {
            return false;
        } else {
            EloExpectation other = (EloExpectation) obj;

            return firstElo == other.firstElo &&
                    secondElo == other.secondElo &&
                    firstGoalsScored == other.firstGoalsScored &&
                    secondGoalsScored == other.secondGoalsScored &&
                    maxGoals == other.maxGoals &&
                    firstDelta == other.firstDelta &&
                    secondDelta == other.secondDelta;
        }
    }
}
