package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.TopicVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {


    List<TopicVO> topics = new ArrayList<>();


    @Override
    public void createTopic(TopicVO topic){
        topics.add(topic);

    }

    @Override
    public void deleteTopic(long topicId) {
        for (TopicVO topic : topics){
            if (topic.getTopicId()==topicId){
                topics.remove(topic);
            }
        }

    }

    public List<TopicVO> getAllTopics(){
        return topics;
    }
//    @Override
//    public void sortAscendingByName() {
//        Collections.sort(topics);
//    }
//
//    @Override
//    public void sortDescendingByName() {
//        Collections.sort(topics, Collections.reverseOrder());


}