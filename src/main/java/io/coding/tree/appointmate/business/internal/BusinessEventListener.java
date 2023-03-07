package io.coding.tree.appointmate.business.internal;

import io.coding.tree.appointmate.business.BusinessRepository;
import io.coding.tree.appointmate.business.Staff;
import io.coding.tree.appointmate.common.EmailAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
record BusinessEventListener(BusinessRepository businessRepository) {

    @EventListener
    public void onApplicationReadyEvent(ApplicationReadyEvent event) {
        Staff johnDoe = new Staff("John Doe", new EmailAddress("email@email.com"));
        businessRepository.deleteAll();
//        businessRepository.save(
//            Business.withRandomId(
//                "Test Business",
//                new PhoneNumber("6947347556", "GR"),
//                Instancio.create(BusinessHours.class),
//                Set.of(johnDoe),
//                Set.of(
//                    new BusinessServiceOffering("Test service", Instancio.create(Duration.class),
//                        Set.of(johnDoe)))));
        log.warn("{}", businessRepository.findAll());
    }
}
