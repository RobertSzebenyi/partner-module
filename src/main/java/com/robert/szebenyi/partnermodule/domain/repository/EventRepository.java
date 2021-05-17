package com.robert.szebenyi.partnermodule.domain.repository;

import com.robert.szebenyi.partnermodule.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
