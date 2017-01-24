package nl.jft.logic.match;

import nl.jft.logic.LogicConstants;
import nl.jft.logic.util.LogicTestUtil;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * @author Lesley
 */
public class RuleTest {

    @org.junit.Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void construct_nullDescriptionOnly_throwsException() {
        expectedException.expect(NullPointerException.class);

        Rule rule = LogicTestUtil.makeRule(null);
    }

    @Test
    public void construct_emptyDescriptionOnly_throwsException() {
        expectedException.expect(IllegalArgumentException.class);

        Rule rule = LogicTestUtil.makeRule("");
    }

    @Test
    public void construct_nullDescription_throwsException() {
        expectedException.expect(NullPointerException.class);

        Rule rule = LogicTestUtil.makeRule(LogicConstants.INTERNAL_ID, null);
    }

    @Test
    public void construct_emptyDescription_throwsException() {
        expectedException.expect(IllegalArgumentException.class);

        Rule rule = LogicTestUtil.makeRule(LogicConstants.INTERNAL_ID, "");
    }

    @Test
    public void equals_sameObjects_returnsTrue() {
        Rule rule1 = LogicTestUtil.makeDefaultRule();
        Rule rule2 = LogicTestUtil.makeDefaultRule();

        boolean result = rule1.equals(rule2);
        assertTrue(result);
    }

    @Test
    public void equals_otherInstance_returnsFalse() {
        Rule rule1 = LogicTestUtil.makeDefaultRule();
        Rule rule2 = null;

        boolean result = rule1.equals(rule2);
        assertFalse(result);
    }

    @Test
    public void equals_differentIds_returnsFalse() {
        Rule rule1 = LogicTestUtil.makeRule(1, "description");
        Rule rule2 = LogicTestUtil.makeRule(2, "description");

        boolean result = rule1.equals(rule2);
        assertFalse(result);
    }

    @Test
    public void equals_differentDescriptions_returnsFalse() {
        Rule rule1 = LogicTestUtil.makeRule(1, "description1");
        Rule rule2 = LogicTestUtil.makeRule(1, "description2");

        boolean result = rule1.equals(rule2);
        assertFalse(result);
    }

    @Test
    public void hashCode_whenCalled_returnsHashCode() {
        Rule rule1 = LogicTestUtil.makeDefaultRule();
        Rule rule2 = LogicTestUtil.makeDefaultRule();

        boolean result = rule1.hashCode() == rule2.hashCode();
        assertTrue(result);
    }

    @Test
    public void getId_whenCalled_returnsId() {
        Rule rule = LogicTestUtil.makeDefaultRule();

        int expected = LogicConstants.INTERNAL_ID;
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