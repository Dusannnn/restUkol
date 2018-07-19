package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    void deleteByUsername(String name);
}
