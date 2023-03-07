package io.coding.tree.appointmate.business.registration.socialregistration;

import io.coding.tree.appointmate.business.BusinessId;
import org.springframework.stereotype.Service;

@Service
class BusinessSocialRegistrationService {

    public BusinessId registerBusiness(BusinessSocialRegistrationRequest businessSocialRegistrationRequest) {

        return BusinessId.withRandomUUID();
    }
}
