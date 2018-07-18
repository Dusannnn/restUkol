package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.CommentVO;
import com.aspectworks.active24.api.rest.vo.TopicEntity;
import com.aspectworks.active24.api.rest.vo.TopicVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {


    List<TopicEntity> topics = new ArrayList<>();


    @Override
    public void createTopic(TopicEntity topic) {
        topics.add(topic);

    }

    @Override
    public void deleteTopic(long topicId) {
        for (TopicEntity topic : topics) {
            if (topic.getTopicId() == topicId) {
                topics.remove(topic);
            }
        }

    }

    public List<TopicEntity> getAllTopics() {
        return topics;
    }

    public void sortByNameAsc(){

    }

    @Override
    public void createComment(long topicId, CommentVO comment) {
        topics.forEach(topic -> { if (topic.getTopicId() == topicId) {
                topic.getComments().add(comment);
            }
        });
    }


    @Override
    public List<CommentVO> getAllComments(long topicId) {
        for (TopicEntity topicEntity : topics)
            if (topicEntity.getTopicId() == (topicId))
                return topicEntity.getComments();
        return new ArrayList<>();
    }
}

