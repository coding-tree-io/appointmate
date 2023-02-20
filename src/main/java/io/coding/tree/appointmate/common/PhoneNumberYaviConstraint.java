package io.coding.tree.appointmate.common;

import am.ik.yavi.core.CustomConstraint;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import org.springframework.lang.Nullable;

import static org.springframework.util.Assert.hasText;

class PhoneNumberYaviConstraint implements CustomConstraint<String> {

    private final String region;
    @Nullable
    private NumberParseException parseException;

    public PhoneNumberYaviConstraint(String region) {
        hasText(region, "Region must not be empty");
        this.region = region;
    }

    @Override
    public boolean test(String number) {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        try {
            var phoneNumber = phoneNumberUtil.parse(number, region);
            return phoneNumberUtil.isValidNumberForRegion(phoneNumber, region);
        } catch (NumberParseException e) {
            this.parseException = e;
            return false;
        }
    }

    @Override
    public String defaultMessageFormat() {
        return parseException != null
            ? "Error parsing \"{1}\": " + parseException
            : "\"{1}\" must be a valid phone number for region " + region;
    }

    @Override
    public String messageKey() {
        return "phone.number.invalid";
    }
}


