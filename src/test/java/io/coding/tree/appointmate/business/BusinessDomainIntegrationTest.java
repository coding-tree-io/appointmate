package io.coding.tree.appointmate.business;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.containsString;

import io.coding.tree.appointmate.MongoDBContainerTest;
import io.coding.tree.appointmate.business.BusinessController.BusinessRegistrationRequest;
import io.coding.tree.appointmate.business.BusinessController.BusinessRegistrationRequest.Address;
import io.coding.tree.appointmate.business.BusinessController.BusinessRegistrationRequest.BusinessContactInformation;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

class BusinessDomainIntegrationTest extends MongoDBContainerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;


    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Nested
    class RegistrationTest {

        @Test
        @DisplayName("Allow businesses to register with the application by providing basic details like name, address, and contact information.")
        void aBusinessShouldBeAbleToRegisterUsingBasicDetails() {

            BusinessRegistrationRequest businessRegistrationRequest = new BusinessRegistrationRequest("My Business",
                new Address("Canada", "Toronto", "King Street", "123", "M5V 1J5"),
                new BusinessContactInformation("1234567890", "email@gmail.com"));

            given()
                .body(businessRegistrationRequest)
                .when()
                .post("/business/register")
                .then()
                .log().ifValidationFails()
                .statusCode(201).body(containsString("businessId:"));
        }
    }

}
