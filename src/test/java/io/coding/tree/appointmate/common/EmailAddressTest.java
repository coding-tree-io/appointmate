package io.coding.tree.appointmate.common;

import am.ik.yavi.core.ConstraintViolationsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class EmailAddressTest {
    private static final Logger log = LoggerFactory.getLogger(EmailAddressTest.class);

    @DisplayName("Valid email addresses should be accepted")
    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {"john@example.com", "jane.doe@example.co.uk", "someone+else@example.org"})
    void validEmailAddresses(String email) {
        EmailAddress emailAddress = new EmailAddress(email);
        assertThat(emailAddress.value()).isEqualTo(email);
    }

    @DisplayName("Invalid email addresses should be rejected")
    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {"invalid_email", "missing-at.example.com", "extra@.example.com"})
    void invalidEmailAddresses(String email) {
        Throwable thrown = catchThrowable(() -> new EmailAddress(email));

        assertThat(thrown).isInstanceOf(ConstraintViolationsException.class);

        log.info(thrown.getMessage());
    }
}
