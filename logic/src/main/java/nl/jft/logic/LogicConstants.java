package nl.jft.logic;

import java.time.LocalDateTime;

/**
 * @author Lesley
 */
public final class LogicConstants {

    public static final int INTERNAL_ID = -1;

    public static final LocalDateTime INTERNAL_DATETIME = LocalDateTime.MIN;

    private LogicConstants() {
        throw new UnsupportedOperationException();
    }

}
