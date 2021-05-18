package com.robert.szebenyi.partnermodule.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.robert.szebenyi.partnermodule.domain.Event;
import com.robert.szebenyi.partnermodule.domain.Seat;
import com.robert.szebenyi.partnermodule.domain.repository.EventRepository;
import com.robert.szebenyi.partnermodule.domain.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Set;


@Component
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BasicDataConfiguration {

    private final EventRepository eventRepository;
    private final SeatRepository seatRepository;

    private final ResourceLoader resourceLoader;

    @PostConstruct
    public void setupDatabase() {

        try {
            ObjectMapper mapper = getConfiguredMapper();

            JSONObject jsonObject = getJsonObjectFromFile("getEvents.json");
            JSONArray jsonArray = jsonObject.getJSONArray("data");

            for (Object eventObject : jsonArray) {
                Event event = mapper.readValue(eventObject.toString(), Event.class);
                JSONObject seatJsonObject = getJsonObjectFromFile("getEvent" + event.getEventId() + ".json");
                JSONArray seatsJsonArray = ((JSONObject) seatJsonObject.get("data")).getJSONArray("seats");
                Set<Seat> seats = mapper.readValue(seatsJsonArray.toString(), new TypeReference<Set<Seat>>() {
                });
                eventRepository.save(event);
                seats.forEach(seat -> seat.setEvent(event));
                seatRepository.saveAll(seats);
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

    }

    private JSONObject getJsonObjectFromFile(String fileName) throws IOException {
        return new JSONObject(new JSONTokener(resourceLoader
                .getResource("classpath:" + fileName).getInputStream()));
    }

    private ObjectMapper getConfiguredMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
}
