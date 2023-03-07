package io.coding.tree.appointmate.business;

import io.coding.tree.appointmate.common.AuditMetadata;
import io.coding.tree.appointmate.common.EmailAddress;
import io.coding.tree.appointmate.common.PhoneNumber;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

@Document(Business.COLLECTION_NAME)
@Value
@RequiredArgsConstructor(onConstructor_ = @PersistenceCreator)
public final class Business {

    static final String COLLECTION_NAME = "businesses";

    @Version
    @Nullable
    private final Long version;

    @Id
    @Nullable
    private final BusinessId businessId;
    private final EmailAddress email;
    private final String businessName;
    private final PhoneNumber phoneNumber;
    private final BusinessHours businessHours;
    private final Set<Staff> staff;
    private final Set<BusinessServiceOffering> serviceOfferings;

    private final AuditMetadata auditMetadata;

    public Optional<BusinessId> getBusinessId() {
        return Optional.ofNullable(businessId);
    }
}
