package nl.jft.logic.util.builder;

/**
 * @author Lesley
 */
public final class ObjectBuilder {

    private ObjectBuilder() {
        throw new UnsupportedOperationException("Should not be called.");
    }

    public static TeamBuilder team() {
        return new TeamBuilder();
    }

    public static UserBuilder user() {
        return new UserBuilder();
    }

    public static GoalBuilder goal() {
        return new GoalBuilder();
    }

    public static MatchBuilder match() {
        return new MatchBuilder();
    }

    public static RuleBuilder rule() {
        return new RuleBuilder();
    }

}
