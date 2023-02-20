package io.coding.tree.appointmate.business;

import io.coding.tree.appointmate.common.EmailAddress;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

public record Staff(String name, EmailAddress email) {

    public Staff {
        hasText(name, "Name must not be empty");
        notNull(email, "Email must not be null");
    }
}
