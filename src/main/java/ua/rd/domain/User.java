package ua.rd.domain;

import ua.rd.services.TimelineOperations;

public class User {


    private String name;

    private TimelineOperations timelineOperations ;


    public User(String name) {
        this.name = name;
    }

    public void setTimelineOperations(TimelineOperations timelineOperations) {
        this.timelineOperations = timelineOperations;
    }

    public TimelineOperations getTimelineOperations() {
        return timelineOperations;
    }



    @Override
    public String toString() {
        return "User{" +
            "name='" + name + '\'' +
            ", timelineOperations=" + timelineOperations +
            '}';
    }
}
