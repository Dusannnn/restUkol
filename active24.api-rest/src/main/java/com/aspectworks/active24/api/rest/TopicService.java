package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.CommentVO;
import com.aspectworks.active24.api.rest.vo.TopicEntity;
import com.aspectworks.active24.api.rest.vo.TopicVO;

import java.util.List;

public interface TopicService {

    void createTopic(TopicEntity topic);

    void deleteTopic(long topicId);

    List<TopicEntity> getAllTopics();


    void createComment(long topicId, CommentVO comment);

    List<CommentVO> getAllComments(long topicId);

//    void sortAscendingByName();
//
//    void sortDescendingByName();
}
