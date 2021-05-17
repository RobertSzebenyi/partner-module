package com.robert.szebenyi.partnermodule.services;

import com.robert.szebenyi.partnermodule.domain.Event;
import com.robert.szebenyi.partnermodule.domain.repository.EventRepository;
import com.robert.szebenyi.partnermodule.domain.repository.SeatRepository;
import com.robert.szebenyi.partnermodule.web.dto.EventSeatsRestDto;
import com.robert.szebenyi.partnermodule.web.transformer.SeatToSeatRestDtoTransformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class EventService {

    private final EventRepository eventRepository;
    private final SeatRepository seatRepository;

    private final SeatToSeatRestDtoTransformer seatToSeatRestDtoTransformer;

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public EventSeatsRestDto getEventSeats(int eventId) {
        return EventSeatsRestDto.builder()
                .eventId(eventId)
                .seats(seatToSeatRestDtoTransformer.transformList(seatRepository.findAllByEvent_EventId(eventId)))
                .build();
    }

}
