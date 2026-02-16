package org.example.lunaris.exception;

import org.example.lunaris.exception.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManipuladorGlobalDeExcecoes {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> notFoundException(NotFoundException notFoundException) {
        ErrorDTO errorDTO = new ErrorDTO(HttpStatus.NOT_FOUND.value(), notFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }
}
