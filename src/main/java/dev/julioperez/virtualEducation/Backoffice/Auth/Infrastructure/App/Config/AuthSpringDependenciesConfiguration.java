package dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.App.Config;

import dev.julioperez.virtualEducation.Backoffice.Auth.Application.ModelMapper.SignupModelMapper;
import dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Delivery.SignupEndPoints;
import dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Repository.SignupAdapterRepository;
import dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Service.SignupServiceImplementation;
import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao.RefreshTokenDao;
import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao.UserDao;
import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao.UserRolDao;
import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao.VerificationTokenDao;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"dev.julioperez.virtualEducation.Backoffice.Auth"})
public class AuthSpringDependenciesConfiguration {

    private final UserDao userDao;
    private final UserRolDao userRolDao;
    private final VerificationTokenDao verificationTokenDao;
    private final RefreshTokenDao refreshTokenDao;

    public AuthSpringDependenciesConfiguration(UserDao userDao, UserRolDao userRolDao, VerificationTokenDao verificationTokenDao, RefreshTokenDao refreshTokenDao) {
        this.userDao = userDao;
        this.userRolDao = userRolDao;
        this.verificationTokenDao = verificationTokenDao;
        this.refreshTokenDao = refreshTokenDao;
    }

    /**
     * Auth/Application/ModelMapper
     */

    @Bean
    public SignupModelMapper signupModelMapper(){
        return new SignupModelMapper();
    }

    /**
     * Auth/Application/signup
     */

    @Bean
    public SignupAdapterRepository signupAdapterRepository(){
        return new SignupAdapterRepository(
                userDao,
                verificationTokenDao,
                userRolDao,
                signupModelMapper());
    }

    @Bean
    public SignupServiceImplementation signupServiceImplementation(){
        return new SignupServiceImplementation(
                signupAdapterRepository(),
                null,
                signupModelMapper(),
                null,
                null);
    }

    @Bean
    public SignupEndPoints signupEndPoints(){
        return new SignupEndPoints(signupServiceImplementation(), signupModelMapper());
    }
}
