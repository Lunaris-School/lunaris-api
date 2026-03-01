package org.example.lunaris.exception;

import org.example.lunaris.exception.dto.BadRequestDTO;
import org.example.lunaris.exception.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ManipuladorGlobalDeExcecoes {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BadRequestDTO> badRequestException(
            MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> errors = new HashMap<>();

        methodArgumentNotValidException
                .getBindingResult()
                .getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        BadRequestDTO errorsDTO =
                new BadRequestDTO(
                        HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.name(),
                        "Erro na validação da requisição:",
                        errors);

        return new ResponseEntity<>(errorsDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> notFoundException(NotFoundException notFoundException) {
        ErrorDTO errorDTO = new ErrorDTO(HttpStatus.NOT_FOUND.value(), notFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }
    @ExceptionHandler(PreCadastroNotFoundException.class)
    public ResponseEntity<ErrorDTO> preCadastroNotFoundException(PreCadastroNotFoundException preCadastroNotFoundException) {
        ErrorDTO errorDTO = new ErrorDTO(HttpStatus.CONFLICT.value(), preCadastroNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDTO);
    }
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ErrorDTO> duplicateException(DuplicateException duplicateException) {
        ErrorDTO errorDTO = new ErrorDTO(HttpStatus.CONFLICT.value(), duplicateException.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDTO);
    }
}
