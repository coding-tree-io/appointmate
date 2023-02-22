package io.coding.tree.appointmate.common;

import java.time.Instant;
import java.util.Optional;
import lombok.Value;
import lombok.With;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.lang.Nullable;

@Value
public final class AuditMetadata {

    @CreatedDate
    @Nullable
    @With
    private final Instant createdAt;
    @LastModifiedDate
    @Nullable
    @With
    private final Instant updatedAt;

    public Optional<Instant> getCreatedAt() {
        return Optional.ofNullable(createdAt);
    }

    public Optional<Instant> getUpdatedAt() {
        return Optional.ofNullable(updatedAt);
    }
}
