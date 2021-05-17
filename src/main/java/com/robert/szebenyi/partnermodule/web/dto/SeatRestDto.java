package com.robert.szebenyi.partnermodule.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeatRestDto {

    private String id;

    private long price;

    private String currency;

    private boolean reserved;

}
