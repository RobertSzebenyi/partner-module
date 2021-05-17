package com.robert.szebenyi.partnermodule.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString()
public class Event {

    @Id
    @Column(name = "eventId", nullable = false, unique = true)
    private int eventId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "startTimeStamp", nullable = false)
    private Instant startTimeStamp;

    @Column(name = "endTimeStamp", nullable = false)
    private Instant endTimeStamp;

}