package PedroNunesDev.ConsultaDDD.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class DtoRequest {

    @Email
    private String email;
    @NotBlank
    private String request;

    public DtoRequest(String email, String request) {
        this.email = email;
        this.request = request;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
