package dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao;

import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Model.VerificationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerificationTokenDao extends JpaRepository<VerificationTokenEntity, Long> {



    String queryCreateToken =
            "EXEC createToken @Token = :token , @Id = :userid ";
//            "INSERT INTO TOKEN (token, userid) " +
//                    "VALUES( :token, :userid) ;";

    /*
    @Query(value = queryCreateToken, nativeQuery = true)
    Optional<VerificationTokenEntity> createToken(
            @Param("token") String token,
            @Param("userid") Long userid);
     */
    //Optional<VerificationTokenEntity>

    /*
    =======================================
    String queryFindByToken =
            "SELECT * FROM token WHERE token = :token ;";
    @Query(value = queryFindByToken, nativeQuery = true)
    Optional<VerificationTokenEntity> findByToken(@Param("token") String token);
 */
    Optional<VerificationTokenEntity> findFirstByToken(String token);

}
