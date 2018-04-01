package main.java;

import main.java.exceptions.InvalidTimeException;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class TimeParser {
    private TimeParser(){};
    public static OffsetDateTime parse(String str) throws InvalidTimeException {
        String[] parts = str.split(" ");
        try {
            return OffsetDateTime.of(1970, 1, 1, Integer.valueOf(parts[0]), Integer.valueOf(parts[1]), 0, 0, ZoneOffset.UTC);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw new InvalidTimeException();
        }
    }
}
