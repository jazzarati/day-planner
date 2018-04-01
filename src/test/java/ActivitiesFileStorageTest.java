package test.java;

import main.java.Activities;
import main.java.ActivitiesFileStorage;
import main.java.Activity;
import main.java.exceptions.InvalidTimeException;
import org.junit.jupiter.api.Test;
import test.java.util.TestUtils;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Saves and loads
 */
class ActivitiesFileStorageTest {
    @Test
    public void savesAndLoads() throws IOException, InvalidTimeException {
        final File file = new File("testPlannerStorage.txt");

        Activities activities = new Activities();
        activities.add(new Activity("Hello", TestUtils.fromTime(1,50)));
        activities.add(new Activity("There little one", TestUtils.fromTime(2,32)));
        ActivitiesFileStorage.store(file, activities);
        Activities loadedActivities = ActivitiesFileStorage.load(file);
        assertEquals(activities, loadedActivities);
    }
}