package dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model;

import java.util.Objects;

public class RegisterRequest {
    private String email;
    private String password;
    private Long idRol;

    public RegisterRequest(String email, String password, Long idRol) {
        this.email = email;
        this.password = password;
        this.idRol = idRol;
    }

    public Boolean validateFields(){
        return validateEmail() || validatePassword()  || validateIdRol();
    }

    private Boolean validateEmail(){
        return Objects.equals(email, null) || Objects.equals(email, "");
    }

    private Boolean validatePassword(){
        return Objects.equals(password, null) || Objects.equals(password, "");
    }

    private Boolean validateIdRol(){
        return Objects.equals(idRol, null) || idRol <= 0;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }
}
