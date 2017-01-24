package nl.jft.common.util;

import java.util.Objects;

/**
 * Provides utility methods for operating on arguments in method calls.
 *
 * @author Lesley
 */
public final class Arguments {

    /**
     * Should never be insantiated, it's utility class.
     */
    private Arguments() {
        throw new UnsupportedOperationException("Arguments class should not be instantiated.");
    }

    /**
     * Checks whether a given {@code String} is empty or not. A {@code String} is considered empty if, and only if,
     * the {@code String} is {@code nul}, the {@code String} contains nothing or the {@code String} contains spaces only. This method returns the
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

    public static double requireNotNegative(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Argument must not be negative.");
        }

        return value;
    }

}
