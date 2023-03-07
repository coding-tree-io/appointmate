package io.coding.tree.appointmate.business.registration;

import io.coding.tree.appointmate.business.Business;
import io.coding.tree.appointmate.business.BusinessHours;
import io.coding.tree.appointmate.business.BusinessId;
import io.coding.tree.appointmate.business.BusinessServiceOffering;
import io.coding.tree.appointmate.business.Staff;
import io.coding.tree.appointmate.common.AuditMetadata;
import io.coding.tree.appointmate.common.EmailAddress;
import io.coding.tree.appointmate.common.PhoneNumber;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-07T10:40:45+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (IBM Corporation)"
)
@Component
public class InitialBusinessDetailsProjection$InitialBusinessDetailsMapperImpl implements InitialBusinessDetailsProjection.InitialBusinessDetailsMapper {

    @Override
    public Business toBusiness(InitialBusinessDetailsProjection initialBusinessDetailsProjection) {
        if ( initialBusinessDetailsProjection == null ) {
            return null;
        }

        BusinessId businessId = null;
        EmailAddress email = null;
        String businessName = null;

        businessId = initialBusinessDetailsProjection.businessId();
        email = initialBusinessDetailsProjection.email();
        businessName = initialBusinessDetailsProjection.businessName();

        Long version = null;
        PhoneNumber phoneNumber = null;
        BusinessHours businessHours = null;
        Set<Staff> staff = null;
        Set<BusinessServiceOffering> serviceOfferings = null;
        AuditMetadata auditMetadata = null;

        Business business = new Business( version, businessId, email, businessName, phoneNumber, businessHours, staff, serviceOfferings, auditMetadata );

        return business;
    }
}
