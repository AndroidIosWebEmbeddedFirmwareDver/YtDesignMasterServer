package com.yt.design.font.site.api;

import com.yt.design.server.common.web.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
//@SpringBootApplication(scanBasePackages = "com.yt.design.font.site.api", exclude = {ErrorMvcAutoConfiguration.class})
public class ComYtDesignFontSiteApiApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(ComYtDesignFontSiteApiApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ComYtDesignFontSiteApiApplication.class, args);

    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebConfig();
    }
}
