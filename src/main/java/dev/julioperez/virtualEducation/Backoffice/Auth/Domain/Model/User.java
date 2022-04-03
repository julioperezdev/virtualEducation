package dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model;

import java.util.Date;

public class User {

    private Long id;
    private String username;
    private String password;
    private String email;
    private Date created;
    private Boolean enable;
    private Integer idRol;

    public User(Long id, String username, String password, String email, Date created, Boolean enable, Integer idRol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.created = created;
        this.enable = enable;
        this.idRol = idRol;
    }

    public User(String username, String password, String email, Date created, Boolean enable, Integer idRol) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.created = created;
        this.enable = enable;
        this.idRol = idRol;
    }

    public Long getUserId() {
        return id;
    }

    public void setUserId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Boolean isEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
}
