package dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @Column(name = "id")
    private Long id;

    private String username;

    private String password;

    private String email;

    private Date created;

    private Boolean enable;

    @Column(name = "idrol")
    private int idRol;

    public UserEntity() {
    }

    public UserEntity(Long id, String username, String password, String email, Date created, Boolean enable, Integer idRol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.created = created;
        this.enable = enable;
        this.idRol = idRol;
    }

    public UserEntity(String username, String password, String email, Date created, Boolean enable, Integer idRol) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.created = created;
        this.enable = enable;
        this.idRol = idRol;
    }
}