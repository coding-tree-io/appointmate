package io.coding.tree.appointmate.factory;

import io.coding.tree.appointmate.common.EmailAddress;
import java.util.Locale;
import org.instancio.Random;
import org.instancio.generator.Generator;

public class EmailGenerator implements Generator<EmailAddress> {

    public static final EmailGenerator INSTANCE = new EmailGenerator();

    private static final String[] DOMAIN_NAMES = {"com", "edu", "net", "org"};

    @Override
    public EmailAddress generate(Random random) {

        int minLength = 7;
        int maxLength = 24;
        final int len = random.intRange(minLength, maxLength);

        final String tld = "." + random.oneOf(DOMAIN_NAMES);
        final int rem = len - tld.length() - 1; // -1 for @
        return new EmailAddress(email(random, rem) + tld);
    }

    private String email(final Random random, final int length) {
        final int localPartLen = random.intRange(1, length - 1);
        final int domainLen = length - localPartLen;
        final String localPart = random.alphanumeric(localPartLen).toLowerCase(Locale.ROOT);
        final String domain = random.alphanumeric(domainLen).toLowerCase(Locale.ROOT);
        return localPart + '@' + domain;
    }
}
