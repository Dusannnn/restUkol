package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.CommentVO;
import com.aspectworks.active24.api.rest.vo.TopicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {


    List<TopicEntity> topics = new ArrayList<>();

    @Autowired
    TopicRepository topicRepository;

    @Override
    public void createTopic(TopicEntity topic) {
        //topics.add(topic);
        topicRepository.save(topic);
        }
        //System.out.println(tr.findAll().get(0).getTopicName());


    @Override
    public void deleteTopic(long topicId) {
//        for (TopicEntity topic : topics) {
//            if (topic.getTopicId() == topicId) {
//                topics.remove(topic);
//            }
//        }
        topicRepository.deleteByTopicId(topicId);
        System.out.println("Entity succsessfully deleted" + topicId);
    }

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
            return topicRepository.findAll();
        } else {
            return topicRepository.findAllByContentContainingIgnoreCaseOrTopicNameContainingIgnoreCase(text, text);


        }
    }



    @Override
    public void sortByNameAsc() {
        //Collections.sort(topics, (TopicEntity e1, TopicEntity e2) -> e1.getTopicName().compareTo(e2.getTopicName()));
        topicRepository.findAll().sort((TopicEntity e1, TopicEntity e2) -> e1.getTopicName().compareTo(e2.getTopicName()));
        System.out.println("sorting by name asc");
    }

    @Override
    public void sortByNameDesc() {
        //Collections.sort(topics, (TopicEntity e1, TopicEntity e2) -> e2.getTopicName().compareTo(e1.getTopicName()));
        topicRepository.findAll().sort((TopicEntity e1, TopicEntity e2) -> e2.getTopicName().compareTo(e1.getTopicName()));
        System.out.println("sorting by name desc");
    }

    @Override
    public void sortByDateAsc() {
        //Collections.sort(topics, (TopicEntity e1, TopicEntity e2) -> e1.getDateCreated().compareTo(e2.getDateCreated()));
        topicRepository.findAll().sort((TopicEntity e1, TopicEntity e2) -> e1.getDateCreated().compareTo(e2.getDateCreated()));
        System.out.println("sorting by date asc");
    }

    @Override
    public void sortByDateDesc() {
        //Collections.sort(topics, (TopicEntity e1, TopicEntity e2) -> e2.getDateCreated().compareTo(e1.getDateCreated()));
        topicRepository.findAll().sort((TopicEntity e1, TopicEntity e2) -> e2.getDateCreated().compareTo(e1.getDateCreated()));
        System.out.println("sorting by date desc");
    }


    @Override
    public void createComment(long topicId, CommentVO comment) {
//        topics.forEach(topic -> {
//            if (topic.getTopicId() == topicId) {
//                topic.getComments().add(comment);
//            }
//        });
//
        topicRepository.findByTopicId(topicId).getComments().add(comment);
    }


    @Override
    public List<CommentVO> getAllComments(long topicId) {
//        for (TopicEntity topicEntity : topics)
//            if (topicEntity.getTopicId() == (topicId))
//                return topicEntity.getComments();
//        return new ArrayList<>();
//
        return topicRepository.findByTopicId(topicId).getComments();
    }

//    @Override
//    public List<TopicEntity> searchTopicWithText(String text) {
////    List<TopicEntity> result = new ArrayList<>();
////        for (TopicEntity tpc : topics){
////            if (tpc.getContent().toLowerCase().contains(text.toLowerCase()) || tpc.getTopicName().toLowerCase().contains(text.toLowerCase())){
////                result.add(tpc);
////            }
////        }
////        return result;
//
//        return null;
//
//    }
}

