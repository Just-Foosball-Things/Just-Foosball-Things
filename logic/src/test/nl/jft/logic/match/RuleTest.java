package nl.jft.logic.match;

import nl.jft.logic.util.LogicTestUtil;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * @author Lesley
 */
public class RuleTest {

    @org.junit.Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void construct_nullDescription_throwsException() {
        expectedException.expect(NullPointerException.class);

        Rule rule = LogicTestUtil.makeRule(-1, null);
    }

    @Test
    public void construct_emptyDescription_throwsException() {
        expectedException.expect(IllegalArgumentException.class);

        Rule rule = LogicTestUtil.makeRule(-1, "");
    }

    @Test
    public void getId_whenCalled_returnsId() {
        Rule rule = LogicTestUtil.makeDefaultRule();

        int expected = -1;
        int actual = rule.getId();

        assertEquals(expected, actual);
    }

    @Test
    public void getDescription_whenCalled_returnsDescription() {
        Rule rule = LogicTestUtil.makeDefaultRule();

        String expected = "description";
        String actual = rule.getDescription();

        assertEquals(expected, actual);
    }

}