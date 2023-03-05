package io.coding.tree.appointmate.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import am.ik.yavi.core.ConstraintViolationsException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@Slf4j
class PhoneNumberTest {

    private final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

    @ParameterizedTest
    @CsvSource({
        "+1 650-555-1212, US",
        "+44 20 7123 1234, GB",
        "+81 3-1234-5678, JP",
        "+30 6944738220, GR",
        "+306944738220, GR"
    })
    void testValidPhoneNumber(String number, String region) {
        PhoneNumber phoneNumber = new PhoneNumber(number, region);
        assertThat(phoneNumber.number()).isEqualTo(number);
        assertThat(phoneNumber.region()).isEqualTo(region);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "GB",
        "US",
        "FR",
        "GR"
    })
    void testInvalidPhoneNumber(String region) {
        String number = String.valueOf(phoneUtil.getInvalidExampleNumber(region).getNationalNumber());

        Throwable thrown = catchThrowable(() -> new PhoneNumber(number, region));

        assertThat(thrown).isInstanceOf(ConstraintViolationsException.class);

        log.info(thrown.getMessage());
    }
}
