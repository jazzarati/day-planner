package main.java;

import main.java.exceptions.InvalidTimeException;

import java.util.List;
import java.util.regex.Pattern;

public class MoveParser extends InputParser {
    private static Pattern pattern = Pattern.compile("^m (\\d+) (\\d+) (\\d+)$");
    public static MoveCommand parse(String s) throws InvalidTimeException {
        List<String> matches = getMatches(pattern, s);
        return new MoveCommand(Integer.valueOf(matches.get(0)), toTime(matches.get(1), matches.get(2)));
    }
}
