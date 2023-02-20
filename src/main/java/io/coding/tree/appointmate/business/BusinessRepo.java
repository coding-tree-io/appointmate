package io.coding.tree.appointmate.business;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusinessRepo extends MongoRepository<Business, BusinessId> {
}

