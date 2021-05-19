package com.robert.szebenyi.partnermodule.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReserveRestRequestDto {

    @NotNull
    private long eventId;

    @NotNull
    private long seatId;

}
