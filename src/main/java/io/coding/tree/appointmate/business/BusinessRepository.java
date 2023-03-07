package io.coding.tree.appointmate.business;

import io.coding.tree.appointmate.business.registration.InitialBusinessDetailsProjection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusinessRepository extends MongoRepository<Business, BusinessId> {

    InitialBusinessDetailsProjection findInitialBusinessDetailsProjectionByBusinessId(BusinessId businessId);
}

