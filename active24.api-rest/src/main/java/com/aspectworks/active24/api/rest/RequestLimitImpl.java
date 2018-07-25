package com.aspectworks.active24.api.rest;

import org.ehcache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"file:${restapi.config.dir}/restapi.properties"})
public class RequestLimitImpl {

    @Autowired
    Cache<String, Long> cache;

    @Autowired
    private Environment env;

    private static Logger logger = LoggerFactory.getLogger(RequestLimitImpl.class);
    private long requestCounter;
    @Value("${rest.limit.user.global}")
    private long userRequestLimitGlobal;

    private long userRequestLimit;

    public void assertUserRequestLimit(String userId) {
        setUserRequestLimit(userId);


        if (cache.get(userId) == null) {
            cache.put(userId, 1L);
        }


        requestCounter = cache.get(userId);

        logger.info("NOW HAVE " + String.valueOf(requestCounter));
        logger.info("LIMIT IS: " + String.valueOf(userRequestLimit));

        if (requestCounter == userRequestLimit) {
            throw new RequestLimitExceedeException();
        }
        cache.put(userId, ++requestCounter);
    }

    public void setUserRequestLimit(String userId) {
        if (env.getProperty("rest.limit.user.userId." + userId) == null) {
            userRequestLimit = userRequestLimitGlobal;
        } else {
            this.userRequestLimit = Long.valueOf(env.getProperty("rest.limit.user.userId." + userId));
        }

    }

}
