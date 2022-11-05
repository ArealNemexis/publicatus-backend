package dev.arealnemexis.publicatusnotes.exception;

import dev.arealnemexis.publicatusnotes.datasource.dtos.response.DefaultResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PublicatusExceptionHandler {

    @ExceptionHandler(value = GenericException.class)
    public ResponseEntity<DefaultResponseDto<?>> handleException(GenericException exception) {
        DefaultResponseDto<?> errorResponse = new DefaultResponseDto<>(exception.getMessage(), exception.getStatus().value());
        return new ResponseEntity<>(errorResponse, exception.getStatus());
    }
}
