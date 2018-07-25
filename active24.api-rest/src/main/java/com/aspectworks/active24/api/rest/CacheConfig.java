package com.aspectworks.active24.api.rest;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.xml.XmlConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import static org.ehcache.config.builders.CacheManagerBuilder.newCacheManager;
public class CacheConfig {
    final static Logger logger = LoggerFactory.getLogger(CacheConfig.class);

    public void createCacheFromXML(){

    Configuration xmlConfig = new XmlConfiguration(RequestLimitImpl.class.getResource("/cache/ehcache.xml"));
    try (CacheManager cacheManager = newCacheManager(xmlConfig)) {
        cacheManager.init();
    }
//        Cache<Long, Long> basicCache = cacheManager.getCache("basicCache", Long.class, Long.class);
//
//        logger.info("Putting to cache");
//        basicCache.put(1L, requestCounter);
//
//        logger.info("Retrieved '{}'", value);
//
//        logger.info("Closing cache manager");
//    }
//
//    logger.info("Exiting");
}}
