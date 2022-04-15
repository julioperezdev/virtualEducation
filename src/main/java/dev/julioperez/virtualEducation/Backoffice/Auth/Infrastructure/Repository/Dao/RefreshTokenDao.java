package dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao;

import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Model.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface RefreshTokenDao extends JpaRepository<RefreshTokenEntity, Long> {
    /*
    =============================
    String querySaveRefreshToken = "EXEC saveRefreshToken @Token = :token , @CreateDate = :createdate ";
    //            "INSERT INTO RefreshToken (token, createdDate) " +
//            "VALUES( :token , :createdDate  ) RETURNING * ;";
    @Query(value = querySaveRefreshToken, nativeQuery = true)
    RefreshTokenEntity saveRefreshToken(
            @Param("token") String token,
            @Param("createdate") Date createDate
    );

     */

    /*
    =============================
    String queryGetRefreshTokenByToken = "SELECT TOP 1 * FROM REFRESH_TOKEN WHERE token = :token ORDER BY id DESC;";
    @Query(value = queryGetRefreshTokenByToken, nativeQuery = true)
    Optional<RefreshTokenEntity> getRefreshTokenByToken(
            @Param("token") String token
    );

     */
    Optional<RefreshTokenEntity> findFirstByToken(String token);

    /*
    =============================
    String queryDeleteRefreshTokenByToken = "DELETE FROM RefreshToken WHERE token = :token ;";
    @Query(value = queryDeleteRefreshTokenByToken, nativeQuery = true)
    void deleteRefreshTokenByToken(
            @Param("token") String token
    );
     */
    void deleteByToken(String token);
    //Optional<RefreshTokenEntity> findByToken(String token);
}
