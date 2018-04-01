package test.java;

import main.java.Activities;
import main.java.Activity;
import main.java.MoveCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.java.util.TestUtils;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ActivitiesTest {

    private Activities activities;

    @BeforeEach
    public void setUp() {
        activities = new Activities();
        activities.add(new Activity("3", TestUtils.fromTime(20,0)));
        activities.add(new Activity("1", TestUtils.fromTime(3,0)));
        activities.add(new Activity("2", TestUtils.fromTime(15,0)));
    }

    @Test
    public void insertsInSortedOrder() {
        assertEquals(3, activities.size());
        assertArrayEquals(new String[]{"1","2","3"}, TestUtils.getActions(activities));
    }

    @Test
    public void remove() {
        activities.remove(1);
        assertEquals(2, activities.size());
        assertArrayEquals(new String[]{"1","3"}, TestUtils.getActions(activities));
    }

    @Test
    public void moves() {
        OffsetDateTime newTime = TestUtils.fromTime(23, 30);
        activities.move(new MoveCommand(1, newTime));
        assertEquals(3, activities.size());
        assertArrayEquals(new String[]{"1","3","2"}, TestUtils.getActions(activities));
        assertEquals(activities.toArray()[2], new Activity("2", newTime));
    }

    @Test
    public void equalByChildren() {
        Activities activities1 = new Activities();
        activities1.add(new Activity("3", TestUtils.fromTime(20,0)));
        activities1.add(new Activity("1", TestUtils.fromTime(10,0)));

        Activities activities2 = new Activities();
        activities2.add(new Activity("3", TestUtils.fromTime(20,0)));
        activities2.add(new Activity("1", TestUtils.fromTime(10,0)));
        assertEquals(activities1, activities2);
    }
}