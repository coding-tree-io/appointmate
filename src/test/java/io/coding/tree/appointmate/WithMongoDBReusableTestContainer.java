package io.coding.tree.appointmate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;


public interface WithMongoDBReusableTestContainer {

    MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest").withReuse(true);

    @BeforeAll
    static void startContainers() {
        mongoDBContainer.start();
    }

    @AfterAll
    static void stopContainers() {
        mongoDBContainer.stop();
    }

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }
}
