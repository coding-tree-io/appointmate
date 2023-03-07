package io.coding.tree.appointmate.factory;

import static org.instancio.Select.all;

import io.coding.tree.appointmate.business.registration.InitialBusinessDetailsProjection;
import io.coding.tree.appointmate.common.EmailAddress;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.InstancioApi;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InitialBusinessDetailsFactory {

    public static InstancioApi<InitialBusinessDetailsProjection> createIncomplete() {
        return Instancio.of(InitialBusinessDetailsProjection.class)
            .supply(all(EmailAddress.class), EmailGenerator.INSTANCE);
    }

    public static InitialBusinessDetailsProjection createComplete() {
        return Instancio.of(InitialBusinessDetailsProjection.class)
            .supply(all(EmailAddress.class), EmailGenerator.INSTANCE)
            .create();
    }
}
