package main.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeleteActivityParser {
    private static Pattern pattern = Pattern.compile("d (\\d+)");
    public static Integer parse(String s) {
        Matcher matcher = pattern.matcher(s);
        matcher.find();
        return Integer.valueOf(matcher.group(1));
    }
}
