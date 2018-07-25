package com.aspectworks.active24.api.rest;

import org.ehcache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class RequestLimitImpl {

    @Autowired
    Cache<String, Long> cache;

    private static Logger logger = LoggerFactory.getLogger(RequestLimitImpl.class);
    private long requestCounter = 0L;
    private long userRequestLimitGlobal = 10;
    private long userRequestLimit = 20;


    public void assertUserRequestLimit(String userId) {
        if (cache.get(userId) == null) {
            cache.put(userId, 0L);
        }

        requestCounter = cache.get(userId);

        if (requestCounter > userRequestLimit) {
            throw new RequestLimitExceedeException();
        }
        cache.put(userId, ++requestCounter);
    }

    public void setUserRequestLimit(String userId) {
        if (userId.equals(null)) {
            this.userRequestLimit = userRequestLimitGlobal;
        } else {
            this.userRequestLimit = 5;
        }
    }

//userRequestLimit = $rest.limit.user.userId; else {userRequestLimit = rest.limit.user.global}


}
