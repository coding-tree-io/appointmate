package io.coding.tree.appointmate.business.registration;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import io.coding.tree.appointmate.AppointMateApplication;
import io.coding.tree.appointmate.WithMongoDBTestContainer;
import io.coding.tree.appointmate.business.Industry;
import io.coding.tree.appointmate.business.registration.BusinessRegistrationController.BusinessRegistrationRequest;
import io.coding.tree.appointmate.business.registration.BusinessRegistrationController.BusinessRegistrationRequest.Address;
import io.coding.tree.appointmate.business.registration.BusinessRegistrationController.BusinessRegistrationRequest.BusinessContactInformation;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;

@SpringBootTest(classes = AppointMateApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BusinessRegistrationIntegrationTest implements WithMongoDBTestContainer {

    @Autowired
    private BusinessRegistrationController businessRegistrationController;


    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(businessRegistrationController);
    }

    @Nested
    class InitialRegistrationTest {

        @Test
        @DisplayName("Allow businesses to register with the application by providing basic details like name, address, and contact information.")
        void aBusinessShouldBeAbleToRegisterUsingBasicDetails() {

            BusinessRegistrationRequest businessRegistrationRequest = new BusinessRegistrationRequest("My Business",
                new Address("GR", "Toronto", "King Street", "123", "M5V 1J5"),
                new BusinessContactInformation("+30 6976570363", "email@gmail.com"), Industry.FITNESS);

            given()
                .body(businessRegistrationRequest)
                .header(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .when()
                .post("/business/register")
                .then()
                .log().ifValidationFails()
                .statusCode(201)
                .body("id", notNullValue());
        }
    }

}
