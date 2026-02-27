package org.example.lunaris.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PreCadastroNotFoundException extends RuntimeException {
    public PreCadastroNotFoundException(String message) {
        super(message);
    }
}
