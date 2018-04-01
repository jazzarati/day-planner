package test.java;

import main.java.TimeParser;
import main.java.exceptions.InvalidTimeException;
import org.junit.jupiter.api.Test;
import test.java.util.TestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeParserTest {
    @Test
    public void getsHourAndMinutes() throws InvalidTimeException {
        assertEquals(TimeParser.parse("3 30"), TestUtils.fromTime(3, 30));
    }
}
