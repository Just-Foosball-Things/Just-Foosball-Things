package nl.jft.logic.tournament;

import nl.jft.logic.participant.Participant;
import nl.jft.logic.participant.ParticipantType;
import nl.jft.logic.util.LogicTestUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * @author Lesley
 */
public class TournamentTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void construct_nullTournamentType_throwsException() {
        expectedException.expect(NullPointerException.class);

        Tournament tournament = LogicTestUtil.makeTournament(null, ParticipantType.SOLO);
    }

    @Test
    public void construct_nullParticipantType_throwsException() {
        expectedException.expect(NullPointerException.class);

        Tournament tournament = LogicTestUtil.makeTournament(TournamentType.KNOCKOUT, null);
    }

    @Test
    public void start_whenCalled_startsTournament() {
        Tournament tournament = LogicTestUtil.makeDefaultTournament();
        tournament.start();

        TournamentStatus expected = TournamentStatus.IN_PROGRESS;
        TournamentStatus actual = tournament.getStatus();

        assertEquals(expected, actual);
    }

    @Test
    public void start_tournamentInProgress_throwsException() {
        expectedException.expect(IllegalStateException.class);

        Tournament tournament = LogicTestUtil.makeDefaultTournament();
        tournament.start();
        tournament.start();
    }

    @Test
    public void start_tournamentFinished_throwsException() {
        expectedException.expect(IllegalStateException.class);

        Tournament tournament = LogicTestUtil.makeDefaultTournament();
        tournament.start();
        tournament.stop();
        tournament.start();
    }

    @Test
    public void stop_whenCalled_stopsTournament() {
        Tournament tournament = LogicTestUtil.makeDefaultTournament();
        tournament.start();
        tournament.stop();

        TournamentStatus expected = TournamentStatus.FINISHED;
        TournamentStatus actual = tournament.getStatus();

        assertEquals(expected, actual);
    }

    @Test
    public void stop_tournamentSetup_throwsException() {
        expectedException.expect(IllegalStateException.class);

        Tournament tournament = LogicTestUtil.makeDefaultTournament();
        tournament.stop();
    }

    @Test
    public void stop_tournamentFinished_throwsException() {
        expectedException.expect(IllegalStateException.class);

        Tournament tournament = LogicTestUtil.makeDefaultTournament();
        tournament.start();
        tournament.stop();
        tournament.stop();
    }

    @Test
    public void addParticipant_nullParticipant_throwsException() {
        expectedException.expect(NullPointerException.class);

        Tournament tournament = LogicTestUtil.makeDefaultTournament();
        tournament.addParticipant(null);
    }

    @Test
    public void addParticipant_userOnTeamTournament_throwsException() {
        expectedException.expect(IllegalArgumentException.class);

        Tournament tournament = LogicTestUtil.makeTournament(TournamentType.KNOCKOUT, ParticipantType.TEAM);
        Participant participant = LogicTestUtil.makeDefaultUser();

        tournament.addParticipant(participant);
    }

    @Test
    public void addParticipant_teamOnSoloTournament_throwsException() {
        expectedException.expect(IllegalArgumentException.class);

        Tournament tournament = LogicTestUtil.makeTournament(TournamentType.KNOCKOUT, ParticipantType.SOLO);
        Participant participant = LogicTestUtil.makeDefaultTeam();

        tournament.addParticipant(participant);
    }

    @Test
    public void addParticipant_tournamentInProgress_throwsException() {
        expectedException.expect(IllegalStateException.class);

        Tournament tournament = LogicTestUtil.makeDefaultTournament();
        Participant participant = LogicTestUtil.makeDefaultUser();

        tournament.start();
        tournament.addParticipant(participant);
    }

    @Test
    public void addParticipant_tournamentFinished_throwsException() {
        expectedException.expect(IllegalStateException.class);

        Tournament tournament = LogicTestUtil.makeDefaultTournament();
        Participant participant = LogicTestUtil.makeDefaultUser();

        tournament.start();
        tournament.stop();
        tournament.addParticipant(participant);
    }

    @Test
    public void addParticipant_userOnSoloTournament_addsParticipant() {
        Tournament tournament = LogicTestUtil.makeDefaultTournament();
        Participant participant = LogicTestUtil.makeDefaultUser();

        tournament.addParticipant(participant);

        List<Participant> expected = new ArrayList<Participant>() {{
            add(LogicTestUtil.makeDefaultUser());
        }};
        List<Participant> actual = tournament.getParticipants();

        assertEquals(expected, actual);
    }

    @Test
    public void addParticipant_teamOnTeamTournament_addsParticipant() {
        Tournament tournament = LogicTestUtil.makeTournament(TournamentType.KNOCKOUT, ParticipantType.TEAM);
        Participant participant = LogicTestUtil.makeDefaultTeam();

        tournament.addParticipant(participant);

        List<Participant> expected = new ArrayList<Participant>() {{
            add(LogicTestUtil.makeDefaultTeam());
        }};
        List<Participant> actual = tournament.getParticipants();

        assertEquals(expected, actual);
    }

    @Test
    public void removeParticipant_nullParticipant_throwsException() {
        expectedException.expect(NullPointerException.class);


        Tournament tournament = LogicTestUtil.makeDefaultTournament();
        tournament.removeParticipant(null);
    }

    @Test
    public void removeParticipant_userOnTeamTournament_throwsException() {
        expectedException.expect(IllegalArgumentException.class);

        Tournament tournament = LogicTestUtil.makeTournament(TournamentType.KNOCKOUT, ParticipantType.TEAM);
        Participant participant = LogicTestUtil.makeDefaultUser();

        tournament.removeParticipant(participant);
    }

    @Test
    public void removeParticipant_teamOnSoloTournament_throwsException() {
        expectedException.expect(IllegalArgumentException.class);

        Tournament tournament = LogicTestUtil.makeTournament(TournamentType.KNOCKOUT, ParticipantType.SOLO);
        Participant participant = LogicTestUtil.makeDefaultTeam();

        tournament.removeParticipant(participant);
    }

    @Test
    public void removeParticipant_tournamentInProgress_throwsException() {
        expectedException.expect(IllegalStateException.class);

        Tournament tournament = LogicTestUtil.makeDefaultTournament();
        Participant participant = LogicTestUtil.makeDefaultUser();

        tournament.start();
        tournament.removeParticipant(participant);
    }

    @Test
    public void removeParticipant_tournamentFinished_throwsException() {
        expectedException.expect(IllegalStateException.class);

        Tournament tournament = LogicTestUtil.makeDefaultTournament();
        Participant participant = LogicTestUtil.makeDefaultUser();

        tournament.start();
        tournament.stop();
        tournament.removeParticipant(participant);
    }

    @Test
    public void removeParticipant_whenCalled_throwsException() {
        Tournament tournament = LogicTestUtil.makeDefaultTournament();
        Participant participant = LogicTestUtil.makeDefaultUser();

        tournament.addParticipant(participant);
        tournament.removeParticipant(participant);

        List<Participant> expected = new ArrayList<>();
        List<Participant> actual = tournament.getParticipants();

        assertEquals(expected, actual);
    }

    @Test
    public void getWinner_byDefault_returnsSetup() {
        Tournament tournament = LogicTestUtil.makeDefaultTournament();

        TournamentStatus expected = TournamentStatus.SETUP;
        TournamentStatus actual = tournament.getStatus();

        assertEquals(expected, actual);
    }

    @Test
    public void getWinner_byDefault_isEmpty() {
        Tournament tournament = LogicTestUtil.makeDefaultTournament();

        Optional<Participant> expected = Optional.empty();
        Optional<Participant> actual = tournament.getWinner();

        assertEquals(expected, actual);
    }

    @Test
    public void getParticipants_byDefault_returnsEmptyList() {
        Tournament tournament = LogicTestUtil.makeDefaultTournament();

        List<Participant> expected = new ArrayList<>();
        List<Participant> actual = tournament.getParticipants();

        assertEquals(expected, actual);
    }

    @Test
    public void getTournamentType_whenCalled_returnsTournamentType() {
        Tournament tournament = LogicTestUtil.makeDefaultTournament();

        TournamentType expected = TournamentType.KNOCKOUT;
        TournamentType actual = tournament.getTournamentType();

        assertEquals(expected, actual);
    }

    @Test
    public void getParticipantType_whenCalled_returnsParticipantType() {
        Tournament tournament = LogicTestUtil.makeDefaultTournament();

        ParticipantType expected = ParticipantType.SOLO;
        ParticipantType actual = tournament.getParticipantType();

        assertEquals(expected, actual);
    }

}