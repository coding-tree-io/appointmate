package io.coding.tree.appointmate.business.registration.socialregistration;

import io.coding.tree.appointmate.AppointMateApplication;
import io.coding.tree.appointmate.WithMongoDBReusableTestContainer;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AppointMateApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Disabled
class BusinessSocialRegistrationIntegrationTest implements WithMongoDBReusableTestContainer {

    @Autowired
    private BusinessSocialRegistrationController businessSocialRegistrationController;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(businessSocialRegistrationController);
    }

    @Test
    void register() {
    }
}
