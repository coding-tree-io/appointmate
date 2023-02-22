package io.coding.tree.appointmate.business;

import static org.springframework.http.HttpStatus.CREATED;

import io.coding.tree.appointmate.common.PhoneNumber;
import java.time.ZoneId;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BusinessController {

    private final BusinessRepo businessRepository;

    @PostMapping("/business/register")
    @ResponseStatus(CREATED)
    public @ResponseBody BusinessId register(@RequestBody BusinessRegistrationRequest request) {
        Business business = businessRepository.save(
            Business.withRandomId(request.name, request.industry,
                new PhoneNumber(request.contactInformation.phoneNumber, request.address.country),
                new BusinessHours(ZoneId.systemDefault(), Set.of()), Set.of(), Set.of()));
        return business.getBusinessId();
    }

    public record BusinessRegistrationRequest(String name, Address address,
                                              BusinessContactInformation contactInformation, Industry industry) {

        public record Address(String country, String city, String Street, String streetNumber, String postalCode) {

        }

        public record BusinessContactInformation(String phoneNumber, String email) {

        }
    }
}
