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

    /**
     * Initializes a new {@code Match} with the given {@link Participant participants}.
     *
     * @param firstParticipant  The first {@code Participant} of this {@code Match}, should not be {@code null}.
     * @param secondParticipant The second {@code Participant} of this {@code Match}, should not be {@code null}.
     */
    public Match(Participant firstParticipant, Participant secondParticipant) {
        this.firstParticipant = Objects.requireNonNull(firstParticipant);
        this.secondParticipant = Objects.requireNonNull(secondParticipant);
    }


    public void addGoal(Goal goal) {
        synchronized (goals) {
            goals.add(Objects.requireNonNull(goal));
        }
    }

    /**
     * Removes a {@link Goal} from this {@code Match}.
     *
     * @param goal The {@code Goal} to remove from this {@code Match}, should not be {@code null}.
     * @throws NullPointerException If the specified {@code Goal} is {@code null}.
     */
    public void removeGoal(Goal goal) {
        synchronized (goals) {
            goals.remove(Objects.requireNonNull(goal));
        }
    }

    /**
     * Adds a {@link Rule} to this {@code Match}.
     *
     * @param rule The {@code Rule} to add to this {@code Match}, should not be {@code null}.
     * @throws NullPointerException If the specified {@code Rule} is {@code null}.
     */
    public void addRule(Rule rule) {
        synchronized (rules) {
            rules.add(Objects.requireNonNull(rule));
        }
    }

    /**
     * Removes a {@link Rule} from this {@code Match}.
     *
     * @param rule The {@code Rule} to remove from this {@code Match}, should not be {@code null}.
     * @throws NullPointerException If the specified {@code Rule} is {@code null}.
     */
    public void removeRule(Rule rule) {
        synchronized (rules) {
            rules.remove(Objects.requireNonNull(rule));
        }
    }

    /**
     * Gets all {@link Goal Goals} from this {@code Match}.
     *
     * @return A {@link List} containing all {@code Goals} added to this {@code Match}.
     */
    public List<Goal> getGoals() {
        synchronized (goals) {
            return Collections.unmodifiableList(goals);
        }
    }

    /**
     * Gets all {@link Rule Rules} from this {@code Match}.
     *
     * @return A {@link List} containing all {@code Rules} added to this {@code Match}.
     */
    public List<Rule> getRules() {
        synchronized (rules) {
            return Collections.unmodifiableList(rules);
        }
    }

    /**
     * Gets the first {@link Participant} competing in this {@code Match}.
     *
     * @return The first {@code Participant} competing in this {@code Match}.
     */
    public Participant getFirstParticipant() {
        return firstParticipant;
    }

    /**
     * Gets the second {@link Participant} competing in this {@code Match}.
     *
     * @return The second {@code Participant} competing in this {@code Match}.
     */
    public Participant getSecondParticipant() {
        return secondParticipant;
    }

}
