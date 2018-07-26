package com.aspectworks.active24;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class Application {
    final static Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        logger.info("application started");}

        @Bean
        public Cache cache(){
        CacheManager cm = CacheManager.newInstance("C:/Users/Dusan.Petren/Desktop/ehcache2/restUkol/active24.api-rest/src/main/resources/cache/ehcache.xml");
        Cache basicCache = cm.getCache("basicCache");
        return basicCache;
        }
}

