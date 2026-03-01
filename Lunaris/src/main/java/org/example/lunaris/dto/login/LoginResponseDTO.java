package org.example.lunaris.dto.login;

public class LoginResponseDTO {
    String token;

    public LoginResponseDTO() {
    }
    public LoginResponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
