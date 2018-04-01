package main.java;

import main.java.exceptions.InvalidTimeException;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    protected static List<String> getMatches(Pattern pattern, String str) {
        Matcher matcher = pattern.matcher(str);
        List<String> l = new ArrayList<>();
        while(matcher.find()) {
            int groups = matcher.groupCount();
            for (int i = 1; i <= groups; i++) {
                l.add(matcher.group(i));
            }
        }
        return l;
    }

    protected static OffsetDateTime toTime(String hour, String minutes) throws InvalidTimeException {
        try {
            return OffsetDateTime.of(1970, 1, 1, Integer.valueOf(hour), Integer.valueOf(minutes), 0, 0, ZoneOffset.UTC);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw new InvalidTimeException();
        }
    }
}
