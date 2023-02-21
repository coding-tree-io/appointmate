package io.coding.tree.appointmate.common.internal;

import net.datafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DataFakerConfig {

    @Bean
    Faker dataFaker() {
        return new Faker();
    }
}
