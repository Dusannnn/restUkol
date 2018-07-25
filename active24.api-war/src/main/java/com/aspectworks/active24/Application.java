package com.aspectworks.active24;


import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.xml.XmlConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.*;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import static org.ehcache.config.builders.CacheManagerBuilder.newCacheManager;

@SpringBootApplication
@EnableCaching
public class Application {
    final static Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        logger.info("application started");}

        @Bean
        public Cache<String, Long> cache(){
            Configuration xmlConfig = new XmlConfiguration(Application.class.getResource("/cache/ehcache.xml"));
            CacheManager cacheManager = newCacheManager(xmlConfig);
            cacheManager.init();
            Cache<String, Long> cache = cacheManager.getCache("basicCache", String.class, Long.class);
            return cache;
        }


}
