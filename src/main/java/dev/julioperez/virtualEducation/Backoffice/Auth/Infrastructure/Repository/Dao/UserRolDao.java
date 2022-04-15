package dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao;

import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Model.UserRolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolDao extends JpaRepository<UserRolEntity, Long> {

}
