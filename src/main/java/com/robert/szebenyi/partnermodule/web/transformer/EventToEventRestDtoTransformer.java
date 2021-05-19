package com.robert.szebenyi.partnermodule.web.transformer;

import com.robert.szebenyi.partnermodule.domain.Event;
import com.robert.szebenyi.partnermodule.web.dto.EventRestResponseDto;
import org.springframework.stereotype.Component;

@Component
public class EventToEventRestDtoTransformer extends BaseRestTransformer<Event, EventRestResponseDto> {

    @Override
    public EventRestResponseDto transform(Event from) {
        if (from == null) {
            return null;
        }

        return EventRestResponseDto.builder()
                .eventId(from.getEventId())
                .title(from.getTitle())
                .location(from.getLocation())
                .startTimeStamp(from.getStartTimeStamp().getEpochSecond())
                .endTimeStamp(from.getEndTimeStamp().getEpochSecond())
                .build();
    }
}
