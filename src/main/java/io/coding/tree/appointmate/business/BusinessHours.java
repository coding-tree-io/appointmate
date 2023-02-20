package io.coding.tree.appointmate.business;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Set;

public record BusinessHours(ZoneId timezone, Set<BusinessDay> businessDays) {

    public record BusinessDay(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime,
                              BusinessStatus businessStatus) {
    }
}
