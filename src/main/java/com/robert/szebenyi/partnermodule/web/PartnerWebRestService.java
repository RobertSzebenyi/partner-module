package com.robert.szebenyi.partnermodule.web;


import com.robert.szebenyi.partnermodule.config.PartnerRestService;
import com.robert.szebenyi.partnermodule.services.EventService;
import com.robert.szebenyi.partnermodule.web.dto.EventRestDto;
import com.robert.szebenyi.partnermodule.web.dto.EventSeatsRestDto;
import com.robert.szebenyi.partnermodule.web.dto.Response;
import com.robert.szebenyi.partnermodule.web.transformer.EventToEventRestDtoTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@Service
@RequiredArgsConstructor
@Path("/")
public class PartnerWebRestService implements PartnerRestService {

    private final EventService eventService;

    private final EventToEventRestDtoTransformer eventToEventRestDtoTransformer;

    @GET
    @Path("/getEvents")
    public Response<List<EventRestDto>> getEvents() {

        return eventToEventRestDtoTransformer.transformToResponseList(eventService.getEvents());
    }

    @GET
    @Path("/getEvent")
    public Response<EventSeatsRestDto> getEvent(@QueryParam("id") int eventId) {

        return new Response<>(eventService.getEventSeats(eventId));
    }
}