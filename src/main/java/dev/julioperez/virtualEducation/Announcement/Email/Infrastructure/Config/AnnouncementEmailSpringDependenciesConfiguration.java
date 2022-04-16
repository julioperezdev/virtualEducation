package dev.julioperez.virtualEducation.Announcement.Email.Infrastructure.Config;

import dev.julioperez.virtualEducation.Announcement.Email.Application.Adapter.MailSenderAdapter;
import dev.julioperez.virtualEducation.Announcement.Email.Application.Service.MailSenderServiceImplementation;
import dev.julioperez.virtualEducation.Announcement.Email.Infrastructure.Gateway.SpringJavaMailer;
import dev.julioperez.virtualEducation.Announcement.Email.Infrastructure.Gateway.ThymeleafMailContentBuilder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/*
@Configuration
@EntityScan(basePackages = "dev.julioperez.virtualEducation.Announcement.Email.*")
@ComponentScan(basePackages = {"dev.julioperez.virtualEducation.Announcement.Email.*"})
@EnableAutoConfiguration
@ComponentScan(basePackages = {"dev.julioperez.virtualEducation.Announcement.Email"})
public class AnnouncementEmailSpringDependenciesConfiguration {

    private final SpringJavaMailer springJavaMailer;
    private final ThymeleafMailContentBuilder thymeleafMailContentBuilder;

    public AnnouncementEmailSpringDependenciesConfiguration(SpringJavaMailer springJavaMailer, ThymeleafMailContentBuilder thymeleafMailContentBuilder) {
        this.springJavaMailer = springJavaMailer;
        this.thymeleafMailContentBuilder = thymeleafMailContentBuilder;
    }

    @Bean
    public MailSenderAdapter mailSenderAdapter(){
        return new MailSenderAdapter(springJavaMailer);
    }

    @Bean
    public MailSenderServiceImplementation mailSenderServiceImplementation(){
        return new MailSenderServiceImplementation(mailSenderAdapter());
    }
}


 */