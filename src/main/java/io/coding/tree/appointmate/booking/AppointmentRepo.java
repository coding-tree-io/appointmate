package io.coding.tree.appointmate.booking;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepo extends MongoRepository<Appointment, AppointmentId> {
}

