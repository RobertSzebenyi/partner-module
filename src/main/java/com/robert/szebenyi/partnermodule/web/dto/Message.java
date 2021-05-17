package com.robert.szebenyi.partnermodule.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String code;

    private String text;

    private MessageLevel level;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String reference;

}
