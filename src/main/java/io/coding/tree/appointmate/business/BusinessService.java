package io.coding.tree.appointmate.business;

import java.time.Duration;
import java.util.Set;

public record BusinessService(String serviceName, Duration duration, Set<Staff> staff) {

}
