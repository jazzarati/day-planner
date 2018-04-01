package main.java;

import main.java.exceptions.InvalidTimeException;

import java.util.List;
import java.util.regex.Pattern;

public class NewActivityParser extends InputParser {
    private NewActivityParser(){}

    private static Pattern pattern = Pattern.compile("^(\\d+) (\\d+) (.*)$");
    public static Activity parse(String s) throws InvalidTimeException {
        List<String> matches = getMatches(pattern, s);
        return new Activity(matches.get(2), toTime(matches.get(0), matches.get(1)));
    }
}
