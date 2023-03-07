package io.coding.tree.appointmate.business.registration.socialregistration;

import static org.springframework.http.HttpStatus.CREATED;

import io.coding.tree.appointmate.business.BusinessId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class BusinessSocialRegistrationController {

    static final String BUSINESS_SOCIAL_REGISTRATION_URL = "/business/social-registration";

    private final BusinessSocialRegistrationService businessSocialRegistrationService;

    @PostMapping(BUSINESS_SOCIAL_REGISTRATION_URL)
    @ResponseStatus(CREATED)
    public @ResponseBody BusinessId register(
        @RequestBody BusinessSocialRegistrationRequest businessSocialRegistrationRequest) {

        return businessSocialRegistrationService.registerBusiness(businessSocialRegistrationRequest);
    }
}
