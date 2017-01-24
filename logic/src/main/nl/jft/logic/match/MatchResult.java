package nl.jft.logic.match;

import nl.jft.common.Identifiable;

/**
 * @author Lesley
 */
public class MatchResult implements Identifiable {

    private final int id;
    private final Match match;

    public MatchResult(int id, Match match) {
        this.id = id;
        this.match = match;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof MatchResult)) {
            return false;
        }

        MatchResult o = (MatchResult) other;
        return o.id == id && o.match.equals(match);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + match.hashCode();
        return result;
    }

    @Override
    public int getId() {
        return id;
    }

    public Match getMatch() {
        return match;
    }

}
