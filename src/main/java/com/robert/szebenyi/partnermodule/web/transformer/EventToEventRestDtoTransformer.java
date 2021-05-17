package com.robert.szebenyi.partnermodule.web.transformer;

import com.robert.szebenyi.partnermodule.domain.Event;
import com.robert.szebenyi.partnermodule.web.dto.EventRestDto;
import org.springframework.stereotype.Component;

@Component
public class EventToEventRestDtoTransformer extends BaseRestTransformer<Event, EventRestDto> {

    @Override
    public EventRestDto transform(Event from) {
        if (from == null) {
            return null;
        }

        return EventRestDto.builder()
                .eventId(from.getEventId())
                .title(from.getTitle())
                .location(from.getLocation())
                .startTimeStamp(from.getStartTimeStamp().getEpochSecond())
                .endTimeStamp(from.getEndTimeStamp().getEpochSecond())
                .build();
    }
}
