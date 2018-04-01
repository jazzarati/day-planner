package test.java;

import main.java.InputType;
import main.java.InputTypeDetector;
import main.java.exceptions.UnknownInputType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTypeDetectorTest {
    @Test
    public void detectsQuit() throws UnknownInputType {
        assertEquals(InputTypeDetector.detect("q"), InputType.QUIT);
    }

    @Test
    public void detectsNewActivity() throws UnknownInputType {
        assertEquals(InputTypeDetector.detect("1 23 Action"), InputType.ACTIVITY);
    }

    @Test
    public void detectsList() throws UnknownInputType {
        assertEquals(InputTypeDetector.detect("l"), InputType.LIST);
    }

    @Test
    public void detectsDelete() throws UnknownInputType {
        assertEquals(InputTypeDetector.detect("d 2"), InputType.DELETE);
    }

    @Test
    public void detectsSave() throws UnknownInputType {
        assertEquals(InputTypeDetector.detect("s"), InputType.SAVE);
    }

    @Test
    public void detectsClear() throws UnknownInputType {
        assertEquals(InputTypeDetector.detect("clear"), InputType.CLEAR);
    }

    @Test
    public void detectsHelp() throws UnknownInputType {
        assertEquals(InputTypeDetector.detect("?"), InputType.HELP);
    }

    @Test
    public void detectsMove() throws UnknownInputType {
        assertEquals(InputTypeDetector.detect("m 1 10 20"), InputType.MOVE);
    }
}
