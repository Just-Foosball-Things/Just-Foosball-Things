package nl.jft.common.util.elo;

import nl.jft.common.util.Arguments;

/**
 * An {@code EloExpectation} represents a hypothetical match and the expected Elo rating difference resulting from said match.
 * This class is used in order to test Elo-rating systems.
 *
 * @author Lesley
 * @author Oscar de Leeuw
 */
public class EloExpectation {
    private final double elo1;
    private final double elo2;

    private final int goals1;
    private final int goals2;

    private final int maxGoals;

    private final double delta1;
    private final double delta2;

    /**
     * Creates a new {@code EloExpectation} from a {@code String}.
     * The {@code String} will require the following format: elo1,elo2,goals1,goals2,maxGoals,delta1,delta2
     * Will throw an {@link IllegalArgumentException} when the provided {@code String} is not of the proper format.
     * Will throw an {@link NumberFormatException} when a number could not be parsed.
     *
     * @param expectation A {@code String} of the proper format.
     */
    public EloExpectation(String expectation) {
        String[] arguments = Arguments.requireNotEmpty(expectation).split(",");

        if (arguments.length != 7) {
            throw new IllegalArgumentException("Invalid String format.");
        }

        elo1 = Double.parseDouble(arguments[0]);
        elo2 = Double.parseDouble(arguments[1]);
        goals1 = Integer.parseInt(arguments[2]);
        goals2 = Integer.parseInt(arguments[3]);
        maxGoals = Integer.parseInt(arguments[4]);
        delta1 = Double.parseDouble(arguments[5]);
        delta2 = Double.parseDouble(arguments[6]);
    }

    /**
     * Gets the Elo rating of player one.
     *
     * @return A double that represents the Elo rating of player one.
     */
    public double getElo1() {
        return elo1;
    }

    /**
     * Gets the Elo rating of player two.
     *
     * @return A double that represents the Elo rating of player two.
     */
    public double getElo2() {
        return elo2;
    }

    /**
     * Gets the goals made by player one.
     *
     * @return An int that represents the goals made by player one.
     */
    public int getGoals1() {
        return goals1;
    }

    /**
     * Gets the goals made by player two.
     *
     * @return An int that represents the goals made by player two.
     */
    public int getGoals2() {
        return goals2;
    }

    /**
     * Gets the goal maximum for this game.
     *
     * @return An int that represents the goal maximum of this game.
     */
    public int getMaxGoals() {
        return maxGoals;
    }

    /**
     * Gets the difference in Elo rating for player one.
     *
     * @return A double that represents the difference in Elo rating for player one.
     */
    public double getDelta1() {
        return delta1;
    }

    /**
     * Gets the difference in Elo rating for player two.
     *
     * @return A double that represents the difference in Elo rating for player two.
     */
    public double getDelta2() {
        return delta2;
    }
}
