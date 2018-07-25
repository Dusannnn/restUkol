package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.CommentEntity;
import com.aspectworks.active24.api.rest.vo.CommentVO;
import com.aspectworks.active24.api.rest.vo.TopicEntity;
import com.aspectworks.active24.api.rest.vo.TopicVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {


    final Logger logger = (Logger) LoggerFactory.getLogger(TopicServiceImpl.class);



    @Autowired
    TopicRepository topicRepository;


    @Override
    public void createTopic(TopicVO topic){
        TopicEntity topicEntity = new TopicEntity(topic);
        topicRepository.save(topicEntity);
    }


    @Override
    public void deleteTopic(long topicId) {
        topicRepository.deleteByTopicId(topicId);
        logger.info("Entity succsessfully deleted" + topicId);
    }

    @Override
    @CacheEvict(value = "basicCache")
    public List<TopicEntity> getAllTopics(String text, String sortBy, String sortType) {
        if (sortBy == null) {
            sortBy = "name";
        }
        if (sortType == null) {
            sortType = "asc";
        }

        if (sortBy.equals("name")) {
            if (sortType != null) {
                if (sortType.equals("asc"))
                    sortByNameAsc();
                else if (sortType.equals("desc"))
                    sortByNameDesc();

            } else sortByNameAsc(); //default sort
        } else if (sortBy.equals("date")) {
            if (sortType != null) {
                if (sortType.equals("asc"))
                    sortByDateAsc();
                else if (sortType.equals("desc"))
                    sortByDateDesc();

            } else sortByDateAsc(); //default sort
        }

        if (text == null) {
            System.out.println("From Database");
            return topicRepository.findAll();
        } else {
            return topicRepository.findAllByContentContainingIgnoreCaseOrTopicNameContainingIgnoreCase(text, text);
        }
    }


    @Override
    public void sortByNameAsc() {
        //Collections.sort(topics, (TopicEntity e1, TopicEntity e2) -> e1.getTopicName().compareTo(e2.getTopicName()));
        topicRepository.findAll().sort((TopicEntity e1, TopicEntity e2) -> e1.getTopicName().compareTo(e2.getTopicName()));
        logger.info("sorting by name asc");
    }

    @Override
    public void sortByNameDesc() {
        //Collections.sort(topics, (TopicEntity e1, TopicEntity e2) -> e2.getTopicName().compareTo(e1.getTopicName()));
        topicRepository.findAll().sort((TopicEntity e1, TopicEntity e2) -> e2.getTopicName().compareTo(e1.getTopicName()));
        logger.info("sorting by name desc");
    }

    @Override
    public void sortByDateAsc() {
        //Collections.sort(topics, (TopicEntity e1, TopicEntity e2) -> e1.getDateCreated().compareTo(e2.getDateCreated()));
        topicRepository.findAll().sort((TopicEntity e1, TopicEntity e2) -> e1.getDateCreated().compareTo(e2.getDateCreated()));
        logger.info("sorting by date asc");
    }

    @Override
    public void sortByDateDesc() {
        //Collections.sort(topics, (TopicEntity e1, TopicEntity e2) -> e2.getDateCreated().compareTo(e1.getDateCreated()));
        topicRepository.findAll().sort((TopicEntity e1, TopicEntity e2) -> e2.getDateCreated().compareTo(e1.getDateCreated()));
        logger.info("sorting by date desc");
    }


    @Override
    public void createComment(long topicId, CommentVO comment) {
        CommentEntity commentEntity = new CommentEntity(comment);
        TopicEntity entity = topicRepository.findByTopicId(topicId);
        entity.getComments().add(commentEntity);
        topicRepository.save(entity);
        logger.info("Adding comment " + comment.getCommentId() + "to topic" + topicId);
    }


    @Override
    public List<CommentEntity> getAllComments(long topicId) {
        logger.info("Getting comments from topic:" + topicId);
        return topicRepository.findByTopicId(topicId).getComments();
    }

}

