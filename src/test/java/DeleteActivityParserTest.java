package test.java;

import main.java.DeleteActivityParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteActivityParserTest {
    @Test
    public void getsIndex() {
        Integer expected = 40;
        assertEquals(expected, DeleteActivityParser.parse("d 40"));
    }

}