package com.robert.szebenyi.partnermodule.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.CascadeType.PERSIST;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString()
public class Seat {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "reserved", nullable = false)
    private boolean reserved;

    @ManyToOne(cascade = PERSIST)
    @JoinColumn(name = "eventId", nullable = false)
    private Event event;

}