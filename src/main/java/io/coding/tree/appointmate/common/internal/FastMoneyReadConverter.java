package io.coding.tree.appointmate.common.internal;

import org.bson.Document;
import org.javamoney.moneta.FastMoney;
import org.springframework.core.convert.converter.Converter;

class FastMoneyReadConverter implements Converter<Document, FastMoney> {

    @Override
    public FastMoney convert(Document source) {
        double amount = source.getDouble("amount");
        String currencyCode = source.getString("currency");
        return FastMoney.of(amount, currencyCode);
    }
}
