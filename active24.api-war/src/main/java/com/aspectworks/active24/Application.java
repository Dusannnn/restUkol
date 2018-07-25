package com.aspectworks.active24;


import com.aspectworks.active24.api.rest.RequestLimit;
import com.aspectworks.active24.api.rest.RequestLimitImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.*;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Application {
    final static Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        logger.info("application started");

        RequestLimitImpl requestLimit = new RequestLimitImpl();
        requestLimit.assertUserRequestLimit("hah");
    }
}
