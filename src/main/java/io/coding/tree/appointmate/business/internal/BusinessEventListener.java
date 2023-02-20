package io.coding.tree.appointmate.business.internal;

import io.coding.tree.appointmate.business.*;
import io.coding.tree.appointmate.common.EmailAddress;
import io.coding.tree.appointmate.common.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.instancio.Instancio;
import org.javamoney.moneta.FastMoney;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Currency;
import java.util.Set;

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
                Set.of(new Service("Test Service", Instancio.create(Duration.class),
                    FastMoney.of(200.20, Currency.getInstance("USD").getCurrencyCode()), Set.of(johnDoe)))));
        log.warn("{}", businessRepo.findAll());
    }
}
