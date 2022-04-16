package dev.julioperez.virtualEducation.Shared.Infrastructure.config;

import dev.julioperez.virtualEducation.Announcement.Email.Application.Adapter.MailSenderAdapter;
import dev.julioperez.virtualEducation.Announcement.Email.Application.Service.MailSenderServiceImplementation;
import dev.julioperez.virtualEducation.Announcement.Email.Infrastructure.Gateway.SpringJavaMailer;
import dev.julioperez.virtualEducation.Announcement.Email.Infrastructure.Gateway.ThymeleafMailContentBuilder;
import dev.julioperez.virtualEducation.Backoffice.Auth.Application.ModelMapper.SignupModelMapper;
import dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Delivery.SignupEndPoints;
import dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Repository.SignupAdapterRepository;
import dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Service.SignupServiceImplementation;
import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.App.Security.JwtAuthenticationFilter;
import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao.RefreshTokenDao;
import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao.UserDao;
import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao.UserRolDao;
import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao.VerificationTokenDao;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.ModelMapper.CourseCreatorRequestResponseModelMapper;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.ModelMapper.CourseFinderResponseModelMapper;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.ModelMapper.CourseModelMapper;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.delivery.CourseCreatorEndPoints;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.repository.CourseCreatorAdapterRepository;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.service.CourseCreatorServiceImplementation;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.delivery.CourseFinderEndPoints;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.repository.CourseFinderAdapterRepository;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.service.CourseFinderServiceImplementation;
import dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.Repository.Dao.CourseDao;
import dev.julioperez.virtualEducation.Shared.Application.ModelMapper.MailModelMapper;
import dev.julioperez.virtualEducation.Shared.Application.encodeString.Adapter.StringEncoderAdapter;
import dev.julioperez.virtualEducation.Shared.Application.encodeString.Service.StringEncoderService;
import dev.julioperez.virtualEducation.Shared.Application.encodeString.Service.StringEncoderServiceImplementation;
import dev.julioperez.virtualEducation.Shared.Infrastructure.Gateway.SpringFrameworkStringEncoder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@EnableWebSecurity
@Configuration
@EnableJpaRepositories(basePackages = "dev.julioperez.virtualEducation.*")
@EntityScan(basePackages = "dev.julioperez.virtualEducation.*")
@EnableTransactionManagement
@EnableAutoConfiguration
@ComponentScan(basePackages = {"dev.julioperez.virtualEducation.*"})
@AllArgsConstructor
public class SpringDependenciesConfiguration extends WebSecurityConfigurerAdapter {

    //Backoffice.Course
    private final CourseDao courseDao;
    //Backoffice.Auth
    private final UserDao userDao;
    private final UserRolDao userRolDao;
    private final VerificationTokenDao verificationTokenDao;
    private final RefreshTokenDao refreshTokenDao;
    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    //Announcement.Email
    private final SpringJavaMailer springJavaMailer;
    private final ThymeleafMailContentBuilder thymeleafMailContentBuilder;
    //Shared.EncodeString
    //private final SpringFrameworkStringEncoder springFrameworkStringEncoder;
/*
    public SpringDependenciesConfiguration(CourseDao courseDao, UserDao userDao, UserRolDao userRolDao, VerificationTokenDao verificationTokenDao, RefreshTokenDao refreshTokenDao, SpringJavaMailer springJavaMailer, ThymeleafMailContentBuilder thymeleafMailContentBuilder, SpringFrameworkStringEncoder springFrameworkStringEncoder) {
        this.courseDao = courseDao;
        this.userDao = userDao;
        this.userRolDao = userRolDao;
        this.verificationTokenDao = verificationTokenDao;
        this.refreshTokenDao = refreshTokenDao;
        this.springJavaMailer = springJavaMailer;
        this.thymeleafMailContentBuilder = thymeleafMailContentBuilder;
        this.springFrameworkStringEncoder = springFrameworkStringEncoder;
    }

 */

    /**
     * =======================Backoffice.Course======================
     */
    /**
     * Course/Application/ModelMapper
     */

    @Bean
    public CourseModelMapper courseModelMapper(){
        return new CourseModelMapper();
    }

    @Bean
    public CourseCreatorRequestResponseModelMapper courseCreatorRequestResponseModelMapper(){
        return new CourseCreatorRequestResponseModelMapper();
    }

    @Bean
    public CourseFinderResponseModelMapper courseFinderResponseModelMapper(){
        return new CourseFinderResponseModelMapper();
    }

    /**
     * Course/Application/Creator
     */

    @Bean
    public CourseCreatorAdapterRepository courseCreatorRepository(){
        return new CourseCreatorAdapterRepository(courseDao, courseModelMapper());
    }

    @Bean
    public CourseCreatorServiceImplementation courseCreatorServiceImplementation(){
        return new CourseCreatorServiceImplementation(courseCreatorRepository());
    }

    @Bean
    public CourseCreatorEndPoints courseCreatorController(){
        return new CourseCreatorEndPoints(courseCreatorServiceImplementation(), courseCreatorRequestResponseModelMapper());
    }

    /**
     *Application/Course/Finder
     */

    @Bean
    public CourseFinderAdapterRepository courseFinderRepository(){
        return new CourseFinderAdapterRepository(courseDao, courseModelMapper());
    }

    @Bean
    CourseFinderServiceImplementation courseFinderServiceImplementation(){
        return new CourseFinderServiceImplementation(courseFinderRepository());
    }

    @Bean
    CourseFinderEndPoints courseFinderController(){
        return new CourseFinderEndPoints(courseFinderServiceImplementation(), courseFinderResponseModelMapper());
    }

    /**
     * =======================Backoffice.Auth======================
     */

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
                stringEncoderService(),
                signupModelMapper(),
                mailSenderServiceImplementation(),
                mailModelMapper());
    }

    @Bean
    public SignupEndPoints signupController(){
        return new SignupEndPoints(signupServiceImplementation(), signupModelMapper());
    }

    /**
     * Auth/Infrastructure
     */

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/signup/**")
                .permitAll()
                .anyRequest()
                .authenticated();
        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



    /**
     * =======================Announcement.Email======================
     */

    /**
     * Email/Application/
     */
    @Bean
    public MailSenderAdapter mailSenderAdapter(){
        return new MailSenderAdapter(springJavaMailer);
    }

    @Bean
    public MailSenderServiceImplementation mailSenderServiceImplementation(){
        return new MailSenderServiceImplementation(mailSenderAdapter());
    }

    /**
     * =======================Shared======================
     */
    @Bean
    public MailModelMapper mailModelMapper(){
        return new MailModelMapper();
    }

    @Bean
    public StringEncoderAdapter stringEncoderAdapter(){
        return new StringEncoderAdapter(springFrameworkStringEncoder());
    }

    @Bean
    public StringEncoderService stringEncoderService(){
        return new StringEncoderServiceImplementation(stringEncoderAdapter());
    }

    @Bean
    public SpringFrameworkStringEncoder springFrameworkStringEncoder(){
        return new SpringFrameworkStringEncoder(passwordEncoder());
    }

    /**
     * =======================OTHERS======================
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(10000)).build();
    }
}
