package io.coding.tree.appointmate.common;

import am.ik.yavi.arguments.StringValidator;
import am.ik.yavi.builder.StringValidatorBuilder;
import am.ik.yavi.core.ConstraintViolationsException;

public record EmailAddress(String value) {
    private static final StringValidator<String> emailValidator = StringValidatorBuilder
        .of("The given email", constraint -> constraint.notBlank().lessThanOrEqual(100).email())
        .build();

    public EmailAddress {
        emailValidator.validate(value).throwIfInvalid(ConstraintViolationsException::new);
    }
}
