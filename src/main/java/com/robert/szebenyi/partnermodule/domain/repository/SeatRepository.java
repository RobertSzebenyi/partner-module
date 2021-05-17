package com.robert.szebenyi.partnermodule.domain.repository;

import com.robert.szebenyi.partnermodule.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findAllByEvent_EventId(int eventId);
}
