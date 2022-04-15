package dev.julioperez.virtualEducation.Announcement.Email.Infrastructure.Config;

import dev.julioperez.virtualEducation.Announcement.Email.Infrastructure.Gateway.SpringJavaMailer;
import dev.julioperez.virtualEducation.Announcement.Email.Infrastructure.Gateway.ThymeleafMailContentBuilder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"dev.julioperez.virtualEducation.Announcement.Email"})
public class AnnouncementEmailSpringDependenciesConfiguration {

    private final SpringJavaMailer springJavaMailer;
    private final ThymeleafMailContentBuilder thymeleafMailContentBuilder;

    public AnnouncementEmailSpringDependenciesConfiguration(SpringJavaMailer springJavaMailer, ThymeleafMailContentBuilder thymeleafMailContentBuilder) {
        this.springJavaMailer = springJavaMailer;
        this.thymeleafMailContentBuilder = thymeleafMailContentBuilder;
    }
}
