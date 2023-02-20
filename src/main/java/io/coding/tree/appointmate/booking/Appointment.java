package io.coding.tree.appointmate.booking;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;
import java.time.Instant;

import static org.springframework.util.Assert.notNull;

@Document(Appointment.COLLECTION_NAME)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Getter(AccessLevel.NONE)
public class Appointment {
    static final String COLLECTION_NAME = "appointments";

    @Id
    private final AppointmentId appointmentId;
    private final Instant appointmentTime;
    private final Duration appointmentDuration;

    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;

    public Appointment(AppointmentId appointmentId, Instant appointmentTime, Duration appointmentDuration) {
        notNull(appointmentId, "Appointment ID must not be null");
        notNull(appointmentTime, "Appointment time must not be null");
        notNull(appointmentDuration, "Appointment duration must not be null");
        this.appointmentId = appointmentId;
        this.appointmentTime = appointmentTime;
        this.appointmentDuration = appointmentDuration;
    }

    public static Appointment withRandomId(Instant appointmentTime, Duration appointmentDuration) {
        return new Appointment(AppointmentId.withRandomUUID(), appointmentTime, appointmentDuration);
    }
}
