package org.example.lunaris.exception.dto;

import java.util.Map;

public class BadRequestDTO {
    private int status;
    private String error;
    private String messagem;
    private Map<String, String> errors;

    public BadRequestDTO(int status, String error, String messagem, Map<String, String> errors) {
        this.status = status;
        this.error = error;
        this.messagem = messagem;
        this.errors = errors;
    }

    public BadRequestDTO() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessagem() {
        return messagem;
    }

    public void setMessagem(String messagem) {
        this.messagem = messagem;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
