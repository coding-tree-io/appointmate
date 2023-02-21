package io.coding.tree.appointmate.business.internal;

import io.coding.tree.appointmate.business.Business;
import io.coding.tree.appointmate.business.BusinessHours;
import io.coding.tree.appointmate.business.BusinessRepo;
import io.coding.tree.appointmate.business.BusinessService;
import io.coding.tree.appointmate.business.Industry;
import io.coding.tree.appointmate.business.Staff;
import io.coding.tree.appointmate.common.EmailAddress;
import io.coding.tree.appointmate.common.PhoneNumber;
import java.time.Duration;
import java.util.Currency;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.instancio.Instancio;
import org.javamoney.moneta.FastMoney;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
record BusinessEventListener(BusinessRepo businessRepo) {

    @EventListener
    public void onApplicationReadyEvent(ApplicationReadyEvent event) {
        Staff johnDoe = new Staff("John Doe", new EmailAddress("email@email.com"));
        businessRepo.deleteAll();
        businessRepo.save(
            Business.withRandomId(
                "Test Business",
                Industry.FITNESS,
                new PhoneNumber("6947347556", "GR"),
                Instancio.create(BusinessHours.class),
                Set.of(johnDoe),
                Set.of(new BusinessService("Test service", Instancio.create(Duration.class),
                    FastMoney.of(200.20, Currency.getInstance("USD").getCurrencyCode()), Set.of(johnDoe)))));
        log.warn("{}", businessRepo.findAll());
    }
}
