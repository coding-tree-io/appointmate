package io.coding.tree.appointmate.booking;

import io.coding.tree.appointmate.common.AuditMetadata;
import java.time.Duration;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(Appointment.COLLECTION_NAME)
@Value
@Getter(AccessLevel.NONE)
public final class Appointment {

    static final String COLLECTION_NAME = "appointments";

    @Id
    private final AppointmentId appointmentId;
    private final Instant appointmentTime;
    private final Duration appointmentDuration;

    private final AuditMetadata auditMetadata;

    public static Appointment withRandomId(Instant appointmentTime, Duration appointmentDuration) {
        return new Appointment(AppointmentId.withRandomUUID(), appointmentTime, appointmentDuration,
            new AuditMetadata(null, null));
    }
}
