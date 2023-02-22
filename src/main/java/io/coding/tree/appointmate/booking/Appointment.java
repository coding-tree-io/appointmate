package io.coding.tree.appointmate.booking;

import io.coding.tree.appointmate.common.AuditMetadata;
import java.time.Duration;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

@Document(Appointment.COLLECTION_NAME)
@Value
@Getter(AccessLevel.NONE)
@RequiredArgsConstructor(onConstructor_ = @PersistenceCreator)
public final class Appointment {

    static final String COLLECTION_NAME = "appointments";

    @Version
    @Nullable
    private final Long version;
    @Id
    private final AppointmentId appointmentId;
    private final Instant appointmentTime;
    private final Duration appointmentDuration;

    private final AuditMetadata auditMetadata;

    private Appointment(AppointmentId appointmentId, Instant appointmentTime, Duration appointmentDuration) {
        this.version = null;
        this.appointmentId = appointmentId;
        this.appointmentTime = appointmentTime;
        this.appointmentDuration = appointmentDuration;
        this.auditMetadata = new AuditMetadata(null, null);
    }

    public static Appointment withRandomId(Instant appointmentTime, Duration appointmentDuration) {
        return new Appointment(AppointmentId.withRandomUUID(), appointmentTime, appointmentDuration);
    }
}
