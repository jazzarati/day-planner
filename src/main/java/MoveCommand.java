package main.java;

import java.time.OffsetDateTime;
import java.util.Objects;

public class MoveCommand {
    private final int activityIndex;
    private final OffsetDateTime time;

    public MoveCommand(int activityIndex, OffsetDateTime time) {
        this.activityIndex = activityIndex;
        this.time = time;
    }

    public int getActivityIndex() {
        return activityIndex;
    }

    public OffsetDateTime getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveCommand that = (MoveCommand) o;
        return activityIndex == that.activityIndex &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityIndex, time);
    }


}
