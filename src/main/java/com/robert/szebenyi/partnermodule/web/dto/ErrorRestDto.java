package com.robert.szebenyi.partnermodule.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Setter
@RequiredArgsConstructor
public class ErrorRestDto {

    private final String message;

    private final int errorCode;

}