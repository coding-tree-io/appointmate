package io.coding.tree.appointmate.business;

import org.javamoney.moneta.FastMoney;

import java.time.Duration;
import java.util.Set;

//TODO: Currency must be the same accross all services offered by a business
public record Service(String serviceName, Duration duration, FastMoney price, Set<Staff> staff) {
}
