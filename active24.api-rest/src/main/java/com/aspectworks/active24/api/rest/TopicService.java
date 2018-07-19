package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.CommentVO;
import com.aspectworks.active24.api.rest.vo.TopicEntity;

import java.util.List;

public interface TopicService {

    void createTopic(TopicEntity topic);

    void deleteTopic(long topicId);

    List<TopicEntity> getAllTopics(String text, String sortBy, String sortType);

    void createComment(long topicId, CommentVO comment);

    List<CommentVO> getAllComments(long topicId);

    //public List<TopicEntity> searchTopicWithText(String text);

    void sortByNameAsc();

    void sortByNameDesc();

    void sortByDateAsc();

    void sortByDateDesc();

}
