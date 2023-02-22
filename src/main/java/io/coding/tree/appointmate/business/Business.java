package io.coding.tree.appointmate.business;

import io.coding.tree.appointmate.common.PhoneNumber;
import java.time.Instant;
import java.util.Set;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

@Document(Business.COLLECTION_NAME)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Getter(AccessLevel.NONE)
@RequiredArgsConstructor
public class Business {

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

    @CreatedDate
    @Nullable
    private Instant createdAt;
    @LastModifiedDate
    @Nullable
    private Instant updatedAt;

    public static Business withRandomId(String businessName, Industry industry, PhoneNumber phoneNumber,
        BusinessHours businessHours, Set<Staff> staff, Set<BusinessServiceOffering> businessServiceOfferings) {
        return new Business(BusinessId.withRandomUUID(), businessName, industry,
            phoneNumber, businessHours, staff, businessServiceOfferings);
    }
}
