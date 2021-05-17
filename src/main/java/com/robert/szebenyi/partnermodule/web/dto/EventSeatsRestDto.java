package com.robert.szebenyi.partnermodule.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventSeatsRestDto {

    private int eventId;

    private List<SeatRestDto> seats;

}
