package com.robert.szebenyi.partnermodule.web.transformer;

import com.robert.szebenyi.partnermodule.domain.Seat;
import com.robert.szebenyi.partnermodule.web.dto.SeatRestDto;
import org.springframework.stereotype.Component;

@Component
public class SeatToSeatRestDtoTransformer extends BaseRestTransformer<Seat, SeatRestDto> {

    @Override
    public SeatRestDto transform(Seat from) {
        if (from == null) {
            return null;
        }

        return SeatRestDto.builder()
                .id(from.getSeatId())
                .price(from.getPrice())
                .currency(from.getCurrency())
                .reserved(from.isReserved())
                .build();
    }
}
