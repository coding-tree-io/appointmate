package io.coding.tree.appointmate.business;

import java.util.UUID;

import static org.springframework.util.Assert.notNull;

public record BusinessId(UUID id) {

    public BusinessId {
        notNull(id, "Business Id must not be null");
    }

    public static BusinessId withRandomUUID() {
        return new BusinessId(UUID.randomUUID());
    }
}
