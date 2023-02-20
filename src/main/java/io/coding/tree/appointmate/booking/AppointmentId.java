package io.coding.tree.appointmate.booking;

import java.util.UUID;

import static org.springframework.util.Assert.notNull;

public record AppointmentId(UUID id) {

    public AppointmentId {
        notNull(id, "Appointment Id must not be null");
    }

    public static AppointmentId withRandomUUID() {
        return new AppointmentId(UUID.randomUUID());
    }
}
