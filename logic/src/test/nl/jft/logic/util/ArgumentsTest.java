package nl.jft.logic.util;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

/**
 * @author Lesley
 */
public class ArgumentsTest {

    @Test(expected = UnsupportedOperationException.class)
    public void construct_whenCalled_throwsException() throws Throwable {
        try {
            Constructor<Arguments> constructor = Arguments.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException e) {
            throw e;
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }

    @Test(expected = NullPointerException.class)
    public void requireNotEmpty_nullString_throwsException() {
        Arguments.requireNotEmpty(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void requireNotEmpty_emptyString_throwsException() {
        Arguments.requireNotEmpty("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void requireNotEmpty_stringWithSpacesOnly_throwsException() {
        Arguments.requireNotEmpty("    ");
    }

    @Test
    public void requireNotEmpty_nonEmptyString_returnsString() {
        String expected = "value";
        String actual = Arguments.requireNotEmpty("value");

        assertEquals(expected, actual);
    }

}