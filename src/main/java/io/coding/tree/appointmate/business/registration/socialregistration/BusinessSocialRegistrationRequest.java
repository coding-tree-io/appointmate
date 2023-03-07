package io.coding.tree.appointmate.business.registration.socialregistration;

import java.util.Optional;

record BusinessSocialRegistrationRequest(BusinessContactInformation contactInformation,
                                         Optional<String> businessURLsuffix) {

    record BusinessContactInformation(String email, String name) {

    }
}

