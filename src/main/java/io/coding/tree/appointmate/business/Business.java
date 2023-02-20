package io.coding.tree.appointmate.business;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

import io.coding.tree.appointmate.common.PhoneNumber;
import java.time.Instant;
import java.util.Set;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
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
    private final Set<BusinessService> businessServices;

    @CreatedDate
    @Nullable
    private Instant createdAt;
    @LastModifiedDate
    @Nullable
    private Instant updatedAt;

    public Business(BusinessId businessId, String businessName, Industry industry, PhoneNumber phoneNumber,
        BusinessHours businessHours, Set<Staff> staff, Set<BusinessService> businessServices) {
        notNull(businessId, "Business ID must not be null");
        hasText(businessName, "Business name must not be empty");
        notNull(industry, "Business industry must not be null");
        notNull(phoneNumber, "Business phone number must not be null");
        notNull(businessHours, "Business hours must not be null");
        notNull(staff, "Business staff must not be null");
        notNull(businessServices, "Business businessServices must not be null");
        this.businessId = businessId;
        this.businessName = businessName;
        this.industry = industry;
        this.phoneNumber = phoneNumber;
        this.businessHours = businessHours;
        this.staff = staff;
        this.businessServices = businessServices;
    }

    public static Business withRandomId(String businessName, Industry industry, PhoneNumber phoneNumber,
        BusinessHours businessHours, Set<Staff> staff, Set<BusinessService> businessServices) {
        return new Business(BusinessId.withRandomUUID(), businessName, industry,
            phoneNumber, businessHours, staff, businessServices);
    }
}
