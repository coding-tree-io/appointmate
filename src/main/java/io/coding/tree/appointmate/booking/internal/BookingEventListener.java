package io.coding.tree.appointmate.booking.internal;

import io.coding.tree.appointmate.booking.Appointment;
import io.coding.tree.appointmate.booking.AppointmentRepo;
import java.time.Duration;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.instancio.Instancio;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
record BookingEventListener(AppointmentRepo appointmentRepo) {

    @EventListener
    public void onApplicationReadyEvent(ApplicationReadyEvent event) {
        appointmentRepo.deleteAll();
        appointmentRepo.save(Appointment.withRandomId(Instancio.create(Instant.class),
            Instancio.create(Duration.class)));
        log.warn("{}", appointmentRepo.findAll());
    }
}
