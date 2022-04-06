package dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model;

import java.util.Date;

public class RefreshToken {
    private Long id;
    private String token;
    private Date createDate;

    public RefreshToken(Long id, String token, Date createDate) {
        this.id = id;
        this.token = token;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
