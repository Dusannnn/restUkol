package com.aspectworks.active24;


import com.aspectworks.active24.api.rest.TopicServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
@EnableCaching
public class Application {

    public static void main(String[] args) {
                SpringApplication.run(Application.class, args);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.register(CacheConfig.class);
        ctx.refresh();

        TopicServiceImpl topicService = ctx.getBean(TopicServiceImpl.class);

        System.out.println(topicService.getTopicById(1));

        System.out.println(topicService.getTopicById(1));

        System.out.println(topicService.getTopicById(2));

    }
}
