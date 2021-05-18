package com.robert.szebenyi.partnermodule.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.robert.szebenyi.partnermodule.domain.serializer.SeatDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString()
@JsonDeserialize(using = SeatDeserializer.class)
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "seatId", nullable = false)
    private String seatId;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "reserved", nullable = false)
    private boolean reserved;

    @ManyToOne
    @JoinColumn(name = "eventId", nullable = false)
    private Event event;

}