package com.robert.szebenyi.partnermodule.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventRestResponseDto {

    private int eventId;

    private String title;

    private String location;

    private long startTimeStamp;

    private long endTimeStamp;

}
