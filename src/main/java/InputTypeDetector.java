package main.java;

import main.java.exceptions.UnknownInputType;

import java.util.regex.Pattern;

public class InputTypeDetector {
    private static Pattern newActivityPattern = Pattern.compile("\\d+ \\d+ .*");
    public static InputType detect(String str) throws UnknownInputType {
        if(str.equalsIgnoreCase("q")) {
            return InputType.QUIT;
        } else if(str.equalsIgnoreCase("l")) {
            return InputType.LIST;
        } else if(newActivityPattern.matcher(str).matches()) {
            return InputType.ACTIVITY;
        } else if(str.startsWith("s")) {
            return InputType.SAVE;
        } else if(str.startsWith("d")) {
            return InputType.DELETE;
        } else if(str.startsWith("m")) {
            return InputType.MOVE;
        } else if(str.equalsIgnoreCase("?")) {
            return InputType.HELP;
        } else if(str.equalsIgnoreCase("clear")) {
            return InputType.CLEAR;
        } else {
            throw new UnknownInputType();
        }
    }
}
