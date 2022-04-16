package dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.App.Config;

import dev.julioperez.virtualEducation.Announcement.Email.Application.Service.MailSenderService;
import dev.julioperez.virtualEducation.Backoffice.Auth.Application.ModelMapper.SignupModelMapper;
import dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Delivery.SignupEndPoints;
import dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Repository.SignupAdapterRepository;
import dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Service.SignupServiceImplementation;
import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao.RefreshTokenDao;
import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao.UserDao;
import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao.UserRolDao;
import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao.VerificationTokenDao;
import dev.julioperez.virtualEducation.Shared.Application.ModelMapper.MailModelMapper;
import dev.julioperez.virtualEducation.Shared.Application.encodeString.Service.StringEncoderService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
@Configuration
@EnableJpaRepositories(basePackages = "dev.julioperez.virtualEducation.Backoffice.Auth.*")
//@EnableJpaRepositories(basePackages = "dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao")
@EntityScan(basePackages = "dev.julioperez.virtualEducation.Backoffice.Auth.*")
//@EntityScan(basePackages = "dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model")
@EnableTransactionManagement
@EnableAutoConfiguration
@ComponentScan(basePackages = {"dev.julioperez.virtualEducation.*"})
//@ComponentScan(basePackages = {"dev.julioperez.virtualEducation.Backoffice.Auth.*"})
//@ComponentScan(basePackages = {"dev.julioperez.virtualEducation.Backoffice.Auth"})
public class AuthSpringDependenciesConfiguration {

    private final UserDao userDao;
    private final UserRolDao userRolDao;
    private final VerificationTokenDao verificationTokenDao;
    private final RefreshTokenDao refreshTokenDao;
    private final StringEncoderService stringEncoderService;
    private final MailSenderService mailSenderService;
    private final MailModelMapper mailModelMapper;

    public AuthSpringDependenciesConfiguration(UserDao userDao, UserRolDao userRolDao, VerificationTokenDao verificationTokenDao, RefreshTokenDao refreshTokenDao, StringEncoderService stringEncoderService, MailSenderService mailSenderService, MailModelMapper mailModelMapper) {
        this.userDao = userDao;
        this.userRolDao = userRolDao;
        this.verificationTokenDao = verificationTokenDao;
        this.refreshTokenDao = refreshTokenDao;
        this.stringEncoderService = stringEncoderService;
        this.mailSenderService = mailSenderService;
        this.mailModelMapper = mailModelMapper;
    }

    /**
     * Auth/Application/ModelMapper
     *0/

    @Bean
    public SignupModelMapper signupModelMapper(){
        return new SignupModelMapper();
    }

    /**
     * Auth/Application/signup
     *0/

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
                stringEncoderService,
                signupModelMapper(),
                mailSenderService,
                mailModelMapper);
    }

    @Bean
    public SignupEndPoints signupEndPoints(){
        return new SignupEndPoints(signupServiceImplementation(), signupModelMapper());
    }
}

*/