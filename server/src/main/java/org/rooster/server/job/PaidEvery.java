package org.rooster.server.job;

import lombok.Getter;

@Getter
public enum PaidEvery {
    YEAR("Year"),
    MONTH("Month"),
    WEEK("Week"),
    DAY("Day"),
    HOUR("Hour");

    private final String duration;

    PaidEvery(String duration) {
        this.duration = duration;
    }
}
