package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.TopicVO;

import java.util.List;

public interface TopicService {

    void createTopic(TopicVO topic);

    void deleteTopic(long topicId);

    List<TopicVO> getAllTopics();

//    void sortAscendingByName();
//
//    void sortDescendingByName();
}
