package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.TopicEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface TopicRepository extends JpaRepository<TopicEntity, Long> {
    TopicEntity findByTopicId(long topicId);
    void deleteByTopicId(long topicId);

    List<TopicEntity> findAllByContentContainingIgnoreCaseOrTopicNameContainingIgnoreCase(String textinContent, String textInName);

   // List<TopicEntity> findByTopicIdOrderByFirstnameAsc(String lastname);
}
