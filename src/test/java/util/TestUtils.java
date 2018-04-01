package test.java.util;

import main.java.Activities;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TestUtils {
    private TestUtils(){}
    public static OffsetDateTime fromTime(int hour, int minute) {
        return OffsetDateTime.of(1970, 1, 1, hour, minute, 0, 0, ZoneOffset.UTC);
    }

    public static Object[] getActions(Activities activities) {
        return Arrays.stream(activities.toArray()).map(activity -> activity.getAction()).collect(Collectors.toList()).toArray();
    }
}
