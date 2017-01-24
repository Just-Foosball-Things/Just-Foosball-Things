package nl.jft.common.util;

import java.util.Objects;

/**
 * Provides utility methods for operating on arguments in method calls.
 *
 * @author Lesley
 * @author Oscar de Leeuw
 */
public final class Arguments {

    /**
     * Should never be instantiated, it's utility class.
     */
    private Arguments() {
        throw new UnsupportedOperationException("Arguments class should not be instantiated.");
    }

    /**
     * Checks whether a given {@code String} is empty or not. A {@code String} is considered empty if, and only if,
     * the {@code String} is {@code null}, the {@code String} contains nothing or the {@code String} contains spaces only. This method returns the
     * given input {@code String}, if it was not empty, so that it can be assigned.
     * Example: {@code String s = requireNotEmpty("hello");}
     *
     * @param value The {@code String} to check on.
     * @return Returns the given input {@code String} so it can be assigned.
     * @throws NullPointerException     When the given input {@code String} is {@code null}.
     * @throws IllegalArgumentException When the given input {@code String} is empty, or contains spaces only.
     */
    public static String requireNotEmpty(String value) {
        Objects.requireNonNull(value);

        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("Argument must not be empty.");
        }

        return value;
    }

    /**
     * Checks whether a given {@code double} is not negative. A {@code double} is considered not negative if, and only if,
     * the {@code double} is larger or equal to zero.
     *
     * @param value The {@code double} to check non-negativity for.
     * @return The given {@code double} if the value was not negative.
     * @throws IllegalArgumentException When the given input is considered negative.
     */
    public static double requireNotNegative(double value) {
        if (Double.compare(value, 0d) < 0) {
            throw new IllegalArgumentException("Argument must not be negative.");
        }

        return value;
    }

    /**
     * Checks whether a given {@code double} is positive. A {@code double} is considered positive if, and only if,
     * the {@code double} is not negative and not zero.
     *
     * @param value The {@code double} to check positivity for.
     * @return The given {@code double} if the value was positive.
     * @throws IllegalArgumentException When the given input is not considered positive.
     */
    public static double requirePositive(double value) {
        if (Double.compare(value, 0d) <= 0) {
            throw new IllegalArgumentException("Argument must be positive and non-zero.");
        }

        return value;
    }

}
