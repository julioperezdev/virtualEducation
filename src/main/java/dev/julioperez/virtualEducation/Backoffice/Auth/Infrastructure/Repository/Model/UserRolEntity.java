package dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "USER_ROL", schema = "VIRTUAL_EDUCATION")
public class UserRolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ROL_SEQUENCE")
    @SequenceGenerator(name = "USER_ROL_SEQUENCE", allocationSize = 1)
    private Long id;
    @Column(unique = true, nullable = false)
    private String description;
}
