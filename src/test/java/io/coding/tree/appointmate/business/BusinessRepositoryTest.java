package io.coding.tree.appointmate.business;

import static org.assertj.core.api.Assertions.assertThat;

import io.coding.tree.appointmate.WithMongoDBReusableTestContainer;
import io.coding.tree.appointmate.business.BusinessRepositoryTest.InitialBusinessDetailsMapperComponentScanConfiguration;
import io.coding.tree.appointmate.business.registration.InitialBusinessDetailsProjection;
import io.coding.tree.appointmate.business.registration.InitialBusinessDetailsProjection.InitialBusinessDetailsMapper;
import io.coding.tree.appointmate.factory.InitialBusinessDetailsFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@DataMongoTest
@Import(InitialBusinessDetailsMapperComponentScanConfiguration.class)
@Slf4j
class BusinessRepositoryTest implements WithMongoDBReusableTestContainer {

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private InitialBusinessDetailsMapper initialBusinessDetailsMapper;

    @Test
    void findInitialBusinessDetailsByBusinessId() {
        InitialBusinessDetailsProjection initialBusinessDetailsProjection = InitialBusinessDetailsFactory.createComplete();

        log.info("Before save: {}", initialBusinessDetailsProjection);

        Business savedBusiness = businessRepository.save(
            initialBusinessDetailsMapper.toBusiness(initialBusinessDetailsProjection));

        assertThat(savedBusiness).isNotNull();

        log.info("Saved business: {}", savedBusiness);
        log.info("Saved initialBusinessDetailsProjection: {}",
            businessRepository.findInitialBusinessDetailsProjectionByBusinessId(
                savedBusiness.getBusinessId().orElseThrow()));
    }

    @TestConfiguration
    @ComponentScan(basePackageClasses = {InitialBusinessDetailsMapper.class})
    static class InitialBusinessDetailsMapperComponentScanConfiguration {

    }
}
