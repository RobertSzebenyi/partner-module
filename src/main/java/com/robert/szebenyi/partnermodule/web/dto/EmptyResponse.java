package com.robert.szebenyi.partnermodule.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmptyResponse implements RestDto {

    private boolean success = true;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ZonedDateTime timestamp;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Message> messages = new ArrayList<>();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TechnicalMessage> technicalMessages = new ArrayList<>();

    public void addMessage(Message message) {
        if (messages == null) {
            messages = new ArrayList<>();
        }

        messages.add(message);
    }

    public void addTechnicalMessage(TechnicalMessage message) {
        if (technicalMessages == null) {
            technicalMessages = new ArrayList<>();
        }

        technicalMessages.add(message);
    }

}