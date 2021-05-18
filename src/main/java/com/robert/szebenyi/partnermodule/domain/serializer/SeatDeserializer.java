package com.robert.szebenyi.partnermodule.domain.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.robert.szebenyi.partnermodule.domain.Seat;

import java.io.IOException;

public class SeatDeserializer extends StdDeserializer<Seat> {

    public SeatDeserializer() {
        this(null);
    }

    public SeatDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Seat deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        TreeNode node = p.getCodec().readTree(p);
        String seatId = ((TextNode) node.get("id")).textValue();
        int price = (Integer) ((IntNode) node.get("price")).numberValue();
        String currency = ((TextNode) node.get("currency")).textValue();
        boolean isReserved = ((BooleanNode) node.get("reserved")).booleanValue();

        return Seat.builder()
                .seatId(seatId)
                .price(price)
                .currency(currency)
                .reserved(isReserved)
                .build();
    }
}