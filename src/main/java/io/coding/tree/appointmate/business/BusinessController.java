package io.coding.tree.appointmate.business;

public class BusinessController {

    public record BusinessRegistrationRequest(String name, Address address,
                                               BusinessContactInformation contactInformation) {

        public record Address(String Country, String City, String Street, String StreetNumber, String postalCode) {

        }

        public record BusinessContactInformation(String phoneNumber, String email) {

        }
    }

}
