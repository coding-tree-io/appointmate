package io.coding.tree.appointmate;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.modulith.core.ApplicationModules;

class AppointMateApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(AppointMateApplicationTests.class);

    @Test
    void verifyModules() {
        var modules = ApplicationModules.of(AppointMateApplication.class);
        modules.forEach(module -> log.info("{}", module));
        modules.verify();
    }
}
