package dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao;

import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Model.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Optional;

public interface UserDao {

    String queryCreateUser =
            "EXEC createUser @Username = :username , @Password = :password , @Email = :email , @Created = :created, @Enable = :enable , @IdRol = :idRol ";
    @Query(value = queryCreateUser, nativeQuery = true)
    UserEntity createUser(
            @Param("username") String username,
            @Param("password") String password,
            @Param("email") String email,
            @Param("created") Date created,
            @Param("enable") boolean enable,
            @Param("idRol") int idRol);



    String queryUpdateEnableUser =
            "EXEC updateEnableUser @Id = :id , @Enable = :enable";
    @Query(value = queryUpdateEnableUser, nativeQuery = true)
    Optional<UserEntity> updateEnableUser(
            @Param("id") Long userid,
            @Param("enable") boolean enable);


    String queryFindByUsername =
            "SELECT * FROM users WHERE username = :username ;";
    @Query(value = queryFindByUsername, nativeQuery = true)
    Optional<UserEntity> findByUsername(
            @Param("username") String username);

    String queryFindById =
            "SELECT * FROM users " +
                    "WHERE id = :id ;";
    @Query(value = queryFindById, nativeQuery = true)
    Optional<UserEntity> findUserById(
            @Param("id") Long userid);

}
