package io.coding.tree.appointmate.common.internal;

import org.bson.Document;
import org.javamoney.moneta.FastMoney;
import org.springframework.core.convert.converter.Converter;

class FastMoneyWriteConverter implements Converter<FastMoney, Document> {
    @Override
    public Document convert(FastMoney source) {
        Document document = new Document();
        document.put("amount", source.getNumber().doubleValueExact());
        document.put("currency", source.getCurrency().getCurrencyCode());
        return document;
    }
}
