package test.java;

import main.java.MoveCommand;
import main.java.MoveParser;
import main.java.exceptions.InvalidTimeException;
import org.junit.jupiter.api.Test;
import test.java.util.TestUtils;

import static org.junit.jupiter.api.Assertions.*;

class MoveParserTest {
    @Test
    public void parsesCorrectly() throws InvalidTimeException {
        assertEquals(MoveParser.parse("m 3 1 30"), new MoveCommand(3, TestUtils.fromTime(1, 30)));
    }
}