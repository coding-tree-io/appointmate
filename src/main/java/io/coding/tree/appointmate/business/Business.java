package io.coding.tree.appointmate.business;

import io.coding.tree.appointmate.common.AuditMetadata;
import io.coding.tree.appointmate.common.PhoneNumber;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(Business.COLLECTION_NAME)
@Value
@Getter(AccessLevel.NONE)
public final class Business {

    static final String COLLECTION_NAME = "businesses";

    @Id
    private final BusinessId businessId;
    @Indexed(name = "businessName_index")
    private final String businessName;
    private final Industry industry;
    private final PhoneNumber phoneNumber;
    private final BusinessHours businessHours;
    private final Set<Staff> staff;
    private final Set<BusinessServiceOffering> businessServiceOfferings;

    private final AuditMetadata auditMetadata;

    public static Business withRandomId(String businessName, Industry industry, PhoneNumber phoneNumber,
        BusinessHours businessHours, Set<Staff> staff, Set<BusinessServiceOffering> businessServiceOfferings) {
        return new Business(BusinessId.withRandomUUID(), businessName, industry,
            phoneNumber, businessHours, staff, businessServiceOfferings, new AuditMetadata(null, null));
    }
}
