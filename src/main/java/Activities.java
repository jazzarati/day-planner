package main.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Activities implements Iterable<Activity> {
    private final ArrayList<Activity> activities;

    public Activities() {
        this.activities = new ArrayList<>();
    }

    public void add(Activity activity) {
        activities.add(activity);
        activities.sort(Activity::compareTo);
    }

    public Activity remove(int index) {
        return activities.remove(index);
    }

    public void move(MoveCommand moveCommand) {
        Activity removedActivity = remove(moveCommand.getActivityIndex());
        add(new Activity(removedActivity.getAction(), moveCommand.getTime()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activities that = (Activities) o;
        return Objects.equals(activities, that.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activities);
    }

    public Activity[] toArray() {
        return activities.toArray(new Activity[activities.size()]);
    }

    public int size() { return activities.size(); }

    @Override
    public Iterator<Activity> iterator() {
        return activities.iterator();
    }

}
