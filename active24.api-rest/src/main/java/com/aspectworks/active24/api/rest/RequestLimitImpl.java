package com.aspectworks.active24.api.rest;

import ch.qos.logback.classic.Logger;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"file:${restapi.config.dir}/restapi.properties"})
public class RequestLimitImpl {

    @Autowired
    Cache cache;

    @Autowired
    private Environment env;

    private static Logger logger = (Logger) LoggerFactory.getLogger(RequestLimitImpl.class);
    private long requestCounter;
    @Value("${rest.limit.user.global}")
    private long userRequestLimitGlobal;

    private long userRequestLimit;

    public void assertUserRequestLimit(String userId) {

        setUserRequestLimit(userId);

        if (cache.get(userId) == null) {
            Element element = new Element(userId, 1L);
            cache.put(element);
        }

        Element element = cache.get(userId);
        String val = String.valueOf(element.getObjectValue());
        requestCounter = Long.valueOf(val);
        if (requestCounter == userRequestLimit) {
            throw new RequestLimitExceedeException();
        }

        Element newElement = new Element(userId, ++requestCounter);

        double timeToLiveMs = ((newElement.getCreationTime() + newElement.getTimeToLive() * 1000) - element.getCreationTime());
        newElement.setTimeToLive((int) Math.ceil((element.getTimeToLive() * 1000 - timeToLiveMs) / 1000));
        cache.put(newElement);

    }

    public void setUserRequestLimit(String userId) {
        if (env.getProperty("rest.limit.user.userId." + userId) == null) {
            userRequestLimit = userRequestLimitGlobal;
        } else {
            this.userRequestLimit = Long.valueOf(env.getProperty("rest.limit.user.userId." + userId));
        }

    }
}
