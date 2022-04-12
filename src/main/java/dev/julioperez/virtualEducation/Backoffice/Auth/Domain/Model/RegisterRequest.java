package dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model;

import java.util.Objects;

public class RegisterRequest {
    private String email;
    private String username;
    private String password;
    private int idRol;

    public RegisterRequest(String email, String username, String password, int idRol) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.idRol = idRol;
    }

    public Boolean validateFields(){
        return validateUsername() || validatePassword()  || validateIdRol();
    }

    private Boolean validateUsername(){
        return Objects.equals(username, null) || Objects.equals(username, "");
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
}
