package com.robert.szebenyi.partnermodule.web;

import com.robert.szebenyi.partnermodule.exception.PartnerValidationException;
import com.robert.szebenyi.partnermodule.web.dto.ErrorRestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PartnerValidationException.class)
    public ResponseEntity<ErrorRestDto> resourceNotFound(PartnerValidationException ex) {

        ErrorRestDto response = new ErrorRestDto(ex.getMessage(), ex.getErrorCode());

        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
