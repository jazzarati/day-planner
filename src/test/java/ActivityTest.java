package test.java;

import main.java.Activity;
import org.junit.jupiter.api.Test;
import test.java.util.TestUtils;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityTest {
    @Test
    void isSortableByActivityStartTime() {
        OffsetDateTime am9 = TestUtils.fromTime( 9, 0);
        OffsetDateTime pm2 = TestUtils.fromTime( 14, 0);
        OffsetDateTime pm5 = TestUtils.fromTime( 17, 0);
        Activity act9am = new Activity("Wake up", am9);
        Activity act2pm = new Activity("Lunch", pm2);
        Activity act5pm = new Activity("Dinner", pm5);
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(act2pm);
        activities.add(act5pm);
        activities.add(act9am);

        activities.sort(Activity::compareTo);
        Activity[] activitiesArray = activities.toArray(new Activity[activities.size()]);
        assertEquals(activitiesArray[0].getStartsAt(), am9);
        assertEquals(activitiesArray[1].getStartsAt(), pm2);
        assertEquals(activitiesArray[2].getStartsAt(), pm5);
    }
}
