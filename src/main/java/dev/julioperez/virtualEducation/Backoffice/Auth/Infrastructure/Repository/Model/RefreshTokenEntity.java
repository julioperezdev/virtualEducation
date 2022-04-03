package dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "REFRESH_TOKEN")
public class RefreshTokenEntity {
    @Id
    private Long id;
    private String token;

    @Column(name = "createdate")
    private Date createDate;
}
