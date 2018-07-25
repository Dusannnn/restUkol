package com.aspectworks.active24.api.rest;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.xml.XmlConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.ehcache.config.builders.CacheManagerBuilder.newCacheManager;

public class RequestLimitImpl implements RequestLimit {

    private static Logger logger = LoggerFactory.getLogger(RequestLimit.class);
    private long requestCounter;
    private long userRequestLimit = 10;



public void assertUserRequestLimit(String userId){


    Configuration xmlConfig = new XmlConfiguration(RequestLimitImpl.class.getResource("/cache/ehcache.xml"));
    try (CacheManager cacheManager = newCacheManager(xmlConfig)) {
        cacheManager.init();

        Cache<Long, String> basicCache = cacheManager.getCache("basicCache", Long.class, String.class);

        logger.info("Putting to cache");
        basicCache.put(1L, "FirstValue");

        logger.info(basicCache.get(1L));

        basicCache.put(1L, "SecondValue");
        logger.info(basicCache.get(1L));

        logger.info("Closing cache manager");
    }

    logger.info("Exiting");





    // requestCounter =  cache.get requestCount;
    requestCounter = 0;

    if (requestCounter==0)requestCounter=0;

    //userRequestLimit = $rest.limit.user.userId; else {userRequestLimit = rest.limit.user.global}


    if (requestCounter > userRequestLimit) {
        throw new RequestLimitExceedeException();
    }
    requestCounter++;

}
}
