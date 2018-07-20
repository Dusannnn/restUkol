package com.aspectworks.active24.api.rest;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PreDestroy;
import javax.cache.annotation.CacheResult;

@CacheResult
public class RequestLimitServiceImpl {

    @Autowired
//inject the cache manager
    private javax.cache.CacheManager cacheManager;
//    private Cache < String, List < AlertEntry >> getAlertsCache() {
//
//        return cacheManager.getCache(CacheNames.Alerts.name());
//
//    }

    @Autowired
    UserRepository userRepository;

//close the cache manager upon bean destruction for proper cache file persistence

    @PreDestroy
    public void close() {
        cacheManager.close();
    }

    public void assertUserRequestLimit(String userName){
        userRepository.findByUsername(userName);




    }

//    počet volání REST API uživatelem v časovém úseku = získat z cache (viz níže), pokud není ještě v cache nastavit na 0.
//    povolený limit = rest.limit.user.userId.<userId> je definováno ? rest.limit.user.userId.<userId> : rest.limit.user.global
//if(povolený limit <= počet volání REST API uživatelem v časovém úseku)
//
//    { throw new RequestLimitExceededException(); }
//
//    počet volání REST API uživatelem inkrementovat o 1 a uložit do cache
}
