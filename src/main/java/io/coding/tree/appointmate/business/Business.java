package io.coding.tree.appointmate.business;

import io.coding.tree.appointmate.common.AuditMetadata;
import io.coding.tree.appointmate.common.PhoneNumber;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

@Document(Business.COLLECTION_NAME)
@Value
@Getter(AccessLevel.NONE)
@RequiredArgsConstructor(onConstructor_ = @PersistenceCreator)
public final class Business {

    static final String COLLECTION_NAME = "businesses";

    @Version
    @Nullable
    private final Long version;
    @Id
    private final BusinessId businessId;
    @Indexed(name = "businessName_index")
    private final String businessName;
    private final Industry industry;
    private final PhoneNumber phoneNumber;
    private final BusinessHours businessHours;
    private final Set<Staff> staff;
    private final Set<BusinessServiceOffering> serviceOfferings;

    private final AuditMetadata auditMetadata;

    private Business(BusinessId businessId, String businessName, Industry industry, PhoneNumber phoneNumber,
        BusinessHours businessHours, Set<Staff> staff, Set<BusinessServiceOffering> serviceOfferings) {
        this.version = null;
        this.businessId = businessId;
        this.businessName = businessName;
        this.industry = industry;
        this.phoneNumber = phoneNumber;
        this.businessHours = businessHours;
        this.staff = staff;
        this.serviceOfferings = serviceOfferings;
        this.auditMetadata = new AuditMetadata(null, null);
    }

    public static Business withRandomId(String businessName, Industry industry, PhoneNumber phoneNumber,
        BusinessHours businessHours, Set<Staff> staff, Set<BusinessServiceOffering> serviceOfferings) {
        return new Business(BusinessId.withRandomUUID(), businessName, industry,
            phoneNumber, businessHours, staff, serviceOfferings);
    }
}
