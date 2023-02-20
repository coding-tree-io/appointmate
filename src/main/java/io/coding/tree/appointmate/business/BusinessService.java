package io.coding.tree.appointmate.business;

import java.time.Duration;
import java.util.Set;
import org.javamoney.moneta.FastMoney;

//TODO: Currency must be the same accross all services offered by a business
public record BusinessService(String serviceName, Duration duration, FastMoney price, Set<Staff> staff) {

}
