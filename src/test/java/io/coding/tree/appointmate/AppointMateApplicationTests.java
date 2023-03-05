package io.coding.tree.appointmate;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

@Slf4j
class AppointMateApplicationTests {

    @Test
    void verifyModules() {
        var modules = ApplicationModules.of(AppointMateApplication.class);
        modules.forEach(module -> log.info("{}", module));
        modules.verify();
    }
}
