package main.java;

import java.time.OffsetDateTime;
import java.util.Objects;

public class Activity implements Comparable<Activity>{

    private final String action;
    private final OffsetDateTime startsAt;

    public Activity(String action, OffsetDateTime startsAt) {
        this.action = action;
        this.startsAt = startsAt;
    }

    public OffsetDateTime getStartsAt() {
        return startsAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity1 = (Activity) o;
        return Objects.equals(action, activity1.action) &&
                Objects.equals(startsAt, activity1.startsAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, startsAt);
    }

    @Override
    public int compareTo(Activity o) {
        return this.getStartsAt().compareTo(o.getStartsAt());
    }

    public String getAction() {
        return action;
    }
}
