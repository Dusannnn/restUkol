package com.aspectworks.active24;


import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.aspectworks.active24.api.rest.TopicController;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
                SpringApplication.run(Application.class, args);
                
    }
}
