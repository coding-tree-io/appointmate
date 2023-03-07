package io.coding.tree.appointmate.factory;

import static org.instancio.Select.all;

import io.coding.tree.appointmate.common.EmailAddress;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailFactory {

    public static EmailAddress createEmail() {
        return Instancio.of(EmailAddress.class)
            .supply(all(EmailAddress.class), EmailGenerator.INSTANCE)
            .create();
    }
}
