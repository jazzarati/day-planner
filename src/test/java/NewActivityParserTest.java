package test.java;

import main.java.Activity;
import main.java.NewActivityParser;
import main.java.exceptions.InvalidTimeException;
import org.junit.jupiter.api.Test;
import test.java.util.TestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewActivityParserTest {
    @Test
    public void parsesCorrectly() throws InvalidTimeException {
        assertEquals(NewActivityParser.parse("3 30 Shopping"), new Activity("Shopping", TestUtils.fromTime(3, 30)));
    }
}
