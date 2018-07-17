package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.CommentVO;
import com.aspectworks.active24.api.rest.vo.TopicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    TopicService topicService;

    @Autowired
    CommentService commentService;


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void creatTopic(@RequestBody TopicVO topic){
        topic.setDateCreated(new Date());
        topicService.createTopic(topic);
        System.out.println("Creating new topic: " + topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{topicId}")
    public void deleteTopic(@PathVariable("topicId") long topicId){
        topicService.deleteTopic(topicId);
        System.out.println("Deleting topic with id: " + topicId);
    }

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<TopicVO> getAllTopics(){
        return topicService.getAllTopics();
    }



    @RequestMapping(method = RequestMethod.POST, value = "/{topicId}/comments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createComment(@RequestBody CommentVO comment){
        commentService.createComment(comment);
        System.out.println("Creating new comment: " + comment);
    }

//    @RequestMapping(method = RequestMethod.DELETE, value = "/{commentId}")
//    public void deleteComment(@PathVariable("commentId") long commentId){
//        commentService.deleteComment(commentId);
//        System.out.println("Deleting comment with id: " + commentId);
//    }
//
    @RequestMapping(method = RequestMethod.GET, value = "/{topicId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<CommentVO> getAllComments(){
        return commentService.getAllComments();
    }



}
