package io.coding.tree.appointmate.common;

import am.ik.yavi.builder.ValidatorBuilder;
import am.ik.yavi.constraint.CharSequenceConstraint;
import am.ik.yavi.core.ConstraintViolationsException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record PhoneNumber(String number, String region) {
    public PhoneNumber(String number, String region) {
        this.number = number;
        this.region = region;

        ValidatorBuilder.<PhoneNumber>of()
            .constraint(PhoneNumber::number, "number", c -> c.notBlank().predicate(new PhoneNumberYaviConstraint(region)))
            .constraint(PhoneNumber::region, "region", CharSequenceConstraint::notBlank)
            .build()
            .validate(this)
            .throwIfInvalid(ConstraintViolationsException::new);
    }
}
