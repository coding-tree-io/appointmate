package io.coding.tree.appointmate.booking;

import java.time.Duration;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

@Document(Appointment.COLLECTION_NAME)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Getter(AccessLevel.NONE)
@RequiredArgsConstructor
public class Appointment {

    static final String COLLECTION_NAME = "appointments";

    @Id
    private final AppointmentId appointmentId;
    private final Instant appointmentTime;
    private final Duration appointmentDuration;

    @CreatedDate
    @Nullable
    private Instant createdAt;
    @LastModifiedDate
    @Nullable
    private Instant updatedAt;

    public static Appointment withRandomId(Instant appointmentTime, Duration appointmentDuration) {
        return new Appointment(AppointmentId.withRandomUUID(), appointmentTime, appointmentDuration);
    }
}
