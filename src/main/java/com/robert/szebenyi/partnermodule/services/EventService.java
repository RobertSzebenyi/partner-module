package com.robert.szebenyi.partnermodule.services;

import com.robert.szebenyi.partnermodule.domain.Event;
import com.robert.szebenyi.partnermodule.domain.Seat;
import com.robert.szebenyi.partnermodule.domain.repository.EventRepository;
import com.robert.szebenyi.partnermodule.domain.repository.SeatRepository;
import com.robert.szebenyi.partnermodule.exception.PartnerValidationException;
import com.robert.szebenyi.partnermodule.web.dto.EventSeatsRestResponseDto;
import com.robert.szebenyi.partnermodule.web.dto.ReserveRestRequestDto;
import com.robert.szebenyi.partnermodule.web.dto.ReserveRestResponseDto;
import com.robert.szebenyi.partnermodule.web.transformer.SeatToSeatRestDtoTransformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

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

    public EventSeatsRestResponseDto getEventSeats(int eventId) {
        List<Seat> seats = seatRepository.findAllByEvent_EventId(eventId);
        if (seats.isEmpty()) {
            throw new PartnerValidationException("Nem létezik ilyen esemény!", 90001);
        }
        return EventSeatsRestResponseDto.builder()
                .eventId(eventId)
                .seats(seatToSeatRestDtoTransformer.transformList(seatRepository.findAllByEvent_EventId(eventId)))
                .build();
    }

    public ReserveRestResponseDto reserveSeat(ReserveRestRequestDto reserveRestRequestDto) {
        Seat seat = seatRepository.findByEvent_EventIdAndAndSeatId((int) reserveRestRequestDto.getEventId(),
                "S" + reserveRestRequestDto.getSeatId());

        if (seat == null) {
            throw new PartnerValidationException("Nem létezik ilyen szék!", 90002);
        }
        if (seat.isReserved()) {
            throw new PartnerValidationException("Már lefoglalt székre nem lehet jegyet eladni!", 900010);
        }
        seat.setReserved(true);
        return ReserveRestResponseDto.builder()
                .reservationId(new Random().nextLong())
                .build();
    }
}
