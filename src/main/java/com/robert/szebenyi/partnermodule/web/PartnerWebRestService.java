package com.robert.szebenyi.partnermodule.web;


import com.robert.szebenyi.partnermodule.config.PartnerRestService;
import com.robert.szebenyi.partnermodule.exception.PartnerValidationException;
import com.robert.szebenyi.partnermodule.services.EventService;
import com.robert.szebenyi.partnermodule.web.dto.EventRestResponseDto;
import com.robert.szebenyi.partnermodule.web.dto.EventSeatsRestResponseDto;
import com.robert.szebenyi.partnermodule.web.dto.ReserveRestRequestDto;
import com.robert.szebenyi.partnermodule.web.dto.ReserveRestResponseDto;
import com.robert.szebenyi.partnermodule.web.dto.Response;
import com.robert.szebenyi.partnermodule.web.transformer.EventToEventRestDtoTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    public Response<List<EventRestResponseDto>> getEvents() {
        return eventToEventRestDtoTransformer.transformToResponseList(eventService.getEvents());
    }

    @GET
    @Path("/getEvent")
    public Response<EventSeatsRestResponseDto> getEvent(@QueryParam("id") int eventId) throws PartnerValidationException {

        return new Response<>(eventService.getEventSeats(eventId));
    }

    @POST
    @Path("/reserve")
    public Response<ReserveRestResponseDto> getEvent(@Valid ReserveRestRequestDto reserveRestRequestDto) throws PartnerValidationException {

        return new Response<>(eventService.reserveSeat(reserveRestRequestDto));
    }
}