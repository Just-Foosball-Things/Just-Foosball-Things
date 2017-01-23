package nl.jft.logic.match;

import nl.jft.logic.participant.Participant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * A {@code Match} is a game between two {@link nl.jft.logic.participant.Participant participants}. {@link Goal goals}
 * can be scored, and added, in a {@code Match} to determine the winning {@code Participant}.
 *
 * @author Lesley
 */
public class Match {

    private final List<Goal> goals = new ArrayList<>();
    private final List<Rule> rules = new ArrayList<>();

    private final Participant firstParticipant;
    private final Participant secondParticipant;

    public Match(Participant firstParticipant, Participant secondParticipant) {
        this.firstParticipant = Objects.requireNonNull(firstParticipant);
        this.secondParticipant = Objects.requireNonNull(secondParticipant);
    }

    public void addGoal(Goal goal) {
        synchronized (goals) {
            goals.add(Objects.requireNonNull(goal));
        }
    }

    public void removeGoal(Goal goal) {
        synchronized (goals) {
            goals.remove(Objects.requireNonNull(goal));
        }
    }

    public void addRule(Rule rule) {
        synchronized (rules) {
            rules.add(Objects.requireNonNull(rule));
        }
    }

    public void removeRule(Rule rule) {
        synchronized (rules) {
            rules.remove(Objects.requireNonNull(rule));
        }
    }

    public List<Goal> getGoals() {
        synchronized (goals) {
            return Collections.unmodifiableList(goals);
        }
    }

    public List<Rule> getRules() {
        synchronized (rules) {
            return Collections.unmodifiableList(rules);
        }
    }

    public Participant getFirstParticipant() {
        return firstParticipant;
    }

    public Participant getSecondParticipant() {
        return secondParticipant;
    }

}
